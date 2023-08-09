package UtilsLayer;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import BaseLayer.BaseClass;

public class SelectGender extends BaseClass {

	public static void selectgender(List<WebElement> ls, String genderstatus) {
		for (WebElement abc : ls) {
			String a = abc.getAttribute("value");
			if (a.equalsIgnoreCase(genderstatus)) {
				((JavascriptExecutor) getDriver()).executeScript(("arguments[0].click();"), abc);
				break;
			}
		}

	}

	public static void selectCheckBox(List<WebElement> ls, String Check) {
		for (WebElement abc : ls) {

			String[] str = Check.split(" ");
			for (int i = 0; i < str.length; i++) {
				String str1 = str[i];
				String a = abc.getAttribute("value");
				String x = null;
				if (str1.equalsIgnoreCase("sports")) {
					x = "1";
				} else if (str1.equalsIgnoreCase("reading")) {
					x = "2";
				} else {
					x = "3";

				}
				if (a.equalsIgnoreCase(x)) {
					((JavascriptExecutor) getDriver()).executeScript(("arguments[0].click();"), abc);
					break;
				}

			}
		}
	}

}
