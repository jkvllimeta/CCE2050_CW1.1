/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cce2050_cw1;

/**
 *
 * @author Joseph
 */ 
public abstract class TwoDShapes extends Shapes {
    
     public TwoDShapes(String name, int noOfSides) {
     super(name, noOfSides);
         
     }
     
     public abstract double getPerimeter();
    
}
