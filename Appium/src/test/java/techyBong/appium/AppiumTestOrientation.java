package techyBong.appium;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class AppiumTestOrientation extends TestingUtilities{
	
	@Test
	public void wifiSettingsNameLandscape() throws MalformedURLException, URISyntaxException, InterruptedException {
		/*
		 * //calling the configuration class for start server and setup AndroidDriver
		 * configureAppium();
		 */
		//Locating "Preference" element by accessibilityId and click it
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		
		/*Locator: XPath
		 * Common Syntax: tagName[@attribute='value']
		 */
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
		
		//Locator id
		driver.findElement(By.id("android:id/checkbox")).click();
		
		DeviceRotation landscape=new DeviceRotation(0, 0, 90);
		driver.rotate(landscape);//rotate the screen in mobile
		
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		String alertTxt=driver.findElement(By.id("android:id/alertTitle")).getText();
		Assert.assertEquals(alertTxt, "WiFi settings");

		
		driver.findElement(By.id("android:id/edit")).sendKeys("Subhajit");
		WebElement ele=driver.findElements(AppiumBy.className("android.widget.Button")).get(1);
		System.out.println(">> "+ele.getAttribute("text"));
		Assert.assertEquals(ele.getAttribute("text"), "OK");
		driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
		Thread.sleep(3000);
		
		//Locator androidUIAutomator
		//driver.findElement(AppiumBy.androidUIAutomator(new UiSelector().className("android.widget.RelativeLayout").instance(1))).click();
		
		/*
		 * //stop the server and service 
		 * tearDown();
		 */
	}
	

}
