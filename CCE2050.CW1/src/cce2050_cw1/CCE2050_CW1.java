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
    static Scanner s = new Scanner(System.in);
    static ArrayList<Shapes> shapesArray = new ArrayList<Shapes>();
    
    public static void main(String[] args) {
        // TODO code application logic here
        try{
        
        Socket clientSocket = new Socket(ip, socketNo);
        System.out.println("Client Socket opened at ip address " + ip + " and port number " + socketNo);
        
        sendObject = new ObjectOutputStream(clientSocket.getOutputStream());
       // receiveObject = new ObjectInputStream(clientSocket.getInputStream());
        
        Menu();
        
        } catch (Exception e){
            System.out.println("ERROR:" + e);
            
            
        }  
    }
    
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
        //System.out.println(choice1);
        
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
                
            case '4':
                    
            case '5': System.exit(0);
                    
            default: System.out.println("Please select a valid option");
                     Menu();
        }
    }
    
    /*
    public static void sendShapes (){
        
    }
    
    public static void Client (){
        
        try{
        Socket clientSocket = new Socket("127.0.0.1", 5555);
        ObjectOutputStream sendObject = new ObjectOutputStream(clientSocket.getOutputStream());
        
        //sendObject.writeObject(a);
        
        } catch (Exception e){
            System.out.println("ERROR:" + e);
        }
    }
    */
    
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
        System.out.println("The Circle has been added to the ArrayList");
                                
                                
                                
                                try{
                                sendObject.writeObject(circleChoice);
                               sendObject.flush();
                               sendObject.close();
                               //clientSocket.close();
                                } catch (IOException e){
                                    System.out.println(e);
                                } 
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
    }
    
    
    public static void sendToServer(){
        
        try{
            Socket socket = new Socket(ip, 5555);
            
            ObjectOutputStream toServer = new ObjectOutputStream(socket.getOutputStream());
            toServer.writeObject(shapesArray);
            
            
            ObjectInputStream fromServer = new ObjectInputStream(socket.getInputStream());
            
            socket.close();
            
        } catch (Exception e){
            System.out.println(e);
        }
        
        Menu();
    }
    
    
    public static void receiveShapes() {
        try {
            Socket socket = new Socket(ip, socketNo);

            ObjectOutputStream toServer = new ObjectOutputStream(socket.getOutputStream());
            
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
           
            switch (userInput.toUpperCase().charAt(0)) {
                case 'C':
                    toServer.writeObject("C");                    break;
                case 'R':
                    toServer.writeObject("R");                    break;
                case 'T':
                    toServer.writeObject("T");                    break;
                case 'S':
                    toServer.writeObject("S");                    break;
                case 'Y':
                    toServer.writeObject("Y");                    break;
                case 'A':
                    toServer.writeObject("A");                    
                    break;
                case 'E':
                    System.out.println("Exiting the program");                    
                    break;
            }

            System.out.println(userInput + "request has been sent to the server\n");
            
            ObjectInputStream fromServer = new ObjectInputStream(socket.getInputStream());

            ArrayList<Shapes> arrayFromServer = (ArrayList<Shapes>) fromServer.readObject();

            System.out.println("obj is recived from the server\n");

            for (final Shapes shape : arrayFromServer) {
                shape.displayDescription();
                
                if (shape instanceof Circle){
                
                System.out.println("Area: " + shape.getArea());
                System.out.println("Perimeter: " + shape.getPerimeter());
                
                } else if (shape instanceof Triangle) {
                    
                System.out.println("Area: " + shape.getArea());
                System.out.println("Perimeter: " + shape.getPerimeter());
                    
                } else if (shape instanceof Rectangle) {
                    
                System.out.println("Area: " + shape.getArea());
                System.out.println("Perimeter: " + shape.getPerimeter());
                    
                } else if (shape instanceof Sphere) {
                    
                System.out.println("Area: " + shape.getArea());
                System.out.println("Volume: " + shape.getVolume());
                    
                } else if (shape instanceof Cylinder) {
                    
                System.out.println("Area: " + shape.getArea());
                System.out.println("Volume: " + shape.getVolume());
                    
                } else {
                    
                    System.out.println("ArrayList received is invalid");
                    
                }
                
                socket.close();
            
            }
            
        } catch (Exception e) {
            System.out.println(e);
            
        }
        
        Menu();
        
    }

}
