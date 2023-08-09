package UtilsLayer;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import BaseLayer.BaseClass;

public class ListenersClass extends BaseClass implements ITestListener {
	ExtentReports reports;
	ExtentTest extentTest;

	public void onStart(ITestContext context) {
		reports = ExtentReportSetup.setUp("test suite is start" + context.getSuite().getName());

	}

	public void onTestStart(ITestResult result) {
		extentTest = reports.createTest("test case is Sart" + result.getMethod().getMethodName());

	}

	public void onTestSuccess(ITestResult result) {
		extentTest.log(Status.PASS, "test case is pass" + result.getMethod().getMethodName());
		try {
			extentTest.addScreenCaptureFromPath(
					ExtentReportSetup.takesScreenshot("PassScreenshot", result.getMethod().getMethodName()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void onTestFailure(ITestResult result) {
		extentTest.log(Status.FAIL, "test case is fail" + result.getMethod().getMethodName());
		try {
			extentTest.addScreenCaptureFromPath(
					ExtentReportSetup.takesScreenshot("FailScreenshot", result.getMethod().getMethodName()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult result) {
		extentTest.log(Status.SKIP, "test case is skipp" + result.getMethod().getMethodName());

	}

	public void onFinish(ITestContext context) {
		reports.flush();
	}

}
