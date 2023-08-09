package UtilsLayer;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import BaseLayer.BaseClass;

public class JavascriptClass extends BaseClass {

	public static void javaScript(WebElement wb) {
		if (wb.isDisplayed() && wb.isEnabled()) {
			((JavascriptExecutor) getDriver()).executeScript(("arguments[0].click();"), wb);
		}
	}
}
