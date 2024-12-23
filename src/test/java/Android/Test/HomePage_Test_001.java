package Android.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;

import POM.FormPage_HomePage;
import POM.ProductCatalog_Page;

public class HomePage_Test_001 extends BaseTest{
	
	
	@Test
	
	public void formPage() throws InterruptedException {
		
		FormPage_HomePage fm = new FormPage_HomePage(driver);
		
		fm.setName("Sunil");
		fm.setGender("male");
		
		fm.chooseCountry("Argentina");
		fm.submit(); 
		
		Thread.sleep(2000);
			
		
		
		ProductCatalog_Page pageCatalog =  new ProductCatalog_Page(driver);
		
		//pageCatalog.scrollDown();
		
		ArrayList<String> items = new ArrayList();
		
		
		items.add("Air Jordan 1 Mid SE");
		items.add("Converse All Star");
		
		pageCatalog.selectProduct(items);
		
		
		
		
	//	pageCatalog.AddtoCart("Converse All Star");
		
		//Thread.sleep(2000);

		//pageCatalog.AddtoCart("Nike Blazer Mid '77");
		
		Thread.sleep(3000);
		
	
	}

}
