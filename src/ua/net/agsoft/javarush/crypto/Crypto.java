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
}
