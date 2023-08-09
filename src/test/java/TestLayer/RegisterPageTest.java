package TestLayer;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import BaseLayer.BaseClass;
import PageLayer.RegisterPage;

@Test(groups = { "RegisterPage", "EndToEndTesting" })
public class RegisterPageTest extends BaseClass {
	private RegisterPage registerpage;

	@Parameters({ "Browsername" })
	@BeforeTest
	public void setUp(String Browsername) {
		initialization(Browsername);
	}

	@Test(priority = 1)
	public void validateRegisterFunctinality() {

		registerpage = new RegisterPage();
		registerpage.registerPageFunctinality("Ajit", "Pawar", "Ajit@gmail.com", "female");

	}

	@Test(priority = 2)
	public void validateRegisterFunctinality2() {
		registerpage.registerPageFunctinality("reading music", "9766681087");
	}

}
