package com.training.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import com.training.junitdemo.MathUtilities;

class TestMathUtil {
		
		MathUtilities mathutil;
		
	@BeforeEach
	void setup() {
		mathutil=new MathUtilities();
	}
	
	@DisplayName("Test Add Method")
	@Test
	void testadd() {		
		assertEquals(mathutil.add(10,10),20);		
	}
	
	//@Test
	@RepeatedTest(3)
	void testminus() {
		assertEquals(mathutil.minus(35,5),30);
	}
	
	@Disabled
	@Test	
	void testdivide() {
		assertEquals(mathutil.divide(10, 5),2);
	}
	
	@Test
	public void testException()
	{
		assertThrows(ArithmeticException.class, () -> mathutil.divide(9, 0) ,"Divide by zero exception");
	}
	
	@Test
	void testmultiply() {
		assertAll(
				() -> assertEquals(0, mathutil.multiply(1, 0)),
				() -> assertEquals(15, mathutil.multiply(3, 5)),
				() -> assertEquals(100,mathutil.multiply(10, 5))
				);
	}
	
	@Nested
	class AddClass{
		@Test
		void test_positive() {
			assertEquals(mathutil.add(2, 6), 8);
		}
		@Test
		void test_negative() {
			assertEquals(mathutil.add(-1, -5), -6);
		}
		
		@Test
		void test_pos_neg()
		{
			assertEquals(mathutil.add(-2,2), 0);
		}
	}

}
