/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author dumildematos
 */
public class Utils {
    
    
    public static String setMd5(String input) 
    { 
        try { 
  
            // Static getInstance method is called with hashing MD5 
            MessageDigest md = MessageDigest.getInstance("MD5"); 
  
            // digest() method is called to calculate message digest 
            //  of an input digest() return array of byte 
            byte[] messageDigest = md.digest(input.getBytes()); 
  
            // Convert byte array into signum representation 
            BigInteger no = new BigInteger(1, messageDigest); 
  
            // Convert message digest into hex value 
            String hashtext = no.toString(16); 
            while (hashtext.length() < 32) { 
                hashtext = "0" + hashtext; 
            } 
            return hashtext; 
        }  
  
        // For specifying wrong message digest algorithms 
        catch (NoSuchAlgorithmException e) { 
            throw new RuntimeException(e); 
        } 
    }
    
    
    
    
     public static void main(String args[]) throws NoSuchAlgorithmException 
    { 
        String s = "GeeksForGeeks"; 
        String t = "GeeksForGeeks"; 
        System.out.println(setMd5(s)); 
        System.out.println(setMd5(t)); 
        if(setMd5(s).equals(setMd5(t))){
            System.out.println("Iguais "); 
        }else{
            System.out.println("Diferentes "); 

        }
    } 
    
}
