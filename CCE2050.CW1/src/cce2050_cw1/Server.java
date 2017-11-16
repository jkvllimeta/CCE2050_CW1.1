/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cce2050_cw1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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
    private static ObjectOutputStream arrayListToClient;
    private static ObjectInputStream shapeFromClient;
    private static ObjectOutputStream writeToFile;
    private static ObjectInputStream readFromFile;
    static String ip = "127.0.0.1";
    static int socketNo = 5555;
    private static ServerSocket serverSocket;
    private static Socket socket;
    private static File arrayFile = new File("shapearray.dat");
    
    public static void main(String[] args) {
        
    new Thread( () -> {
    try{       
               
        while (true) {
                
                serverSocket = new ServerSocket(socketNo);
                System.out.println ("Server Started");
                
                socket = serverSocket.accept();
                System.out.println("Connected");
               // shapeToClient = new ObjectOutputStream(socket.getOutputStream());
                
                shapeFromClient = new ObjectInputStream(socket.getInputStream());
                System.out.println("Stream from Client initialized");
                
                arrayListToClient = new ObjectOutputStream(socket.getOutputStream());
                System.out.println("Stream to Client initialized");
                
                writeToFile = new ObjectOutputStream(new FileOutputStream(arrayFile, true));
                System.out.println("File Writer initialized");
                
                Circle receivedShape = (Circle) shapeFromClient.readObject();
                shapeFromClient.close();
                System.out.println(receivedShape.getClass() + " received from Client");
                
                shapesArray.add(receivedShape);
                
                System.out.println(receivedShape.getName() + " added to the Shapes ArrayList");
                
                writeToFile.writeObject(receivedShape);
                
                /*
                for (Shapes s : shapesArray){
                    
                    writeToFile.writeObject(shapesArray);
                    
                }*/
                
                //shapesArray.add(clientShape);
                System.out.println(shapesArray.get(0).getName());
                System.out.println(receivedShape.getArea());
                
             //   Object clientInput = shapeFromClient.readObject();
                
                /*if(clientInput.getClass() == ArrayList.class){
                    
                    writeToFile.writeObject(clientInput);                       
                    
                } else if (clientInput.getClass() == String.class){
                    
                    System.out.println("The input received from the client is " + clientInput);
                    
                    
                    
                    
                    if (clientInput == "C"){
                     
                        readFromFile = new ObjectInputStream(new FileInputStream("shapearray.dat"));
                        
                        ArrayList arrayFromFile = readFromFile;
                        
                        for (Shapes shape : (ArrayList<Shapes>) clientInput)
                    {
                        if (Shapes.getClass() == Circle.class){
                            
                        }
                    }
                        
                    }
                    
                    
                } else {
                    
                    System.out.println("Invalid Input from Client");
                    
                }*/

                //System.out.println();
                
               // Shapes receivedShape = (Shapes) shapeFromClient.readObject();


            }
    
    }catch(Exception e){
        System.out.println("hi"+e);
    } 
    }).start();
    
    
    }
    
    /*public static void readObject(){
        try{
            
                
            Shapes clientShape = (Shapes)shapeFromClient.readObject();
            
        } catch (Exception e){
            System.out.println("ERROR: " + e.getMessage());
        }
    }*/
    
    public static void sendCircle(){
       
        try{
            for (int i = 0; i<shapesArray.size(); i++){
            
            //readFromFile.readObject(arrayFile);
            if (shapesArray.get(i) instanceof Circle){
            
                arrayListToClient.writeObject(i);   
                }
            }
            
        } catch (Exception e){
            e.printStackTrace();
                
        } 
        
    
    
    }
    
}
