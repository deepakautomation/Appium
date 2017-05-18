package testcases.care;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestBase;
import screens.care.HomeScreen;
import screens.care.TypeOfCareGiver;
import utility.TestUtil;

public class CareLoginTest extends TestBase{
	
	
	
	HomeScreen home;
	TypeOfCareGiver tc;
	
	@BeforeTest
	public void init(){
		
		home = new HomeScreen(driver);
		tc = new TypeOfCareGiver(driver);
	}
	
	@Test(priority=1)
	public void validateButtons(){
		
		System.out.println(home.validateButtonCount()+" Total buttons");
		Assert.assertEquals(4, home.validateButtonCount());
	}
	
	@Test(priority=2,dataProvider="getData")
	public void signUpEmailandSelectACareGiver(String headerText){
		
		//driver.amange.window
		home.signUpWithEmail().hireACareGiver();
		String actual_text = tc.getCareTypeHeader();
		System.out.println(actual_text);
		Assert.assertTrue(actual_text.contains(headerText));
		
		
	}
	
	
	@DataProvider
	public static Object[][] getData() {


		return TestUtil.getData("CareLoginTest");

	}

}
