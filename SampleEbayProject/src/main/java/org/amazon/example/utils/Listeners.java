package org.amazon.example.utils;

import org.amazon.example.base.Helper;
import org.testng.IInvokedMethod;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.LogStatus;

public class Listeners extends Helper
		implements ITestListener  {

	public void onFinish(ITestContext Result) {

		logger.info(Result.getName() + " test case is completed");
		
		
	}

	public void onStart(ITestContext Result) {
		
	 
		if(!Result.getName().equalsIgnoreCase("Default test"))
		{
		Screenshot.createScreenshotDir(Result.getName());
		}
		

	}

	public void beforeInvocation(IInvokedMethod arg0, ITestResult arg1) {

		String textMsg = "About to begin executing method : " + returnMethodName(arg0.getTestMethod());

		logger.info(textMsg);

	}

	public void afterInvocation(IInvokedMethod arg0, ITestResult arg1) {

		
		String textMsg = "Completed executing method : " + returnMethodName(arg0.getTestMethod());
		 logger.info(textMsg);

	}

	private String returnMethodName(ITestNGMethod method) {

		return method.getRealClass().getSimpleName() + "." + method.getMethodName();

	}

	public void onTestFailure(ITestResult Result) {
		
		try {
			test.log(LogStatus.FAIL, "Test case failed"+test.addScreenCapture(Screenshot.takeScreenshot(driver)));
		} catch (Exception e) {
			 e.printStackTrace();
		}
		report.endTest(test);
		logger.info("The name of the testcase failed is :" + Result.getName());

	}

	public void onTestSkipped(ITestResult Result) {
		report.endTest(test);
		logger.info("The name of the testcase Skipped is :" + Result.getName());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

	}

	public void onTestStart(ITestResult Result) {

		testcaseName = Result.getName();
		test = report.startTest(testcaseName);

		logger.info(Result.getName() + " test case started");

	}

	public void onTestSuccess(ITestResult Result) {

		test.log(LogStatus.PASS, "Testcase passed");
		report.endTest(test);
		logger.info("The name of the testcase passed is :" + Result.getName());
	}

	 

	 

}
