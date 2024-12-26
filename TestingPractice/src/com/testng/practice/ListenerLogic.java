package com.testng.practice;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerLogic implements ITestListener {
	
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Test has Started");
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test is passed");
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test has Failed");
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test is Skipped");
	}
	
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("Test has Started");
	}
	
	@Override
	public void onStart(ITestContext context) {
		System.out.println("Class has Started");
	}
	
	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Class is Finished");
	}

}
