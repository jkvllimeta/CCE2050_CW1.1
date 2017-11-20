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
    //final static Gson gson = new GsonBuilder().create();
    
    public static void main(String[] args) {

    try{       
               serverSocket = new ServerSocket(socketNo);
                System.out.println ("Server Started");
        while (true) {
                
                
                
                socket = serverSocket.accept();
                System.out.println("Connected");
               // shapeToClient = new ObjectOutputStream(socket.getOutputStream());
                
                inputFromClient = new ObjectInputStream(socket.getInputStream());
                System.out.println("Stream from Client initialized");
                
                toClient = new ObjectOutputStream(socket.getOutputStream());
                System.out.println("Stream to Client initialized");
                
                
                
                readFromFile = new ObjectInputStream(new FileInputStream(arrayFile));
                System.out.println("File Reader Initialized");
                
               Object receivedInput = inputFromClient.readObject();
                
                System.out.println("Input Received" + receivedInput.getClass());
                
                
                if (receivedInput.getClass() == ArrayList.class){
                    
                System.out.println(receivedInput.getClass() + " received from Client");
               
                     ArrayList <Shapes> receivedInput1 = (ArrayList <Shapes>)receivedInput;
                     System.out.println("ArrayList from Client cast into ArrayList of Shapes");
                    //ArrayList<Shapes> shapeArrayFromClient = (ArrayList<Shapes>) receivedInput; 
                    
                    //for(Shapes shape : (ArrayList<Shapes>) shapeArrayFromClient){
                    for(Shapes x: receivedInput1){
                        System.out.println(x.toString());
                        x.getName();}
                    
                    //inputFromClient.close();
                    
                    FileOutputStream outFile = new FileOutputStream(arrayFile);
                    System.out.println("File Output Stream initialized");
                
                    //FileWriter writer = new FileWriter(arrayFile);
                
                    writeToFile = new ObjectOutputStream(outFile);
                    System.out.println("File Writer initialized");
                    
                    writeToFile.writeObject(receivedInput1);
                    System.out.println("ArrayList Written to File");
                    //gson.toJson(receivedInput, writer);
                    //}
                   
                    //writeToFile.close();
                    //outFile.close();
                    // inputFromClient.close();
                    //toClient.writeObject("ArrayList received");
                    
                    //toClient.close();
                }       
                else if (receivedInput.getClass() == String.class){
                
                String inputString = (String) receivedInput;
                System.out.println("The input received from the client is " + inputString);
                
                //ArrayList<Shapes> 
                       ArrayList tempShapes = (ArrayList<Shapes>) readFromFile.readObject();  
                    System.out.println("The current ArrayList size of the one saved in the file is " + tempShapes.size());
                    //readFromFile.close();
                
                //ObjectOutputStream outputToClient = new ObjectOutputStream(socket.getOutputStream());
                toClient.writeObject(tempShapes);
                //outputToClient.writeObject(tempShapes);
                
                System.out.println("ArrayList successfully sent to Client");
                
                //outputToClient.writeObject("Object added successfully");   
                
                //outputToClient.close();
               
            }
        }
    }catch(Exception e){
        System.out.println(e);
    } 
    
    }
    
    public static void sendCircle(){
       
        try{
            
            
            /*for (int i = 0; i<shapesArray.size(); i++){
            
            readFromFile.readObject();
            if (shapesArray.get(i) instanceof Circle){
            
                arrayListToClient.writeObject(i);   
                }*/
            
             socket.close();
            
            }
    catch (Exception e){
            e.printStackTrace();
                
        } 
        
    }
    
    /*public static void fileWrite (ArrayList<Shapes> shapes){
        try{
        writeToFile = new ObjectOutputStream(new FileOutputStream(arrayFile, true));
        
        writeToFile.writeObject(shapes);
        } catch (Exception e){
            System.out.println(e);
        }
    }
*/
    
}