package POM;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

import com.google.common.collect.ImmutableMap;

import Utilities.Android_Util;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Base_Page extends Android_Util {
	AndroidDriver driver;
	
	
	public Base_Page(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		
		PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);

	}
	
	


}
