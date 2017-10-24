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
public class CW1_2050 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        final Rectangle testRect = new Rectangle ("Rect", 5, 10);
        testRect.displayDescription();
        System.out.println("Area    : " + testRect.getArea());
        System.out.println("Perimeter: " + testRect.getPerimeter());
        
        final Circle testCirc = new Circle ("Circ", 10);
        testCirc.displayDescription();
        System.out.println("Area    : " + testCirc.getArea());
        System.out.println("Perimeter: " + testCirc.getPerimeter());
        
        final Triangle testTri = new Triangle ("Tri", 10, 20, 15);
        testTri.displayDescription();
        System.out.println("Area    : " + testTri.getArea());
        System.out.println("Perimeter: " + testTri.getPerimeter());
        
        final Sphere testSphere = new Sphere ("Sph", 30);
        testSphere.displayDescription();
        System.out.println("Area    : " + testSphere.getArea());
        System.out.println("Volume: " + testSphere.getVolume());
        
        final Cylinder testCylinder = new Cylinder ("Cyl", 30, 20);
        testCylinder.displayDescription();
        System.out.println("Area    : " + testSphere.getArea());
        System.out.println("Volume: " + testSphere.getVolume());
    
    }
    
}
