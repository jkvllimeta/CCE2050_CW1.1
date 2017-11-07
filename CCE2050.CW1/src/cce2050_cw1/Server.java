/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cce2050_cw1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Joseph
 */



public class Server {
    
    private static ArrayList<Shapes> shapesArray = new ArrayList<Shapes>();
    private static ObjectOutputStream shapeToClient;
    private static ObjectInputStream shapeFromClient;

    private static ServerSocket serverSocket;
    private static Socket socket;
    
    public static void main(String[] args) {
    System.out.println ("server started");
    
    
    try{
    while (true) {
    
                serverSocket = new ServerSocket(5555);
                
                socket = serverSocket.accept();
                
                System.out.println("connect ");
                shapeToClient = new ObjectOutputStream(socket.getOutputStream());
                
                shapeFromClient = new ObjectInputStream(socket.getInputStream());
                
                //Shapes clientShape = (Shapes)shapeFromClient.readObject();
                
                readObject();
                
                //shapesArray.add(clientShape);
                System.out.println(shapesArray.get(0).getName());

            }
    
    }catch(Exception e){
        System.out.println(e);
    }
    
    
    }
    
    public static void readObject(){
        try{
            
                
            Shapes clientShape = (Shapes)shapeFromClient.readObject();
            
        } catch (Exception e){
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}
