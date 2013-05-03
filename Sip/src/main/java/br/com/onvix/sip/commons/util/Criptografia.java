/*
 * Criptografia.java
 *
 * Created on 16 de Março de 2007, 15:36
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.com.onvix.sip.commons.util;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
public class Criptografia {
    
    private static byte[] gerarHash(String frase, String algoritmo) {
        try {
            MessageDigest md = MessageDigest.getInstance(algoritmo);
            md.update(frase.getBytes());
            return md.digest();
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }
    
    public static String criptografaMD5(String frase) {
        String fraseCodificada;
        fraseCodificada = converteStringHexa(gerarHash(frase, "MD5"));
        return fraseCodificada;
    }
    
    public static String criptografaSHA1(String frase) {
        String fraseCodificada;
        fraseCodificada = converteStringHexa(gerarHash(frase, "SHA-1"));
        return fraseCodificada;
    }
    
    public static String criptografaSHA256(String frase) {
        String fraseCodificada;
        fraseCodificada = converteStringHexa(gerarHash(frase, "SHA-256"));
        return fraseCodificada;
    }
    
    private static String converteStringHexa(byte[] bytes) {
        String s = new String();
        for (int i = 0; i < bytes.length; i++)
            s += Integer.toHexString((((bytes[i] >> 4) & 0xf) << 4)
            | (bytes[i] & 0xf));
        return s;
    }
}

