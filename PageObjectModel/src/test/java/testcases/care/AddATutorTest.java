package testcases.care;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestBase;
import screens.care.CreateAccountScreen;
import screens.care.TypeOfCareGiver;
import utility.TestUtil;

public class AddATutorTest extends TestBase{
	
	TypeOfCareGiver tc;
	CreateAccountScreen ca;
	@BeforeTest
	public void init(){
		
		tc = new TypeOfCareGiver(driver);
		ca = new CreateAccountScreen(driver);
	}
	
	
	@Test(dataProvider="getData")
	public void AddATutor(String email,String password,String firstName,String lastName,String birthDay){
		
		tc.selectTypeOfCare();
		ca.addInformation(email, password, firstName, lastName, birthDay);
		
	}
	
	@DataProvider
	public static Object[][] getData() {


		return TestUtil.getData("AddATutorTest");

	}

}
