package control.utilidad;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class Encripta {
    public static String encripta(String original){
        String salida = "";
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-512");
        } catch (NoSuchAlgorithmException e) {
            System.out.printf(e.getMessage());
        }
        byte[] dig = md.digest(original.getBytes(StandardCharsets.UTF_8));
        salida = conversor(dig);
        return salida;
    }

    private static String conversor(byte[] arreglo) {
        StringBuffer hexStringBuffer = new StringBuffer();
        for (int i = 0; i < arreglo.length; i++) {
            hexStringBuffer.append(byteToHex(arreglo[i]));
        }
        return hexStringBuffer.toString();
    }

    private static String byteToHex(byte num) {
        char[] hexDigits = new char[2];
        hexDigits[0] = Character.forDigit((num >> 4) & 0xF, 16);
        hexDigits[1] = Character.forDigit((num & 0xF), 16);
        return new String(hexDigits);
    }
}
