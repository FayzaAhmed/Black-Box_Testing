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

    // Testing Parameterized Constructor Quarter(java.util.Date time)
    // Testing Parameterized Constructor Quarter(java.util.Date time, java.util.TimeZone zone)
    // Testing Parameterized Constructor Quarter(int quarter, Year year)

    // Testing function compareTo(java.lang.Object o1)
    @Test
    public void testCompareToBefore()  //Same year with different quarter values
    {
        quarter = new Quarter(2, 2023);
        Quarter obj = new Quarter(3, 2023);
        int result = quarter.compareTo(obj);
        assertTrue(result < 0);
    }

    @Test
    public void testCompareToBefore2() //different year values
    {
        quarter = new Quarter(3, 2022);
        Quarter obj = new Quarter(2, 2023);
        int result = quarter.compareTo(obj);
        assertTrue(result < 0);
    }

    @Test
    public void testCompareToEqual() 
    {
        quarter = new Quarter(2, 2022);
        Quarter obj = new Quarter(2, 2022);
        int result = quarter.compareTo(obj);
        assertTrue(result == 0);
    }

    @Test
    public void testCompareToAfter() //Same year with different quarter values
    {
        quarter = new Quarter(2, 2023);
        Quarter obj = new Quarter(1, 2023);
        int result = quarter.compareTo(obj);
        assertTrue(result > 0);
    }

    @Test
    public void testCompareToAfter2() //different year values
    {
        quarter = new Quarter(2, 2023);
        Quarter obj = new Quarter(1, 2022);
        int result = quarter.compareTo(obj);
        assertTrue(result > 0);
    }

    // Testing function equals(java.lang.Object obj)
    @Test
    public void testEqualValidQuarterAndYear() 
    {
        quarter = new Quarter(2, 2023);
        Quarter obj = new Quarter(2, 2023);
        boolean result = quarter.equals(obj);
        assertTrue(result);
    }

    @Test
    public void testEqualInvalidQuater() 
    {
        quarter = new Quarter(2, 2023);
        Quarter obj = new Quarter(3, 2023);
        boolean result = quarter.equals(obj);
        assertFalse(result);
    }

    @Test
    public void testEqualInvalidYear() 
    {
        quarter = new Quarter(2, 2023);
        Quarter obj = new Quarter(2, 2022);
        boolean result = quarter.equals(obj);
        assertFalse(result);
    }

    @Test
    public void testEqualInvalidQuaterAndYear() 
    {
        quarter = new Quarter(2, 2023);
        Quarter obj = new Quarter(3, 2022);
        boolean result = quarter.equals(obj);
        assertFalse(result);
    }


    // Testing function getFirstMillisecond(java.util.Calendar calendar)

    // Testing function getLastMillisecond(java.util.Calendar calendar)

    // Testing function getQuarter()
    @Test
    public void testGetQuarter() {
        quarter = new Quarter(2, 2023);
        assertEquals(2, quarter.getQuarter(), 1E-13);
    }

    // Testing function getSerialIndex()

    // Testing function getYear()
    
    // Testing function hashCode()

    // Testing function next()
    @Test
    public void testNext() //same year
    {
        quarter = new Quarter(2, 2023);
        Quarter nextQuarter = (Quarter) quarter.next();
        assertEquals(new Quarter(3, 2023), nextQuarter);
    }

    @Test
    public void testNext2() //next quarter in different year
    {
        quarter = new Quarter(4, 2022);
        Quarter nextQuarter = (Quarter) quarter.next();
        assertEquals(new Quarter(1, 2023), nextQuarter);
    }

    @Test
    public void testNextNull()
    {
        quarter = new Quarter(4, 9999);
        assertNull(quarter.next());
    }

    /*******************************************************************************************/
    // Testing function parseQuarter(java.lang.String s)
    @Test
    public void testParseQuarter() 
    {
        // Test case 1: Valid input string format "YYYY-QN" with dash
        assertEquals(new Quarter(2, 2022), Quarter.parseQuarter("2022-Q2"));
    
        // Test case 2: Valid input string format "QN-YYYY" with dash
        assertEquals(new Quarter(2, 2022), Quarter.parseQuarter("Q2-2022"));

        // Test case 3: Valid input string format "YYYY-QN" with space
        assertEquals(new Quarter(2, 2022), Quarter.parseQuarter("2022 Q2"));
    
        // Test case 4: Valid input string format "QN-YYYY" with space
        assertEquals(new Quarter(2, 2022), Quarter.parseQuarter("Q2 2022"));

        // Test case 5: Valid input string format "YYYY-QN" with comma
        assertEquals(new Quarter(2, 2022), Quarter.parseQuarter("2022,Q2"));
    
        // Test case 6: Valid input string format "QN,YYYY" with comma
        assertEquals(new Quarter(2, 2022), Quarter.parseQuarter("Q2,2022"));

        // Test case 7: Valid input string format "YYYY-QN" with forward-slash
        assertEquals(new Quarter(2, 2022), Quarter.parseQuarter("2022/Q2"));
    
        // Test case 8: Valid input string format "QN-YYYY" with forward-slash
        assertEquals(new Quarter(2, 2022), Quarter.parseQuarter("Q2/2022"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testParseQuarterInvalidInputs() 
    {
        // Test case 1: Invalid input string (missing quarter)
        Quarter.parseQuarter("2022");        
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testParseQuarterInvalidInputs2() 
    {
        // Test case 2: Invalid input string (missing year)
        Quarter.parseQuarter("Q2");        
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testParseQuarterInvalidInputs3() 
    {
        // Test case 3: Invalid input string (invalid quarter)
        Quarter.parseQuarter("Q5-2022");        
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testParseQuarterInvalidInputs4() {
        
        // Test case 4: Invalid input string (invalid year)
        Quarter.parseQuarter("Q2-ABC");        
    }

    @Test(expected = IllegalArgumentException.class)
    public void testParseQuarterInvalidInputs5() {
        
        // Test case 5: Invalid input string (empty string)
        Quarter.parseQuarter("");        
    }

    /*******************************************************************************************/
    // Testing function previous()
    @Test
    public void testPrevious() //same year
    {
        quarter = new Quarter(2, 2023);
        Quarter previousQuarter = (Quarter) quarter.previous();
        assertEquals(new Quarter(1, 2023), previousQuarter);
    }

    @Test
    public void testPrevious2() //previous quarter in different year
    {
        quarter = new Quarter(1, 2023);
        Quarter previousQuarter = (Quarter) quarter.previous();
        assertEquals(new Quarter(4, 2022), previousQuarter);
    }

    @Test
    public void testPreviousNull()
    {
        quarter = new Quarter(1, 1900);
        assertNull(quarter.previous());
    }



    // Testing function toString()
    @Test
    public void testToString() 
    {
        quarter = new Quarter(2, 2023);
        assertEquals("Q2/2023", quarter.toString());
    }



    /*
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
