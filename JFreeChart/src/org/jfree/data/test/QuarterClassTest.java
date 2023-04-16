package org.jfree.data.test;
import static org.junit.Assert.*;
import java.util.Date;
import java.time.Year;
import org.jfree.data.time.Quarter;
import org.junit.Test;


public class QuarterClassTest {
    Quarter quarter;

    // Testing Default Constructor
    @Test
    public void testDefaultConstructor() {
        quarter = new Quarter();
        assertEquals(2023, quarter.getYear().getYear());
        assertEquals(2, quarter.getQuarter());
    }


    // Testing Parameterized Constructor Quarter(int quarter, int year)
    @Test
    public void testParameterizedConstructorWithValidQuarterAndYear() {

        int quart = 2;
        int year = 2023;
        
        quarter = new Quarter(quart, year);

        assertEquals(quart, quarter.getQuarter(), 1E-13);
        assertEquals(year, quarter.getYear().getYear(), 1E-13);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testParameterizedConstructorWithInvalidQuarterLower() {
        quarter = new Quarter(0, 1900);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testParameterizedConstructorWithInvalidQuarterUpper() {
        quarter = new Quarter(5, 1900);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testParameterizedConstructorWithInvalidYearLower() {
        quarter = new Quarter(1, 1800);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testParameterizedConstructorWithInvalidYearUpper() {
        quarter = new Quarter(1, 10000);
    }
   

    @Test
    public void testParameterizedConstructorWithValidDate() {
        quarter = new Quarter(new Date(1640995200000L)); // January 1, 2022
        assertEquals(1, quarter.getQuarter(), 1E-13);
        //assertNotNull(quarter);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testParameterizedConstructorWithInvalidDate() {
        quarter = new Quarter(new Date(0L)); // January 1, 1970
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




 /* 
    @Test
    public void testConstructorWithValidQuarterAndYear() {
        Quarter quarter = new Quarter(1, Year.of(2022));
        assertNotNull(quarter);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithInvalidQuarterAndYear() {
        Quarter quarter = new Quarter(5, Year.of(2022));
    }
*/
