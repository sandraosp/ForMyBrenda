package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {

	public static void main(String args[]) {
      org.junit.runner.JUnitCore.main("is.ru.stringcalculator.CalculatorTest");
    }

	@Test
	public void testEmptyString() {
		assertEquals(0, Calculator.add(""));
	}

	@Test
	public void testOneNumber() {
		assertEquals(1, Calculator.add("1"));
	}

	@Test
	public void testTwoNumbers() {
		assertEquals(3, Calculator.add("1,2"));
	}	

	@Test
    public void testMultipleNumbers(){
    	assertEquals(6, Calculator.add("1,2,3"));
    	assertEquals(7, Calculator.add("2,2,3"));
    }

    @Test
    public void testNewlineBetweenNumbers(){
    	assertEquals(6, Calculator.add("1\n2,3"));
    	assertEquals(7, Calculator.add("2,2\n3"));
    	assertEquals(9, Caclulator.add("2,3\n4"));
    }

    @Test
    public void testNegativeNumbers(){
    try
	{
		Calculator.add("-1,-2,-3");
		Calculator.add("-1,2,-2");
		Calculator.add("2,-5,3,-7");
	}
	catch (IllegalArgumentException a)
	{
	  	System.out.println("Negatives not allowed: " + a);
    }

    }

    @Test
    public void testBiggerNumbers(){
    	assertEquals(1003, Calculator.add("1,2,1000"));
    	assertEquals(12, Calculator.add("3,1002,4,5"));
    	assertEquals(3, Calculator.add("2000,2,1"));
    }

    @Test
    public void testDifferentDelimiter(){
    	assertEquals(3, Calculator.add("//k\n1k2"));
    	assertEquals(3, Calculator.add("//;\n1;2"));
    }


}