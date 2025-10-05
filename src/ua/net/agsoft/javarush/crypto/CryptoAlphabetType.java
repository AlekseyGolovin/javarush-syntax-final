package ua.net.agsoft.javarush.crypto;

public enum CryptoAlphabetType {

    EN(CryptoAlphabet.ALPHA_EN),
    LATIN(CryptoAlphabet.ALPHA_LATIN),
    CYRIL(CryptoAlphabet.ALPHA_CYRIL),
    LATIN_MIX(CryptoAlphabet.ALPHA_LATIN_MIX),
    CYRIL_MIX(CryptoAlphabet.ALPHA_CYRIL_MIX);

    // Приватное поле для хранения самого массива символов
    private final char[] alphabet;

    CryptoAlphabetType(String alphabetString) {
        this.alphabet = alphabetString.toCharArray();
    }

    // Публичный метод для доступа к массиву символов
    public char[] getAlphabet() {
        return alphabet;
    }

}
