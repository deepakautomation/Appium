package screens.care;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import base.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CreateAccountScreen extends ScreenBase {
	
	public CreateAccountScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), this);

		// TODO Auto-generated constructor stub
	}



	@AndroidFindBy(id="com.care.android.careview:id/email")
	public WebElement em;
	@AndroidFindBy(id="com.care.android.careview:id/password")
	public WebElement pass;
	@AndroidFindBy(id="com.care.android.careview:id/seeker_first_name")
	public WebElement fName;
	@AndroidFindBy(id="com.care.android.careview:id/seeker_last_name")
	public WebElement lName;
	@AndroidFindBy(id="com.care.android.careview:id/seeker_birthday")
	public WebElement dob;
	
	@AndroidFindBy(id="com.care.android.careview:id/seeker_optional_msg")
	public WebElement marList;
	@AndroidFindBys({ @AndroidFindBy(id="android:id/text1") })
	public List<WebElement> options;
	
	
	public void addInformation(String email,String password,String firstName,String lastName,String birthDay){
		
		em.sendKeys(email);
		pass.sendKeys(password);
		fName.sendKeys(firstName);
		lName.sendKeys(lastName);
		dob.sendKeys(birthDay);
		hideKeyboard();
		marList.click();
		options.get(2).click();
		
	}

}
