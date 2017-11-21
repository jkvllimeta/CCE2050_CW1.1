/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cce2050_cw1;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.io.FileWriter;

/**
 *
 * @author Joseph
 */



public class Server {
    
    private static ArrayList<Shapes> shapesArray = new ArrayList<Shapes>();
    private static ObjectOutputStream toClient;
    private static ObjectInputStream inputFromClient;
    private static ObjectOutputStream writeToFile;
    private static ObjectInputStream readFromFile;
    static String ip = "127.0.0.1";
    static int socketNo = 5555;
    static int socketNo2 = 8888;
    private static ServerSocket serverSocket;
    private static Socket socket;
    private static File arrayFile = new File("shapearray.dat");
    
    
    public static void main(String[] args) {

    //Initialize the Server connection
    try{       
            
        serverSocket = new ServerSocket(socketNo);
        System.out.println ("Server Started");

            while(true){
                
                socket = serverSocket.accept();
                System.out.println("Connected");

                inputFromClient = new ObjectInputStream(socket.getInputStream());
                System.out.println("Stream from Client initialized");
                
                toClient = new ObjectOutputStream(socket.getOutputStream());
                System.out.println("Stream to Client initialized");

                readFromFile = new ObjectInputStream(new FileInputStream(arrayFile));
                System.out.println("File Reader Initialized");
                
                
                //Reads the input from the client and checks whether the input is an Arraylist
                //to be written to a file or a String requesting the server to send an
                // ArrayList read from a file
                Object receivedInput = inputFromClient.readObject();
                
                System.out.println("Input Received" + receivedInput.getClass());
                
                
                
                //If the Client has sent an ArrayList, the Server cycles through the list
                //to check its contents and writes the entire ArrayList into a single file
                if (receivedInput.getClass() == ArrayList.class){
                    
                System.out.println(receivedInput.getClass() + " received from Client");
               
                     ArrayList <Shapes> receivedInput1 = (ArrayList <Shapes>)receivedInput;
                     System.out.println("ArrayList from Client cast into ArrayList of Shapes");

                    for(Shapes s: receivedInput1){
                        System.out.println(s.getName());
                    }
                    
                    FileOutputStream outFile = new FileOutputStream(arrayFile);
                    System.out.println("File Output Stream initialized");
                
                    writeToFile = new ObjectOutputStream(outFile);
                    System.out.println("File Writer initialized\n");
                    
                    writeToFile.writeObject(receivedInput1);
                    System.out.println("ArrayList Written to File");
                }
                
                //If the Client has sent a String, indicating a request for an ArrayList from
                //the Server's file repository, the Server retrieves the file, checks the ArrayList's
                //contents and filters it by shape depending on the client's request.
                
                else if (receivedInput.getClass() == String.class){
                
                String inputString = (String) receivedInput;
                System.out.println("The input received from the client is " + (String) inputString +"\n");
                
                //The ArrayList Object from the file is cast into an ArrayList of Shapes on the Server.
                
                ArrayList<Shapes> tempShapes = (ArrayList<Shapes>) readFromFile.readObject();  
                System.out.println("The current ArrayList size of the one saved in the file is " + tempShapes.size() + "\n");
                
                ArrayList<Shapes> arrayToClient = new ArrayList<Shapes>();
                
                //Depending on the user's choice, the Server will now filter the ArrayList,
                //sending only the Shapes requested by the user.
                switch (inputString.charAt(0)){
                
                case 'C': for (final Shapes shape : tempShapes) {
                        if (shape instanceof Circle){
                            System.out.println(shape.getName() + " added to Client requested ArrayList.\n");
                            arrayToClient.add(shape);
                        } 
                        
                } break;
                
                case 'R': for (final Shapes shape : tempShapes) {
                        if (shape instanceof Rectangle){
                            System.out.println(shape);
                            System.out.println(shape.getName() + " added to Client requested ArrayList.\n");
                            arrayToClient.add(shape);
                        } 
                } break;
                          
                case 'T': for (final Shapes shape : tempShapes) {
                        if (shape instanceof Triangle){
                            System.out.println(shape.getName() + " added to Client requested ArrayList.\n");
                            arrayToClient.add(shape);
                        } 
                          
                } break;
                
                case 'S': for (final Shapes shape : tempShapes) {
                        if (shape instanceof Sphere){
                        System.out.println(shape.getName() + " added to Client requested ArrayList.\n");
                        arrayToClient.add(shape);
                        } 
                } break;
                
                case 'Y': for (final Shapes shape : tempShapes) {
                        if (shape instanceof Cylinder){
                            System.out.println(shape.getName() + " added to Client requested ArrayList.\n");
                            arrayToClient.add(shape);
                        } 
                } break;
                
                case 'A': for (final Shapes shape : tempShapes) {
                        
                            System.out.println(shape.getName() + " added to Client requested ArrayList.\n");
                            arrayToClient.add(shape);
                            
                        
                } break;
                          
                case 'E': System.exit(0);
                        break;
                        
                } 
                
                //The filtered Shapes are then sent to the Client
                toClient.writeObject(arrayToClient);
                System.out.println("ArrayList successfully sent to Client");
               
            }
        }
    }catch(Exception e){
        System.out.println(e);
    } 
    
  }
    
}