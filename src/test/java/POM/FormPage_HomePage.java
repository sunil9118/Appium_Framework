package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Utilities.Android_Util;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class FormPage_HomePage extends Base_Page {

	public FormPage_HomePage(AndroidDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
	private WebElement nameField;
	@AndroidFindBy(id = "com.androidsample.generalstore:id/radioMale")
	private WebElement maleButton;
	@AndroidFindBy(id = "com.androidsample.generalstore:id/radioFemale")
	private WebElement femaleButton;
	@AndroidFindBy(id = "android:id/text1")
	private WebElement countryOption;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop") private WebElement submitButton;

	public void setName(String name) {

		nameField.sendKeys(name);
		driver.hideKeyboard();
	}

	public void setGender(String gender) {

		if (gender.equalsIgnoreCase("male")) {
			maleButton.click();

		} else {
			femaleButton.click();
		}

	}
	
	public void chooseCountry(String country) {
		countryOption.click();
		scrollToElement(country);
		
		
		
		driver.findElement(By.xpath("//android.widget.TextView[@text='"+country+"']")).click();
	}
	
	public void submit() {
		submitButton.click();
	}

}
