package Android.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {
	AppiumDriverLocalService service;
	AndroidDriver driver;

	@BeforeClass
	public void preSetup() throws MalformedURLException, URISyntaxException {

		service = new AppiumServiceBuilder()
				.withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();

		service.start();

		UiAutomator2Options option = new UiAutomator2Options();

		option.setDeviceName("Sunil_Android");
		option.setApp("/Users/qa_pebbles/eclipse-workspace/AppiumFramework/src/test/resources/appContainer/General-Store.apk");
		//option.setApp("/Users/qa_pebbles/eclipse-workspace/appium/src/test/java/resource/ApiDemos-debug.apk");

		driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), option);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}
	
	
	@AfterClass
	public void postQuit() {

		driver.quit();

		service.stop();

	}

}
