package com.juaracoding.RH.springbootrestapi.core;/*
IntelliJ IDEA 2022.3.1 (Community Edition)
Build #IC-223.8214.52, built on December 20, 2022
@Author Rhay Riswan Hadiyanto
Java Developer
Created on 02/08/2023 19:11
@Last Modified 02/08/2023 19:11
Version 1.0
*/
import org.bouncycastle.crypto.BufferedBlockCipher;
import org.bouncycastle.crypto.engines.AESLightEngine;
import org.bouncycastle.crypto.modes.CBCBlockCipher;
import org.bouncycastle.crypto.paddings.PaddedBufferedBlockCipher;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.util.encoders.Hex;
public class Crypto {

    /*
    this is default encrypt key : aafd12f438cae52538b479e2089ddec2f06cb58faafd12f6
    this is default encrypt key : bbfd12f438dbf52538b479e2089ddec2g06cb58faafd12f6
 */
//    private static String defaultKey = "aafd12f438cae52538b479e2089ddec2f06cb58faafd12f6";
    private static String defaultKey = "aafd12e328cae52538b479e2089ddec2f06cb58faafd12f6";
    public static String performEncrypt(String keyText, String plainText) {
        try{
            byte[] key = Hex.decode(keyText.getBytes());
            byte[] ptBytes = plainText.getBytes();
            BufferedBlockCipher cipher = new PaddedBufferedBlockCipher(new CBCBlockCipher(new AESLightEngine()));
            cipher.init(true, new KeyParameter(key));
            byte[] rv = new byte[cipher.getOutputSize(ptBytes.length)];
            int oLen = cipher.processBytes(ptBytes, 0, ptBytes.length, rv, 0);
            cipher.doFinal(rv, oLen);
            return new String(Hex.encode(rv));
        } catch(Exception e) {
            return "Error";
        }
    }

    public static String performEncrypt(String cryptoText) {
        return performEncrypt(defaultKey, cryptoText);
    }

    public static String performDecrypt(String keyText, String cryptoText) {
        try {
            byte[] key = Hex.decode(keyText.getBytes());
            byte[] cipherText = Hex.decode(cryptoText.getBytes());
            BufferedBlockCipher cipher = new PaddedBufferedBlockCipher(new CBCBlockCipher(new AESLightEngine()));
            cipher.init(false, new KeyParameter(key));
            byte[] rv = new byte[cipher.getOutputSize(cipherText.length)];
            int oLen = cipher.processBytes(cipherText, 0, cipherText.length, rv, 0);
            cipher.doFinal(rv, oLen);
            return new String(rv).trim();
        } catch(Exception e) {
            return "Error";
        }
    }

    public static String performDecrypt(String cryptoText) {
        return performDecrypt(defaultKey, cryptoText);
    }

    public static void main(String[] args) {

        String strToEncrypt = "irlc1234";//put text to encrypt in here
        String encryptionResult = new Crypto().performEncrypt(strToEncrypt);
        System.out.println("Encryption Result : "+encryptionResult);

        String strToDecrypt = "f44bf10746af4c22bd9d8b580f79a23a";//put text to decrypt in here
        String decriptionResult = new Crypto().performDecrypt(strToDecrypt);
        System.out.println("Decryption Result : "+decriptionResult);
    }

}
