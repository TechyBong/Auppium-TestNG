package techyBong.appium;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class AppiumTestNavigateUsingActivityPackage extends TestingUtilities{
	
	@Test
	public void pressKeyDemo() throws MalformedURLException, URISyntaxException, InterruptedException {
		/*
		 * //calling the configuration class for start server and setup AndroidDriver
		 * configureAppium(); //Uncomment if you are not starting the server from cmd
		 */
		
		//adb shell dumpsys window | find "mCurrentFocus" - windows
		
		//io.appium.android.apis/io.appium.android.apis.preference.PreferenceDependencies}
		
		//App Package & Activity
		//Activity activity=new Activity("io.appium.android.apis","io.appium.android.apis.preference.PreferenceDependencies}");
		System.out.println("I am before start activity");
		((JavascriptExecutor) driver).executeScript("mobile: startActivity", ImmutableMap.of(
				"intent","io.appium.android.apis/io.appium.android.apis.preference.PreferenceDependencies"));
		System.out.println("I am after start activity");
		
		String wifiTxt=driver.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/title' and @text='WiFi']")).getText();
		System.out.println(">>> "+wifiTxt);
		Assert.assertEquals(wifiTxt, "WiFi");
		System.out.println(">> is Checked:: "+driver.findElement(AppiumBy.id("android:id/checkbox")).getAttribute("checkable"));
		//Locator id
		driver.findElement(AppiumBy.id("android:id/checkbox")).click();
		
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		String alertTxt=driver.findElement(By.id("android:id/alertTitle")).getText();
		Assert.assertEquals(alertTxt, "WiFi settings");
		driver.findElement(By.id("android:id/edit")).sendKeys("Subhajit");
		
		driver.pressKey(new KeyEvent(AndroidKey.ENTER)); //Hit enter key
		
		driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
		
		driver.pressKey(new KeyEvent(AndroidKey.BACK));//hit back key
		Thread.sleep(2000);
		driver.pressKey(new KeyEvent(AndroidKey.HOME));//hit home key
	}
	

}
