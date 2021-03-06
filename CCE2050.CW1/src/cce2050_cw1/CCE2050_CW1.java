/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cce2050_cw1;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.Serializable;

/**
 *
 * @author M00607647
 */
public class CCE2050_CW1 {

    /**
     * @param args the command line arguments
     */
    
    static ObjectOutputStream sendObject;
    static ObjectInputStream receiveObject;
    static String ip = "127.0.0.1";
    static int socketNo = 5555;
    static int socketNo2 = 8888;
    static Scanner s = new Scanner(System.in);
    static ArrayList<Shapes> shapesArray = new ArrayList<Shapes>();
    
    public static void main(String[] args) {
        // TODO code application logic here
        Menu();
          
    }
    
    //This is the code for the main menu on the Client side. The options are presented to the user
    //which will either take the user to the corresponding submenu or execute the function in the
    //case of sending shapes, receiving shapes, or program termination.
    public static void Menu () {
        
        char choice1;
        char choice2;
        char choice3;
        
        System.out.println("Enter the number of the action you wish to perform:");
        System.out.println("1. Create a 2D Shape");
        System.out.println("2. Create a 3D Shape");
        System.out.println("3. Send Shapes");
        System.out.println("4. Receive Shapes");
        System.out.println("5. Exit the program");
        
        choice1 = s.next().charAt(0);
        
        switch(choice1){
            
            case '1': System.out.println("Please enter the type of 2D Shape that you wish to create:");
                      System.out.println("- Enter [C] to create a Circle -");
                      System.out.println("- Enter [T] to create a Triangle -");
                      System.out.println("- Enter [R] to create a Rectangle -");
                      
                      choice2 = s.next().charAt(0);
                      choice2 = Character.toUpperCase(choice2);
                      
                      switch(choice2){
                        case 'C': circleMenu();
                                  break;
                                  
                        case 'T': triangleMenu();
                                break;
                                
                        case 'R': rectangleMenu();
                                break;
                                
                        default: System.out.println("Invalid input. Returning to the beginning.");
                                 Menu();
                                 break;
                      }
                      break;
                      
            case '2': System.out.println("Please select the type of 3D Shape that you wish to create:");
                      System.out.println("- Enter [S] to create a Sphere -");
                      System.out.println("- Enter [C] to create a Cylinder -");
                      
                      choice3 = s.next().charAt(0);
                      choice3 = Character.toUpperCase(choice3);
                      
                      switch(choice3){
                        case 'S': sphereMenu();
                                break;
                                
                        case 'C': cylinderMenu(); 
                                break;
                                
                        default: System.out.println("Invalid input. Returning to the beginning.");
                                 Menu();
                                 break;
                      }
                    break;
            
            case '3': sendToServer();
                      Menu();
                      break;
                
            case '4': receiveShapes();
                      Menu();
                      break;
                    
            case '5': System.exit(0);
                      break;
                      
            default: System.out.println("Please select a valid option");
                     Menu();
        }
    }
    
    //The following code blocks are the methods for creating the submenus for specific
    //functions, such as the creation of shapes and sending and receiving ArrayLists
    //to and from the Server
    public static void circleMenu(){
        System.out.println("Enter a name for your Circle:");
        String cName = s.next();
        System.out.println("Enter the radius of your Circle:");
        double cRadius = s.nextDouble();
        Circle circleChoice =  new Circle(cName, cRadius);
        circleChoice.displayDescription();
        System.out.println("My area is " + circleChoice.getArea());
        circleChoice.getPerimeter();
        circleChoice.perimeter = circleChoice.getPerimeter();
        System.out.println("My perimeter is " + circleChoice.getPerimeter());
        
        shapesArray.add(circleChoice);
        System.out.println("The Circle has been added to the ArrayList\n");
        
        Menu();
    }
    
    public static void triangleMenu(){
        System.out.println("Enter a name for your Triangle:");
        String tName = s.next();
        System.out.println("Enter the length of the sides of your Triangle:");
        System.out.println("Side A");
        double sideA = s.nextDouble();
        System.out.println("Side B");
        double sideB = s.nextDouble();
        System.out.println("Side C");
        double sideC = s.nextDouble();
        Triangle triangleChoice =  new Triangle(tName, sideA, sideB, sideC);
        triangleChoice.displayDescription();
        System.out.println("My area is " + triangleChoice.getArea());
        triangleChoice.getPerimeter();
        
        shapesArray.add(triangleChoice);
        System.out.println("The Triangle has been added to the ArrayList\n");
        Menu();
    }
    
    public static void rectangleMenu(){
        System.out.println("Enter a name for your Rectangle:");
        String rName = s.next();
        System.out.println("Enter the height and width of your Rectangle:");
        System.out.println("Height");
        double rHeight = s.nextDouble();
        System.out.println("Width");
        double rWidth = s.nextDouble();
        Rectangle rectangleChoice =  new Rectangle(rName, rHeight, rWidth);
        rectangleChoice.displayDescription();
        System.out.println("My area is " + rectangleChoice.getArea());
        rectangleChoice.getPerimeter();
        
        shapesArray.add(rectangleChoice);
        System.out.println("The Rectangle has been added to the ArrayList\n");
        Menu();
    }
    
