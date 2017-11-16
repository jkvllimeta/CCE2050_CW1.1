/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cce2050_cw1;

/**
 *
 * @author M00607647
 */
public class Triangle extends TwoDShapes {
        
    private double side1;
    private double side2;
    private double side3;

    public Triangle(String name, double sideA, double sideB, double sideC) {
        
        super(name, 3);
        side1 = sideA;
        side2 = sideB;
        side3 = sideC;
        
    }
    
    @Override
    public void displayDescription(){
        super.displayDescription();
        System.out.println("I'm also a triangle");
    }

    @Override
    public double getArea() {

        double s = (side1 + side2 + side3) / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    @Override
    public double getPerimeter() {

        return side1 + side2 + side3;
    }

    @Override
    public double getVolume(){
    return 0;
    }
    
}
