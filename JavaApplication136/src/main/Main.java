/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.IOException;

/**
 *
 * @author Acer
 */
public class Main {
    public static void main(String[] args) throws IOException, Exception {
    User u=new User();
    u.name="test";
    FileUtility.writeobjecttofile(u,"test.obj");
     User u2=(User) FileUtility.readFile("test.obj");
        System.out.println(u2.name );
    }
}
