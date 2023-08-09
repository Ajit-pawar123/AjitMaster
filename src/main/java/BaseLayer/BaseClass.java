package BaseLayer;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class BaseClass {
	private static ThreadLocal<WebDriver> threadlocal = new ThreadLocal<WebDriver>();

	public static WebDriver getDriver() {
		return threadlocal.get();
	}
	public void initialization(String Browsername) {
		WebDriver driver = null;
		if(Browsername.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(Browsername.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
		}
		threadlocal.set(driver);
		driver.get("https://demoqa.com/automation-practice-form");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

	}

}
