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
public class Sphere extends ThreeDShapes {
    
    private double sphereRadius;
    
    public Sphere(String name, double sRadius) {
        super(name, 0);
        sphereRadius = sRadius;
    }

    @Override
    public double getVolume() {
        return (4/3) * Math.PI * Math.pow(sphereRadius, 3);
    }

    @Override
    public double getArea() {
        return 4 * Math.PI * Math.pow(sphereRadius, 2);
    }
    
    @Override
    public void displayDescription(){
    super.displayDescription();
    System.out.println("I'm also a sphere");
    }
    
    @Override
    public double getPerimeter() {

        return 0;
    }
    
}
