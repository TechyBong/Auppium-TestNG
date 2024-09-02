package techyBong.appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import org.openqa.selenium.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.*;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class TestingUtilities {
	
	AndroidDriver driver;
	AppiumDriverLocalService service;
	
	@BeforeClass
	public void configureAppium() throws MalformedURLException, URISyntaxException{
		
		//Running appium server snippet
			/*//** Start of snippet
				service=new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\subhkhan\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
						.withIPAddress("127.0.0.1").usingPort(4723).build();
				service.start();
				//** End of snippet
				*/
				
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
				driver=new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(),opt);
				
	}
	
	public void longPressAction(WebElement ele) {
		
		//Calling Long Press Gesture event using javascript. More info check below url
				//--- https://github.com/appium/appium-uiautomator2-driver/blob/master/docs/android-mobile-gestures.md
				((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", 
						ImmutableMap.of("elementId",((RemoteWebElement) ele).getId()),
						"duration",2000);
	}
	
	public void scrolltoEndAction(String direction) {
		boolean canScrollMore=false;
		do {
		canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
			    "left", 100, "top", 100, "width", 200, "height", 200,
			    "direction", direction,
			    "percent", 1.0
			));
		}while(canScrollMore);
	}
	
	public void swipeAction(WebElement ele,String direction,double percent) {
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
			    "elementId",((RemoteWebElement) ele).getId(),
			    "direction", direction,
			    "percent", percent
			));
	}
	
	public void dragDropGesture(WebElement source,int endx,int endy) {
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
			    "elementId",((RemoteWebElement) source).getId(),
			    "endX", endx,
			    "endY", endy
			));
	}
	
	@AfterClass
	public void tearDown() {
		//Quit the driver
			driver.quit();
		//Stop the server
		//	service.stop();
	}

}
