package screens.care;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import base.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomeScreen extends ScreenBase {
	
	@AndroidFindBys({
		
		@AndroidFindBy(id="com.care.android.careview:id/linearLayout"),
		@AndroidFindBy(className="android.widget.TextView"),
	})
	public List<AndroidElement> signUpBtn;
	
	
	@AndroidFindBy(id="com.care.android.careview:id/sign_up_email")
	public WebElement signUpEmail;
	
	@AndroidFindBy(id="com.care.android.careview:id/sign_up_facebook")
	public WebElement signUpFB;


	public HomeScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), this);

	}
	
	
	public int validateButtonCount(){
		
		return signUpBtn.size();
	}
	
	
	public GetStartedScreen signUpWithFacebook(){
		
		signUpFB.click();
		
		return new GetStartedScreen(driver);
	}
	
	
	public GetStartedScreen signUpWithEmail(){
		
		signUpEmail.click();
		
		return new GetStartedScreen(driver);
		//hideKeyboard();
	
	}
	
	
	public void signInToMyAccount(){
		
		
	}
	
	

}
