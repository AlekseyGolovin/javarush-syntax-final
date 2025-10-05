package ua.net.agsoft.javarush.crypto;

public class Crypto {

    private final char[] alphabet;
    private final int alphabetLength;
    private int offset;

    public Crypto() {
        this(CryptoAlphabetType.EN_BASIC);
    }

    public Crypto(CryptoAlphabetType alphabetType) {
        alphabet = alphabetType.getAlphabet();
        alphabetLength = alphabet.length;
    }

    private void nextOffset() {
        setOffset(offset + 1);
    }

    public void setOffset(int offset) {
        this.offset = offset;
        if (offset  >= alphabetLength)  this.offset = alphabetLength;
        if (offset  < 0) this.offset  = 0;
    }

    public boolean canSetNextOffset() {
        if (offset < alphabetLength - 1) {
            nextOffset();
            return true;
        } else {
            return false;
        }
    }

    public char encrypt(char srcChar) {
        int pos = -1;
        for (int i = 0; i < alphabetLength; i++) {
            char achar = alphabet[i];
            if (achar == srcChar) {
                pos = i;
                break;
            }
        }
        if (pos < 0) return srcChar;
        pos += offset;
        while (pos >= alphabetLength) {
            pos -= alphabetLength;
        }
        return alphabet[pos];
    }

    public char decrypt(char srcChar) {
        int pos = -1;
        for (int i = 0; i < alphabetLength; i++) {
            char achar = alphabet[i];
            if (achar == srcChar) {
                pos = i;
                break;
            }
        }
        if (pos < 0) return srcChar;
        pos -= offset;
        while (pos < 0) {
            pos += alphabetLength;
        }
        return alphabet[pos];
    }
}
