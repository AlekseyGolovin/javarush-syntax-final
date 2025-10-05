package ua.net.agsoft.javarush.crypto;

public class Crypto {

    private final char[] alphabet;
    private int alphabetLength;
    private int offset;

    //--------------------------------------------------------------------------------
    //                            *** constructor ***
    //--------------------------------------------------------------------------------

    public Crypto() {
        alphabet = CryptoAlphabetType.EN.getAlphabet();
        alphabetLength = alphabet.length;
    }

    public Crypto(CryptoAlphabetType alphabetType) {
        alphabet = alphabetType.getAlphabet();
        alphabetLength = alphabet.length;
    }


    //--------------------------------------------------------------------------------
    //                              *** static ***
    //--------------------------------------------------------------------------------


    //--------------------------------------------------------------------------------
    //                             *** non-static ***
    //--------------------------------------------------------------------------------


    public void setOffset(int offset) {
        this.offset = offset;

        if (this.offset  > alphabetLength)  this.offset = alphabetLength;

        if (this.offset  < 0) this.offset  = 0;
    }

    public void nextOffset() {
        setOffset(offset + 1);
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
