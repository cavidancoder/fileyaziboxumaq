/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Acer
 */
public class NioFileUtility {
    
    public static void write(byte[] data, String fileName) throws Exception {
        Path filePath = Paths.get(fileName);
        Files.write(filePath, data);

    }
  public static byte[] read(String fileName) throws Exception {
        Path filePath = Paths.get(fileName);
        byte[] byteArray = Files.readAllBytes(filePath);
        return byteArray;

    }
}
