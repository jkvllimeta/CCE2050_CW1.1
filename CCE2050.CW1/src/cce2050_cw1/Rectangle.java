/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cce2050_cw1;
import java.io.Serializable;

/**
 *
 * @author M00607647
 */
public class Rectangle extends TwoDShapes implements Serializable {
    
    private double rectHeight;
    private double rectWidth;
    
    public Rectangle(String name, double height, double width){
        super(name, 4);
        rectHeight = height;
        rectWidth = width;
        
    }
    
    @Override
    public void displayDescription(){
        super.displayDescription();
        System.out.println("I'm also a Rectangle");
    }
    
    @Override
    public double getArea(){
        return rectHeight * rectWidth;
    }
    
    @Override
    public double getPerimeter(){
        return(rectHeight + rectWidth) * 2;
    }
    
    @Override
    public double getVolume(){
    return 0;
    }
    
    
}