    public static void sphereMenu(){
        System.out.println("Enter a name for your Sphere:");
        String spName = s.next();
        System.out.println("Enter the radius of your Sphere:");
        double spRadius = s.nextDouble();
        Sphere sphereChoice =  new Sphere(spName, spRadius);
        sphereChoice.displayDescription();
        System.out.println("My area is " + sphereChoice.getArea());
        System.out.println("My volume is " + sphereChoice.getVolume());
        
        shapesArray.add(sphereChoice);
        System.out.println("The Sphere has been added to the ArrayList\n");
        Menu();
    }
    
    public static void cylinderMenu(){
        System.out.println("Enter a name for your Cylinder:");
        String cyName = s.next();
        System.out.println("Enter the base radius of your Cylinder:");
        double cyRadius = s.nextDouble();
        System.out.println("Enter the height of your Cylinder:");
        double cyHeight = s.nextDouble();
        Cylinder cylinderChoice =  new Cylinder(cyName, cyRadius, cyHeight);
        cylinderChoice.displayDescription();
        System.out.println("My area is " + cylinderChoice.getArea());
        System.out.println("My volume is " + cylinderChoice.getVolume());
        
        shapesArray.add(cylinderChoice);
        System.out.println("The Cylinder has been added to the ArrayList\n");
        Menu();
    }
    

    //This is the code for sending the entire ArrayList of shapes created by the Client
    //to the Server in order for the Server to be able to save it to a file for future retrieval
    public static void sendToServer(){
        
        try {
            Socket socket = new Socket(ip, socketNo);
            
            System.out.println("Client Socket opened at ip address " + ip + " and port number " + socketNo);
            
            // Create an output stream to send data to the server
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(shapesArray);

            oos.flush();
            
            System.out.println("Array of Shapes has been sent to the Server. Containing " + shapesArray.size() + " number of Shapes.");
            for (Shapes x :shapesArray) 
                 System.out.println(x.getName() + " was added to the ArrayList\n");
            

            // Create an input stream to receive data from the server
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

            //Confirmation Reply received from Server
            String obj = (String) ois.readObject();

            System.out.println("The server has received " + obj);
            
            socket.close();
            
            Menu();

        } catch (Exception e) {
            System.out.println(e);
        }
        Menu();

    }
    
    //Method for requesting the Server to send shapes to display on the Client's side.
    //The Client sends a String request for the type of shape the user wishes to receive
    //whether they are individual shapes or all of the shapes available on the Server's file.
    public static void receiveShapes() {
        try {
            while(true){
            
            //The stream for sending the input to the client is initialized    
            Socket socket = new Socket(ip, socketNo);
            
            System.out.println("Socket initialized");
            ObjectOutputStream toServer = new ObjectOutputStream(socket.getOutputStream());
            System.out.println("toServer stream initialized");

            //The scanner for taking the user input is initialized before presenting
            //the options available to the user in a menu. The request is then sent to
            //the Server for ArrayList filtering(if needed) and sending the requested Shapes back to the Client.
            Scanner scanner = new Scanner(System.in);

            System.out.println("Select the type of Shape you would like to receive from the Server: ");
            System.out.println("- Enter [C] for Circles -");
            System.out.println("- Enter [R] for Rectangles -");
            System.out.println("- Enter [T] for Triangles -");
            System.out.println("- Enter [S] for Spheres -");
            System.out.println("- Enter [Y] for Cylinder -");
            System.out.println("- Enter [A] for All Types of Shapes -");
            System.out.println("- Enter [E] to Exit the program -");
            System.out.print("Enter your choice: ");
            String userInput = scanner.nextLine();
            String choice = userInput.toUpperCase();

            System.out.println(userInput + " request has been sent to the server\n");
            
            toServer.writeObject(choice);
            
            System.out.println("Request sent");
            
            //The ArrayList from the Server containing the requested Shapes is received
            //and its contents are then displayed.
            ObjectInputStream fromServer = new ObjectInputStream(socket.getInputStream());
            System.out.println("Object Stream from Server initialized");
            ArrayList<Shapes> arrayFromServer = (ArrayList<Shapes>) fromServer.readObject();

            System.out.println("Arraylist of Shapes has been received from the Server\n");
            
            for(final Shapes shape : arrayFromServer){
                        shape.displayDescription();
                        if (shape instanceof TwoDShapes){
                            System.out.println("Area: " + shape.getArea());
                            System.out.println("Perimeter: " + shape.getPerimeter());
                            System.out.println("");
                        } else if (shape instanceof ThreeDShapes){
                            System.out.println("Area: " + shape.getArea());
                            System.out.println("Volume: " + shape.getVolume());
                            System.out.println("");
                        } else {
                            System.out.println("I am a generic shape");
                        } 
                }  
            
            }
        } catch (Exception e) {
                System.out.println(e);
                System.out.println("Program Terminated");
                System.exit(0);
        }
        
        Menu();
        
    }

}
