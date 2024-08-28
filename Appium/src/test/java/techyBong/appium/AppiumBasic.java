package techyBong.appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumBasic {
	
	@Test
	public void appiumTest() throws MalformedURLException, URISyntaxException {
		
		//Running appium server snippet
		//** Start of snippet
		AppiumDriverLocalService service=new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\subhkhan\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		service.start();
		//** End of snippet
		
		//Capabilities: device info/name, android version, app details
		UiAutomator2Options opt=new UiAutomator2Options();
		opt.setDeviceName("Emulator2");
		opt.setApp("C:\\Users\\subhkhan\\Appium\\Appium\\src\\test\\java\\techyBong\\resources\\ApiDemos-debug.apk");
		
		/*
		//AndroidDriver, Create a object of AndroidDriver class
		//appium code -> Appium server -> Mobile
		//Capabilities: device info/name, android version, app details
		
		 * we have pass the appium url which we can get after the start of the
		 *appium server from cmd. To find the URL we need to check the log.
		 *Usually the url will be the mentioned one. Other parameter is Capabilities,
		 *which can be passed using UiAutomator2Options object. This object store 
		 *device name, app name.
		 */
		//Create AndroideDriver object
		AndroidDriver driver=new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(),opt);
		
		//Actual Automation
		/*Locators
		 * Xpath, id, accessibility(AppiumBy), classname and androidUIAutomator(AppiumBy)
		 */
		
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		
		
		//Quit the driver
		//driver.quit();
		//Stop the server
		service.stop();
	}

}
