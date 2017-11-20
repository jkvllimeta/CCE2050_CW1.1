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
public abstract class ThreeDShapes extends Shapes implements Serializable{
    
    public ThreeDShapes(String name, int noOfSides) {
    super(name, noOfSides);
    }
    
    public abstract double getVolume();
    
}
