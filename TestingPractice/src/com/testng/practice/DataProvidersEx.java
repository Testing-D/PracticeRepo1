package com.testng.practice;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvidersEx {
	
	@Test(dataProvider = "addition")
	public void add(int a, int b, int c) {
		int value = a+b;
		Assert.assertEquals(value, c);
	}
	
	@Test(dataProvider = "subtraction")
	public void sub(int a, int b, int c) {
		int value = a-b;
		Assert.assertEquals(value, c);
	}
	
	@DataProvider(name = "addition")
	public Object[][] data() {
		Object[][] data = {{1,2,3},{2,3,5},{3,4,7},{1,2,3}};
		return data;
	}
	
	@DataProvider(name = "subtraction")
	public Object[][] data1() {
		Object[][] data1 = {{1,2,-1}, {2,3,-1}, {3,4,-1},{4,5,-1}};
		return data1;
	}

}
