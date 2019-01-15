/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sbl.elegislature.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;

/**
 *
 * @author sandeep
 */
public class AppUtils {
    
    public static final String LOGIN_FILE = "LoginInfo.json";

    public static String readFileAsString(String fileName)  {
        String data = null;
        try {
            File tmpDir = new File(fileName);
            boolean exists = tmpDir.exists();
            if(!exists) return data;
            data = new String(Files.readAllBytes(Paths.get(fileName)));
        } catch ( Exception e ) {
            e.printStackTrace();
        } 
        
        return data;
    }
    
    
    public static void writeStringAsFile(String fileName, String data) {
        try {
            Files.write(Paths.get(fileName), data.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    

}
