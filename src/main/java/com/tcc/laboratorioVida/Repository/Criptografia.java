package com.tcc.laboratorioVida.Repository;

import java.math.BigInteger;
import java.security.MessageDigest;

public class Criptografia {
    public static String md5cripto(String senha) {
        try{
            MessageDigest messageDigest = MessageDigest.getInstance("MD5"); 
            BigInteger hash = new BigInteger(1, messageDigest.digest(senha.getBytes()));
            return hash.toString(16);
        } catch(Exception e) {
            return "";
        }
    }

}
