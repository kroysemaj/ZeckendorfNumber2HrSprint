package com.kroy.zeckendorf;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

public class ZeckendorfSprintTest {

	ZeckendorfSprint zs = new ZeckendorfSprint();
	
	@Test
	public void testExtractAFibonnaciNumberWith1() {
		assertEquals(1, zs.extractFibbonaciDigits(1));
	}
	
	@Test
	public void testExtractAFibonnaciNumberWith13() {
		assertEquals(13, zs.extractFibbonaciDigits(13));
	}
	
	@Test
	public void testExtractAFibonnaciNumberWith8() {
		assertEquals(8, zs.extractFibbonaciDigits(8));
	}
	
	@Test
	@Ignore
	//Invalidated by final test. Would extract List-returning logic and reassert this test.
	public void testTwoPartZeckendorfWith10() {
		List<Integer> eightTwo = new ArrayList<Integer>();
		eightTwo.add(8);
		eightTwo.add(2);
		assertEquals(eightTwo, zs.findZeckendorf(10));
	}
	
	@Test
	public void testConvertListToZeckNumber() {
		List<Integer> eightTwo = new ArrayList<Integer>();
		eightTwo.add(8);
		eightTwo.add(2);
		assertEquals("010010", zs.convertToZeckendorf(eightTwo));
	}
	
	@Test
	public void testRemoveLeadingZeros() {
		assertEquals("10100", zs.removeLeadingZeros("00010100"));
	}
	
	@Test
	public void testFindZeckFor10() {
		assertEquals("10010", zs.findZeckendorf(10));
	}
	
	
	
	
	
	
	

}
