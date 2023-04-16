package org.jfree.data.test;
import static org.junit.Assert.assertEquals;

import java.time.Year;

import org.jfree.data.time.Quarter;
import org.junit.Test;


public class QuarterClassTest {
    Quarter quarter;
    Year year;
    @Test
    public void testDefaultConstructor() {
        quarter = new Quarter();
        assertEquals(2023, quarter.getYear().getYear());
        assertEquals(2, quarter.getQuarter());
    }


    @Test
    public void testParameterizedConstructor() {

        int quart = 2;
        int year = 2023;
        
        quarter = new Quarter(quart, year);

        assertEquals(quart, quarter.getQuarter(), 1E-13);
        assertEquals(year, quarter.getYear().getYear(), 1E-13);
    }

   /*
    @Test
    public void testParameterizedConstructor2() {

        int quart = 2;
        //Year year = new Year(2023);
        int curr = 2023;
       // year = new Year(2023);
        Year year = Year.of(2023);

        quarter = new Quarter(quart, year);

        assertEquals(quart, quarter.getQuarter(), 1E-13);
        assertEquals(year, quarter.getYear(), 1E-13);
    }*/
    
}
