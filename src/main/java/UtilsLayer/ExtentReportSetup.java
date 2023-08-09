package UtilsLayer;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import BaseLayer.BaseClass;

public class ExtentReportSetup extends BaseClass {

	public static ExtentReports setUp(String foldername) {
		String path = System.getProperty("user.dir") + "//ExtentReport//" + foldername + date() + ".html";
		ExtentSparkReporter ext = new ExtentSparkReporter(path);
		ExtentReports reports = new ExtentReports();
		reports.attachReporter(ext);
		return reports;

	}

	public static String date() {
		return new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date());
	}

	public static String takesScreenshot(String foldername, String screenshotname) throws IOException {
		File f = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "//" + foldername + "//" + screenshotname + date() + ".png";
		FileUtils.copyFile(f, new File(path));
		return path;
	}
}
