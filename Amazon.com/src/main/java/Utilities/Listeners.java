package Utilities;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import BaseClass.BaseClass;

public class Listeners extends BaseClass implements ITestListener{

	public void onTestStart(ITestResult result) {
		Reporter.log("Method name is : "+ result.getName());
		System.out.println("Test Starting...");
	}
	
	public void onTestSuccess(ITestResult result) {
		Reporter.log("Status of the execution is : "+ result.getStatus());
		System.out.println("Executed sucessfully..");
	}
	
	public void onTestFailure(ITestResult result) {
		System.out.println("Test failed screenshot captured");
		Reporter.log("Status of the execution is : "+ result.getStatus());
	}
	
}
