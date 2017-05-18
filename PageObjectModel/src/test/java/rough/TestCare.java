package rough;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class TestCare {
	public static AndroidDriver<MobileElement> driver;
	public static void main(String[] args) throws MalformedURLException, InterruptedException {


		
		AppiumDriverLocalService service = AppiumDriverLocalService.buildService(
				new AppiumServiceBuilder().usingDriverExecutable(new File("C:\\Program Files (x86)\\Appium\\node.exe"))
						.withAppiumJS(new File("C:\\Program Files (x86)\\Appium\\node_modules\\appium\\bin\\appium.js"))
						.withLogFile(new File("c:\\appiumlogs\\logs.txt")));

		service.start();

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "Android");

		capabilities.setCapability("appPackage", "com.care.android.careview");
		capabilities.setCapability("appActivity", "com.care.android.careview.ui.startup.SplashActivity");

		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

		driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);

		
		driver.findElement(By.id("com.care.android.careview:id/sign_up_email")).click();
		driver.findElement(By.id("com.care.android.careview:id/seeker_enrollment_layout")).click();
		
		
		String actual_text = driver.findElement(By.id("com.care.android.careview:id/providerServicesHeaderText")).getText();
		//Assert.assertTrue(actual_text.contains("I AM Looking for"));
		
		String text = "Tutor";
		
		driver.findElementByAndroidUIAutomator("new UiSelector().text(\""+text+"\")").click();;

		driver.findElement(By.id("com.care.android.careview:id/email")).sendKeys("trainer@way2automation.com");
		driver.findElement(By.id("com.care.android.careview:id/password")).sendKeys("appium123");
		driver.findElement(By.id("com.care.android.careview:id/seeker_first_name")).sendKeys("Rahul");
		driver.findElement(By.id("com.care.android.careview:id/seeker_last_name")).sendKeys("Arora");
		driver.findElement(By.id("com.care.android.careview:id/seeker_birthday")).sendKeys("14/01/1985");
		
		driver.hideKeyboard();
		Thread.sleep(2000);
		
		driver.findElement(By.id("com.care.android.careview:id/seeker_optional_msg")).click();
		
		driver.findElements(By.id("android:id/text1")).get(2).click();
		
		
		
		
		Thread.sleep(4000);
		driver.quit();
		service.stop();
	}

}
