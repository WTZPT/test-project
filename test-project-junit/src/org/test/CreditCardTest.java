package org.test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;





@RunWith(Parameterized.class)  
public class CreditCardTest {

	CreditCard creditCard;
	private long input;
	private int expectedSumOfOddPlace;
	private int digitExpected;
	private int SumOfDoubleEvenPlaceExpected;
	private boolean isValidExpected;
	 @Parameters  
	 @SuppressWarnings("unchecked")  
	  public static Collection prepareData1(){  
	        Object[][] object = {{4111111111111111L,8,8,22,true},{38520000023237L,21,3,19,false},{6011000000000004L,5,5,5,true},
	               };  
	       
	       return Arrays.asList(object);  
	   } 
	
	 public CreditCardTest(long input,int expected,int digitExpected,
			 int SumOfDoubleEvenPlaceExpected,boolean isValidExpected){  
	        this.input = input;  
	        this.expectedSumOfOddPlace = expected;  
	        this.digitExpected = digitExpected;
	        this.SumOfDoubleEvenPlaceExpected = SumOfDoubleEvenPlaceExpected;
	        this.isValidExpected = isValidExpected;
	 }
	 	
	@Before
	public void setUp() throws Exception {
		 creditCard = new CreditCard();
	}

	@Test
	public void testIsValid() {
		boolean result = creditCard.isValid(input);
		Assert.assertEquals(isValidExpected,result);
	}

	@Test
	public void testSumOfDoubleEvenPlace() {
		int result = creditCard.sumOfDoubleEvenPlace(input);
		Assert.assertEquals(result, SumOfDoubleEvenPlaceExpected);
	}

	@Test
	public void testGetDigit() {
		int result = creditCard.getDigit(expectedSumOfOddPlace);
		Assert.assertEquals(digitExpected, result);
	}

	//3)从卡号最后一位数字开始,奇数位数字相加
	@Test
	public void testSumOfOddPlace() {
		 int result = creditCard.sumOfOddPlace(input);
	     Assert.assertEquals(expectedSumOfOddPlace,result);  
	}

}
