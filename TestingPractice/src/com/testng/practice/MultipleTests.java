package com.testng.practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class MultipleTests {
	
	@BeforeSuite
	public void BeforeSuite() {
		System.out.println("Before Suite");
	}
	
	@AfterSuite
	public void AfterSuite() {
		System.out.println("After Suite");
	}
	
	@BeforeClass
	public void BeforeClass() {
		System.out.println("Db Connection");
	}
	
	@AfterClass
	public void AfterClass() {
		System.out.println("Close Db Connection");
	}
	
	//Testcases will execute in alphabetical order
	@BeforeMethod
	public void BeforeMethod() {
		System.out.println("Prerequisite");
	}
	
	@AfterMethod
	public void AfterMethod() {
		System.out.println("Clear");
	}
	
	@Test(description = "This is First TestNG", priority=2, groups = {"Smoke"})
	public void cFirst() {
		System.out.println("First Test Program");
	}
	
	@Test(priority=-1, enabled=false, groups= {"Smoke"})
	public void bSecond() {
		System.out.println("Second Test Program");
	}
	
	@Test(priority=1, groups= {"Regression Test"})
	public void aThird() {
		System.out.println("Third Test Program");
	}
	
	@Test(priority=3, groups= {"Regression Test"})
	public void dFourth() {
		System.out.println("Fourth Test Program");
	}

}
