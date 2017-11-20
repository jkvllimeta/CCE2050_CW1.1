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
public class Cylinder extends ThreeDShapes implements Serializable{
    
    private double faceRadius;
    private double height;
    
    public Cylinder(String name, double fRadius, double cHeight) {
        super(name, 0);
        faceRadius = fRadius;
        height = cHeight;
    }

    @Override
    public double getVolume() {
        return Math.PI * Math.pow(faceRadius,2) * height;
    }

    public double getArea() {
        return 2 * Math.PI * faceRadius * (faceRadius + height);
    }
    
    @Override
    public double getPerimeter() {
        return 0;
    }

    @Override
    public void displayDescription(){
    super.displayDescription();
    System.out.println("I'm also a cylinder");
    }
    
}
