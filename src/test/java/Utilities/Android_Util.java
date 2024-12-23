package Utilities;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class Android_Util {
	AndroidDriver driver;

	public Android_Util(AndroidDriver driver) {
		this.driver = driver;
		// TODO Auto-generated constructor stub
	}

	public void longPressing(WebElement ele) {

		((JavascriptExecutor) driver).executeScript("mobile:longClickGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) ele).getId(), "duration", 2000));

	}

	public void swipe(WebElement ele, String direction) {

		((JavascriptExecutor) driver).executeScript("mobile:swipeGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) ele).getId(), "direction", direction, "percent", 0.3));

	}

	/*
	 * public void scrollDown() {
	 * 
	 * boolean canScrollMore; do {
	 * 
	 * canScrollMore= (Boolean) ((JavascriptExecutor)
	 * driver).executeScript("mobile: scrollGesture", ImmutableMap.of( "left", 100,
	 * "top", 100, "width", 200, "height", 200, "direction", "down", "percent", 0.3
	 * ));
	 * 
	 * }while(canScrollMore); }
	 */

	public void scrollToElement(String elementString) {
		driver.findElement(AppiumBy.androidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + elementString + "\"));"));

	}

	public void scrollDown() {

		boolean canScrollMore;
		do {

			canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture",
					ImmutableMap.of("left", (driver.manage().window().getSize().getWidth()) / 2, "top",
							(int) ((driver.manage().window().getSize().getHeight()) * 0.4), "width",
							(driver.manage().window().getSize().getWidth()) / 2, "height",
							(int) ((driver.manage().window().getSize().getHeight()) * 0.4), "direction", "down",
							"percent", 0.9));

		} while (canScrollMore);
	}

	public void selectProduct(ArrayList<String> items) {

		for (String itemName : items) {

			boolean canScrollMore;
			do {

				if (driver.findElement(By.xpath(
						"//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productName\"]"))
						.getDomAttribute("text").equals(itemName)) {

					WebElement itemCart = driver.findElement(By.xpath("//android.widget.TextView[@text=\"" + itemName
							+ "\"]/parent::android.widget.LinearLayout//android.widget.TextView[@text='ADD TO CART']"));

					itemCart.click();

					// itemfound =1;

					break;
				}

				canScrollMore = (boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture",
						ImmutableMap.of("left", (driver.manage().window().getSize().getWidth()) / 2, "top",
								(int) ((driver.manage().window().getSize().getHeight()) * 0.4), "width",
								(driver.manage().window().getSize().getWidth()) / 2, "height",
								(int) ((driver.manage().window().getSize().getHeight()) * 0.4), "direction", "down",
								"percent", 0.7));

				if (canScrollMore == false) {
					// boolean canScrollUp;

					boolean canScrollUP = true;
					do {

						if (driver.findElement(By.xpath(
								"//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productName\"]"))
								.getDomAttribute("text").equals(itemName)) {

							WebElement itemCart = driver.findElement(By.xpath("//android.widget.TextView[@text=\""
									+ itemName
									+ "\"]/parent::android.widget.LinearLayout//android.widget.TextView[@text='ADD TO CART']"));

							itemCart.click();

							// itemfound =1;

							break;

						}
						canScrollUP = (boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture",
								ImmutableMap.of("left", (driver.manage().window().getSize().getWidth()) / 2, "top",
										(int) ((driver.manage().window().getSize().getHeight()) * 0.8), "width",
										(driver.manage().window().getSize().getWidth()) / 2, "height",
										(int) ((driver.manage().window().getSize().getHeight()) * 0.4), "direction",
										"up", "percent", 0.9));

					} while (canScrollUP);

					// canScrollMore = false;
				}

			} while (canScrollMore);
		}

	}

	public void scrollUp() {

		boolean canScrollMore;
		do {

			canScrollMore = (boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture",
					ImmutableMap.of("left", (driver.manage().window().getSize().getWidth()) / 2, "top",
							(int) ((driver.manage().window().getSize().getHeight()) * 0.8), "width",
							(driver.manage().window().getSize().getWidth()) / 2, "height",
							(int) ((driver.manage().window().getSize().getHeight()) * 0.4), "direction", "up",
							"percent", 0.9));

		} while (canScrollMore);
	}

}
