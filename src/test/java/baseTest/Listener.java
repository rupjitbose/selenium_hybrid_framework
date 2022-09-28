package baseTest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import globalData.extentReportsNG;

public class Listener extends Base implements ITestListener {
		
	
	ExtentTest test;
	ExtentReports ext=extentReportsNG.getReportObject();
	ThreadLocal<ExtentTest> extTest=new ThreadLocal<ExtentTest>();
		
		
		@Override
	  public void onTestStart(ITestResult result) {
			
		  test=ext.createTest(result.getMethod().getMethodName());
		  extTest.set(test);
	  }

		@Override
	  public void onTestSuccess(ITestResult result) {
			extTest.get().log(Status.PASS,"Test Passed");
	  }

		@Override
	  public void onTestFailure(ITestResult result) {
		  
			extTest.get().fail(result.getThrowable());
		  try {
			driver= (WebDriver)
					  result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		  String s=null;
		try {
			s=takeScreenShot(result.getMethod().getMethodName(),driver);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Screenshot not available");
		}
		extTest.get().addScreenCaptureFromPath(s,result.getMethod().getMethodName());
		
	  }

		@Override
	  public  void onTestSkipped(ITestResult result) {
	    // not implemented
	  }

		@Override
	  public  void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	    // not implemented
	  }
		@Override
	  public  void onTestFailedWithTimeout(ITestResult result) {
	    
	  }

		@Override
	  public  void onStart(ITestContext context) {
	    
	  }

		@Override
	  public  void onFinish(ITestContext context) {
	    ext.flush();
	  }
	}



