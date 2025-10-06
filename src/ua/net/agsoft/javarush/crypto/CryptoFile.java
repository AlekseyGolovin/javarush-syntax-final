package ua.net.agsoft.javarush.crypto;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;

public class CryptoFile {

    public static void encryptFile(Path srcFilePath, Path desFilePath, Crypto crypto) {
        try (BufferedReader srcReader = Files.newBufferedReader(srcFilePath);
             BufferedWriter desWriter = Files.newBufferedWriter(desFilePath)) {
            int srcInt;
            while ((srcInt = srcReader.read()) != -1) {
                char srcChar = (char) srcInt;
                char desChar = crypto.encrypt(srcChar);
                desWriter.append(desChar);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void decryptFile(Path srcFilePath, Path desFilePath, Crypto crypto) {
        try (BufferedReader srcReader = Files.newBufferedReader(srcFilePath);
             BufferedWriter desWriter = Files.newBufferedWriter(desFilePath)) {
            int srcInt;
            while ((srcInt = srcReader.read()) != -1) {
                char srcChar = (char) srcInt;
                char desChar = crypto.decrypt(srcChar);
                desWriter.append(desChar);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int getCryptoOffset(Path srcFilePath, Crypto crypto) {
        HashMap<Integer, Integer> offsetRate = new HashMap<>();
        crypto.setOffset(0);
        do {
            int offset = crypto.getOffset();
            int rate = getRate(srcFilePath, crypto);
            System.out.println("getCryptoOffset [" + offset + "]: " + rate);
            offsetRate.put(offset, rate);
        } while (crypto.canSetNextOffset());
        return getCryptoOffsetFromMap(offsetRate);
    }

    public static int getCryptoOffsetFromMap(HashMap<Integer, Integer> offsetRate) {
        int ratePos = 0;
        int maxRate = 0;
        for (var pair : offsetRate.entrySet()) {
            Integer key = pair.getKey();
            Integer value = pair.getValue();
            if (value > maxRate) {
                ratePos = key;
                maxRate = value;
            }
        }
        System.out.println("getCryptoOffset BEST: " + ratePos);
        return ratePos;
    }

    private static int getRate(Path srcFilePath, Crypto crypto) {
        char[] srcFragment = new char[512];
        char[] desFragment = new char[512];
        try (BufferedReader srcReader = Files.newBufferedReader(srcFilePath)) {
            int bufLength = srcReader.read(srcFragment);
            for (int i = 0; i < bufLength; i++) {
                desFragment[i] = crypto.decrypt(srcFragment[i]);
            }
            String text = new String(desFragment, 0, bufLength);
            return getRate(text);
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }

    private static int getRate(String text) {
        String regex = "[^\\p{L}\\s]";
        String clearText = text.replaceAll(regex, " ").trim().toLowerCase();
        String normalizedText = clearText.replaceAll("\\s+", " ");
        int enRate = getEnRate(normalizedText);
        System.out.println("getRate EN: " + enRate);
        int uaRate = getUaRate(normalizedText);
        System.out.println("getRate UA: " + uaRate);
        int ruRate = getRuRate(normalizedText);
        System.out.println("getRate RU: " + ruRate);
        int maxRate = enRate;
        if (uaRate > maxRate) maxRate = uaRate;
        if (ruRate > maxRate) maxRate = ruRate;
        return maxRate;
    }

    private static int getEnRate(String text) {
        return getRate(text, CommonWords.EN);
    }

    private static int getUaRate(String text) {
        return getRate(text, CommonWords.UA);
    }

    private static int getRuRate(String text) {
        return getRate(text, CommonWords.RU);
    }

    private static int getRate(String text, String[] commonWords) {
        text = " " + text + " ";
        int rate = 0;
        for (String commonWord : commonWords) {
            int wordLength = commonWord.length();
            String word = " " + commonWord + " ";
            int lastPos = text.indexOf(word);
            if(lastPos == -1) continue;
            rate++;
            do {
                lastPos = text.indexOf(word, lastPos + wordLength);
                if (lastPos != -1) rate++;
            } while (lastPos != -1);
        }
        return rate;
    }
}
