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
public class AppiumTestDragDropGesture extends TestingUtilities{
	
	@Test
	public void dragDropGesture() throws MalformedURLException, URISyntaxException, InterruptedException {
		/*
		 * //calling the configuration class for start server and setup AndroidDriver
		 * configureAppium();
		 */
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
		
		WebElement source=driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));
		
		
		//drag drop logic Logic
		dragDropGesture(source,649,579);

		Thread.sleep(2000);
		String result= driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_result_text")).getText();
		Assert.assertEquals(result, "Dropped!");
		

	}
	

}
