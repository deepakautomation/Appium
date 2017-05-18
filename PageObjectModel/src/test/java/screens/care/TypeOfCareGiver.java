package screens.care;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TypeOfCareGiver extends ScreenBase {
	
	public TypeOfCareGiver(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), this);

		// TODO Auto-generated constructor stub
	}

	@AndroidFindBy(id="com.care.android.careview:id/providerServicesHeaderText")
	public WebElement headerText;
	
	@AndroidFindBy(uiAutomator="new UiSelector().text(\"Tutor\")")
	public WebElement tutor;
	
	
	
	public String getCareTypeHeader(){
		
		waitForElementPresent(10,"com.care.android.careview:id/providerServicesHeaderText");
		//wait.until(ExpectedConditions.)
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.care.android.careview:id/providerServicesHeaderText")));
		
		return headerText.getText();
		
	}
	
	public void selectTypeOfCare(){
		
		tutor.click();
		
	}

}
