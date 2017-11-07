/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cce2050_cw1;
import java.util.Scanner;

/**
 *
 * @author M00607647
 */
public class CCE2050_CW1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Menu();
    }
    
    public static void Menu () {
        Scanner s = new Scanner(System.in);
        char choice1;
        char choice2;
        char choice3;
        
        System.out.println("Please enter the type of Shape you would like to create:");
        System.out.println("- Enter [2D] to create a 2D Shape -");
        System.out.println("- Enter [3D] to create a 3D Shape -");
        
        choice1 = s.next().charAt(0);
        System.out.println(choice1);
        
        switch(choice1){
            
            case '2': System.out.println("Please enter the type of 2D Shape that you wish to create:");
                      System.out.println("- Enter C to create a Circle -");
                      System.out.println("- Enter T to create a Triangle -");
                      System.out.println("- Enter R to create a Rectangle -");
                      
                      choice2 = s.next().charAt(0);
                      choice2 = Character.toUpperCase(choice2);
                      
                      switch(choice2){
                        case 'C': System.out.println("Enter a name for your Circle:");
                                String cName = s.next();
                                System.out.println("Enter the radius of your Circle:");
                                double cRadius = s.nextDouble();
                                Circle circleChoice =  new Circle(cName, cRadius);
                                circleChoice.displayDescription();
                                System.out.println("My area is " + circleChoice.getArea());
                                circleChoice.getPerimeter();
                                break;
                          
                        case 'T': System.out.println("Enter a name for your Triangle:");
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
                                break;
                                
                        case 'R': System.out.println("Enter a name for your Rectangle:");
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
                                break;
                                
                        default:
                      }
                      break;
                      
            case '3': System.out.println("Please select the type of 3D Shape that you wish to create:");
                      System.out.println("- Enter S to create a Sphere -");
                      System.out.println("- Enter C to create a Cylinder -");
                      
                      choice3 = s.next().charAt(0);
                      choice3 = Character.toUpperCase(choice3);
                      
                      switch(choice3){
                        case 'S': System.out.println("Enter a name for your Sphere:");
                                String spName = s.next();
                                System.out.println("Enter the radius of your Sphere:");
                                double spRadius = s.nextDouble();
                                Sphere sphereChoice =  new Sphere(spName, spRadius);
                                sphereChoice.displayDescription();
                                System.out.println("My area is " + sphereChoice.getArea());
                                System.out.println("My volume is " + sphereChoice.getVolume());
                                break;
                                
                        case 'C': System.out.println("Enter a name for your Cylinder:");
                                String cyName = s.next();
                                System.out.println("Enter the base radius of your Cylinder:");
                                double cyRadius = s.nextDouble();
                                System.out.println("Enter the height of your Cylinder:");
                                double cyHeight = s.nextDouble();
                                Cylinder cylinderChoice =  new Cylinder(cyName, cyRadius, cyHeight);
                                cylinderChoice.displayDescription();
                                System.out.println("My area is " + cylinderChoice.getArea());
                                System.out.println("My volume is " + cylinderChoice.getVolume());
                                break;
                      }
                    break;
                    
            default: System.out.println("Please select a valid option /n");
                     Menu();
                     break;
                
        
        }
        
        
    }
    
}
