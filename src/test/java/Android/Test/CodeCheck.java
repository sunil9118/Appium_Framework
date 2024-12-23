package Android.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import POM.FormPage_HomePage;
import POM.ProductCatalog_Page;

public class CodeCheck extends BaseTest {

	@Test

	public void doubtArraylist() throws InterruptedException {

		FormPage_HomePage fm = new FormPage_HomePage(driver);

		fm.setName("Sunil");
		fm.setGender("male");

		fm.chooseCountry("Argentina");
		fm.submit();

		Thread.sleep(2000);

		ProductCatalog_Page pageCatalog = new ProductCatalog_Page(driver);

		List<String> items = new ArrayList();
		items.add("Air Jordan 1 Mid SE");
		items.add("Converse All Star");
		
		
		

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
						canScrollUP= (boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture",
								ImmutableMap.of("left", (driver.manage().window().getSize().getWidth()) / 2, "top",
										(int) ((driver.manage().window().getSize().getHeight()) * 0.8), "width",
										(driver.manage().window().getSize().getWidth()) / 2, "height",
										(int) ((driver.manage().window().getSize().getHeight()) * 0.4), "direction",
										"up", "percent", 0.9));

					
					} while (canScrollUP);
					

					//canScrollMore = false;
				}

			} while (canScrollMore);
			Thread.sleep(3000);

		}
	}

}
