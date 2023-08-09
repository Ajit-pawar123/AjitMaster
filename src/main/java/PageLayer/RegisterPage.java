package PageLayer;

import static UtilsLayer.SelectGender.*;
import static UtilsLayer.UtilsClass.sendkeys;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseLayer.BaseClass;
import UtilsLayer.UtilsClass;

public class RegisterPage extends BaseClass {

	@FindBy(id = "firstName")
	private WebElement firstName;
	@FindBy(id = "lastName")
	private WebElement lastName;
	@FindBy(id = "userEmail")
	private WebElement userEmail;
	@FindAll(@FindBy(xpath = "//input[@name='gender']"))
	List<WebElement> allEments;
	@FindAll(@FindBy(xpath = "//input[@type='checkbox']"))
	List<WebElement> allCheckbox;
	@FindBy(id = "userNumber")
	private WebElement userNumber;
	@FindBy(xpath = "subjects-auto-complete__input")
	private WebElement sub;

	@FindBy(id = "dateOfBirthInput")
	private WebElement date;
	@FindBy(id = "currentAddress")
	private WebElement Address;

	public RegisterPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public void registerPageFunctinality(String fname, String lname, String email, String gender) {
		sendkeys(firstName, fname);
		sendkeys(lastName, lname);
		sendkeys(userEmail, email);
		selectgender(allEments, gender);
	}

	public void registerPageFunctinality(String checkBox, String mobile) {

		sendkeys(userNumber, mobile);
		selectCheckBox(allCheckbox, checkBox);

	}

	public void registerPageFunctinality(String Sub) {
		UtilsClass.click(sub);
		sendkeys(sub, Sub);
	}

}
