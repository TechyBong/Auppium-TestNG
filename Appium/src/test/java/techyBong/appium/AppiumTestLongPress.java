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
public class AppiumTestLongPress extends BaseEnv{
	
	@Test
	public void longPress() throws MalformedURLException, URISyntaxException, InterruptedException {
		/*
		 * //calling the configuration class for start server and setup AndroidDriver
		 * configureAppium();
		 */
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Expandable Lists']")).click();

		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='1. Custom Adapter']")).click();
		
		WebElement ele = driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
		
		//Calling Long Press Gesture event using javascript. More info check below url
		//--- https://github.com/appium/appium-uiautomator2-driver/blob/master/docs/android-mobile-gestures.md
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", 
				ImmutableMap.of("elementId",((RemoteWebElement) ele).getId()),
				"duration",2000);
		
		String text= driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"Sample menu\"]")).getText();
		Assert.assertEquals(text, "Sample menu");
		System.out.println("\n\nAssertion is True>> "+text+"\n\n");
		
		Thread.sleep(2000);
		
		
		//Locator androidUIAutomator
		//driver.findElement(AppiumBy.androidUIAutomator(new UiSelector().className("android.widget.RelativeLayout").instance(1))).click();
		
		/*
		 * //stop the server and service 
		 * tearDown();
		 */
	}
	

}
