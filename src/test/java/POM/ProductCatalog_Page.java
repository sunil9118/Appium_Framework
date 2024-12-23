package POM;

import java.util.ArrayList;
import java.util.List;

import io.appium.java_client.android.AndroidDriver;

public class ProductCatalog_Page extends Base_Page {

	public ProductCatalog_Page(AndroidDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	

	
	public void AddtoCart(ArrayList<String> items) throws InterruptedException {

		
		//selectItemProductCatalog(items);
		
		selectProduct(items);

	}

}
