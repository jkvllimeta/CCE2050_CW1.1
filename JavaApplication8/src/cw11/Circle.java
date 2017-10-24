/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cw11;

/**
 *
 * @author M00607647
 */
public class Circle extends TwoDShapes {
    
    private double circRadius;
    
    public Circle(String name, double radius){
        super(name, 0);
        circRadius = radius;
    }
    
    @Override
    public void displayDescription(){
        super.displayDescription();
        System.out.println("I'm also a circle");
    }
    
    @Override
    public double getArea(){
        return Math.PI * Math.pow(circRadius, 2);
    }
    
    @Override
    public double getPerimeter(){
        return Math.PI * (circRadius * 2);
    }
}
