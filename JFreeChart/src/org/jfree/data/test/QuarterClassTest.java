package org.jfree.data.test;
import static org.junit.Assert.*;
import java.util.Date;
import org.jfree.data.time.Quarter;
import org.jfree.data.time.Year;
import org.junit.Test;
import java.util.Calendar;
import java.util.TimeZone;


public class QuarterClassTest {
    Quarter quarter;

    // Testing Default Constructor
    @Test
    public void testDefaultConstructor() 
    {
        quarter = new Quarter();
        assertEquals(2023, quarter.getYear().getYear());
        assertEquals(2, quarter.getQuarter());
    }


    // Testing Parameterized Constructor Quarter(int quarter, int year)
    @Test
    public void testParameterizedConstructorWithValidQuarterAndYear() 
    {
        int quart = 2;
        int year = 2023;
        
        quarter = new Quarter(quart, year);

        assertEquals(quart, quarter.getQuarter());
        assertEquals(year, quarter.getYear().getYear());
    }

    /*************************************BUG**************************************************/
    @Test(expected = IllegalArgumentException.class)
    public void testParameterizedConstructorWithInvalidQuarterLower() 
    {
        quarter = new Quarter(0, 1900);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testParameterizedConstructorWithInvalidQuarterUpper() 
    {
        quarter = new Quarter(5, 1900);
    }
    /********************************************************************************************/

    @Test(expected = IllegalArgumentException.class)
    public void testParameterizedConstructorWithInvalidYearLower() 
    {
        quarter = new Quarter(1, 1800);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testParameterizedConstructorWithInvalidYearUpper() 
    {
        quarter = new Quarter(1, 10000);
    }

    // Testing Parameterized Constructor Quarter(java.util.Date time)
    @Test
    public void testParameterizedConstructorWithTime()
    {
        Date date = new Date(1680300000000L); //Apr 1 , 2023
        quarter = new Quarter(date);
        Year year = new Year(2023);
        assertEquals(2, quarter.getQuarter());
        assertEquals(year, quarter.getYear());
    }


    // Testing Parameterized Constructor Quarter(java.util.Date time, java.util.TimeZone zone)
    @Test
    public void testParameterizedConstructorWithTimeAndZone()
    {
        Date date = new Date(1680300000000L); //Apr 1 , 2023
        TimeZone timeZone = TimeZone.getTimeZone("GMT+2");

        quarter = new Quarter(date, timeZone);
        Year year = new Year(2023);
       
        assertEquals(year, quarter.getYear());
        assertEquals(2, quarter.getQuarter());
    }
    
    
    // Testing Parameterized Constructor Quarter(int quarter, Year year)
    @Test
    public void testParameterizedConstuctor2()
    {
        int quart = 2;
        Year year = new Year(2023);
        quarter = new Quarter(quart, year);
        assertEquals(quart, quarter.getQuarter());
        assertEquals(year, quarter.getYear());    
    }

    /*************************************BUG**************************************************/
    @Test(expected = IllegalArgumentException.class)
    public void testParameterizedConstructorWithInvalidQuarterLower2() 
    {
        quarter = new Quarter(0, 1900);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testParameterizedConstructorWithInvalidQuarterUpper2() 
    {
        quarter = new Quarter(5, 1900);
    }
    /********************************************************************************************/

    @Test(expected = IllegalArgumentException.class)
    public void testParameterizedConstructorWithInvalidYearLower2() 
    {
        Year year = new Year(1800);
        quarter = new Quarter(1, year);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testParameterizedConstructorWithInvalidYearUpper2() 
    {
        Year year = new Year(10000);
        quarter = new Quarter(1, year);
    }
    /*
    _________________________________________________________________________________________________________________
                                            END OF TESTING CONSTRACTORS
    _________________________________________________________________________________________________________________

    */


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
    public void testEqualQuarterAndYear() 
    {
        quarter = new Quarter(2, 2023);
        Quarter obj = new Quarter(2, 2023);
        boolean result = quarter.equals(obj);
        assertTrue(result);
    }

    @Test
    public void testNotEqualQuater() 
    {
        quarter = new Quarter(2, 2023);
        Quarter obj = new Quarter(3, 2023);
        boolean result = quarter.equals(obj);
        assertFalse(result);
    }

    @Test
    public void testNotEqualYear() 
    {
        quarter = new Quarter(2, 2023);
        Quarter obj = new Quarter(2, 2022);
        boolean result = quarter.equals(obj);
        assertFalse(result);
    }

    @Test
    public void testNotEqualQuaterAndYear() 
    {
        quarter = new Quarter(2, 2023);
        Quarter obj = new Quarter(3, 2022);
        boolean result = quarter.equals(obj);
        assertFalse(result);
    }

    // Testing function getFirstMillisecond(java.util.Calendar calendar)
    @Test
    public void testGetFirstMillisecond() 
    {
        // Set up a calendar with a specific time zone
        TimeZone timeZone = TimeZone.getTimeZone("GMT+2");
        Calendar calendar = Calendar.getInstance(timeZone);

        
        // Create a Quarter object for Q2 2023
        Quarter quarter = new Quarter(2, 2023);
        
        // Set the calendar to the first day of the quarter
        calendar.set(2023, 3, 1, 0, 0, 0); // April 1, 2023 00:00:00

        long var1 = 1680300000000L;
        long var2 = quarter.getFirstMillisecond(calendar);

        assertEquals(var1, var2);
    }

    // Testing function getLastMillisecond(java.util.Calendar calendar)
    @Test
    public void testGetLastMillisecond() 
    {
        // Set up a calendar with a specific time zone
        TimeZone timeZone = TimeZone.getTimeZone("GMT+2");
        Calendar calendar = Calendar.getInstance(timeZone);
        
        // Create a Quarter object for Q1 2023
        Quarter quarter = new Quarter(1, 2023);
        
        // Set the calendar to the last millisecond of the quarter
        calendar.set(2023, 2, 31, 23, 59, 59); // March 31, 2023 23:59:59

        long var1 = 1680299999999L;
        long var2 = quarter.getLastMillisecond(calendar);

        assertEquals(var1, var2);
    }

    // Testing function getQuarter()
    @Test
    public void testGetQuarter() 
    {
        quarter = new Quarter(2, 2023);
        assertEquals(2, quarter.getQuarter());
    }

    // Testing function getSerialIndex()
    @Test
    public void testGetSerialIndex() 
    {
        quarter = new Quarter(2, 2023);
        Quarter quarter2 = new Quarter(3, 2023);
        assertTrue(quarter.getSerialIndex() < quarter2.getSerialIndex());
    }

    // Testing function getYear()
    @Test
    public void testGetYear() 
    {
        quarter = new Quarter(2, 2023);  
        Year year  = new Year(2023);             
        assertEquals(year, quarter.getYear());    
    }
    
    // Testing function hashCode()
    @Test
    public void testHashCodeValid() {
        quarter = new Quarter(1, 2023);
        Quarter quarter2 = new Quarter(1, 2023);
        Quarter quarter3 = new Quarter(2, 2023);
        assertTrue(quarter2.hashCode() == quarter.hashCode());
        assertTrue(quarter3.hashCode() != quarter.hashCode());
    }

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
    
    /*************************************BUG**************************************************/
    @Test(expected = IllegalArgumentException.class)
    public void testParseQuarterInvalidInputs3() 
    {
        // Test case 3: Invalid input string (invalid quarter)
        Quarter.parseQuarter("Q5-2022");        
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testParseQuarterInvalidInputs4() 
    {
        // Test case 4: Invalid input string (invalid year)
        Quarter.parseQuarter("Q2-ABC");        
    }

    @Test(expected = IllegalArgumentException.class)
    public void testParseQuarterInvalidInputs5() 
    {
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


    // Testing function getSerialIndex()
    //according to the rules defined in the RegularTimePeriod which 'Quarter' extends
    //the serial index is calculated based on the quarter and year with the formula:
    // serialIndex = (year * 4) + quarter
    @Test
    public void testGetSerialIndexFormula() 
    {
        int year = 2000;
        int q = 1;
        quarter = new Quarter(q, year);
        long calculatedSerialIndex = (year * 4) + q;
        assertEquals(calculatedSerialIndex, quarter.getSerialIndex());
    }

    
    @Test
    public void testHashCodeFormula() {
        quarter = new Quarter(1, 2023);
        int year = 2023;
        int quart = 1;
        int hash = ((year - 1900) * 3 * 37 + (25839 - (year - 1900) * 110) )+ (quart - 1) * 37 ;
        assertEquals(hash, quarter.hashCode());
    }


    
}