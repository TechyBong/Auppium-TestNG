package techyBong.appium;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

/*
 * @author: Subhajit Khan (https://github.com/finelens)
 * This class is for long press a webElement in a app and extract text. Text will be assert to check.
 * doc for more details: https://github.com/appium/appium-uiautomator2-driver/blob/master/docs/android-mobile-gestures.md
 *  
 */
public class AppiumTestSwipeDemo extends TestingUtilities{
	
	@Test
	public void swipeDemo() throws MalformedURLException, URISyntaxException, InterruptedException {
		/*
		 * //calling the configuration class for start server and setup AndroidDriver
		 * configureAppium();
		 */
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
		driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();
		
		WebElement ele=driver.findElement(By.xpath("//android.widget.Gallery[@resource-id='io.appium.android.apis:id/gallery']/android.widget.ImageView[1]"));
		
		System.out.println(">>>>> "+ele.getAttribute("focusable"));
		
		//Add assertion to cherck the focasable attribute of the photo is true or not
		Assert.assertEquals(driver.findElement(By.xpath("//android.widget.Gallery[@resource-id='io.appium.android.apis:id/gallery']/android.widget.ImageView[1]")).getAttribute("focusable"),"true");
		
		//Swipe Logic
		swipeAction(ele, "left", 0.45);
		
		//Add assertion to cherck the focasable attribute of the photo is false or not. Expected False as it swipe
		Assert.assertEquals(driver.findElement(By.xpath("//android.widget.Gallery[@resource-id=\"io.appium.android.apis:id/gallery\"]/android.widget.ImageView[1]")).getAttribute("focusable"),"false");
		//driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));
		
		
		Thread.sleep(2000);
		

	}
	

}
