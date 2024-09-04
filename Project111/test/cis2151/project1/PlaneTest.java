/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cis2151.project1;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author redyr
 */
public class PlaneTest {
    
    
    public PlaneTest() {
    }

    @Test
    public void testGearDisabled(){
        Plane plane = new Plane("", 999);
        boolean expectedResult = true;
        boolean actualResult = plane.isGearEnabled();
        assertEquals(expectedResult, actualResult);
    }
    
    @Test
    public void testGearEnabled(){
        Plane plane = new Plane("", 1003, 0);
        boolean expectedResult = false;
        boolean actualResult = plane.isGearEnabled();
        assertEquals(expectedResult, actualResult);
    }
    
    @Test
    public void altitudeIsChanged(){
        Plane plane = new Plane("", 1000, 0);
        int presumableChange = 3;
        int expectedResult = plane.getCurrentAltitudeInFeet() + presumableChange;
        plane.changeCurrentAltitudeInFeet(presumableChange);
        int actualResult = plane.getCurrentAltitudeInFeet();
        assertEquals(expectedResult, actualResult);
    }
    
      @Test
    public void maxAltitude(){
        Plane plane = new Plane("", 3999, 40000);
        int maxAltitude = plane.getMaxAltitudeInFeet();
        int currentAltitude = plane.getCurrentAltitudeInFeet();
        assertTrue(maxAltitude > currentAltitude);
    }
    
}
