/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author Acer
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author Acer
 */
public class FileUtility {

    private static void writeIntoFile(String fileName, String text, boolean append) throws Exception {
        try (FileWriter fw = new FileWriter(fileName, append);
                BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(text);
        }
    }

    public static void writeIwtoFile(String fileName, String text) throws Exception {
        writeIntoFile(fileName, text, false);
    }

    public static void appendIwtoFile(String fileName, String text) throws Exception {
        writeIntoFile(fileName, text, true);
    }

    public static void writeIntoFile2(String Filename, byte[] data) throws Exception {

        File file = new File(Filename);
        FileOutputStream fop = new FileOutputStream(file);

        fop.write(data);
        fop.flush();
        fop.close();

        System.out.println("Done");

    }

    public static String read(String fileName) throws Exception {
        InputStream in = new FileInputStream(fileName);
        InputStreamReader r = new InputStreamReader(in);
        BufferedReader reader = new BufferedReader(r);
        String line = null;
        String result = "";
        while ((line = reader.readLine()) != null) {
            result += line + "\n";
        }
        return result;

    }

    public static byte[] readBytes(String filename) throws Exception {
        File file = new File(filename);
        byte[] bytesArray = new byte[(int) file.length()];
        FileInputStream fileInputStream = new FileInputStream(file);
        fileInputStream.read(bytesArray);

        return bytesArray;
    }

    public static void writeBytes(String Filename, byte[] data) throws Exception {

        FileOutputStream fop = new FileOutputStream(Filename);

        fop.write(data);
        fop.flush();
        fop.close();

        System.out.println("Done");

    }

    public static void writeobjecttofile(Serializable object, String name) throws Exception {
        try (
                FileOutputStream fout = new FileOutputStream(name);
                ObjectOutputStream oos = new ObjectOutputStream(fout);) {
            oos.writeObject(object);
        }

    }

    public static Object readFile(String name) throws IOException {
        Object obj = null;
      FileInputStream fi=   new FileInputStream(name);
        try (ObjectInputStream in = new ObjectInputStream(fi);) {
            obj = in.readObject();
        } finally {
            return obj;
        }

    }
}

