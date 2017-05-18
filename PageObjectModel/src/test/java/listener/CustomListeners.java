package listener;

import java.io.IOException;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import utility.TestUtil;

public class CustomListeners implements ITestListener, ISuiteListener {

	
	/*
	 * Mails with attachment
	 * 
	 * (non-Javadoc)
	 * @see org.testng.ISuiteListener#onStart(org.testng.ISuite)
	 */
	public void onStart(ISuite suite) {
		System.out.println("Starting");
	}

	public void onFinish(ISuite suite) {
		System.out.println("Finishing");
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailure(ITestResult result) {

		System.out.println("Screenshot Captured");
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		try {
			TestUtil.takeScreenShot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Reporter.log("<a target=\"_blank\" href=\""+"screenshots/"+TestUtil.destFile+"\">Screenshot Captured</a>");
		
		Reporter.log("<br><a  target='_blank' href=\""+"screenshots/"+TestUtil.destFile+"\" ><img height=200, width=200, src=\""+"screenshots/"+TestUtil.destFile+"\" alt=\"\"/></img></a>");
	        
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {

		System.out.println("Starting the test suite");

	}

	public void onFinish(ITestContext context) {

		System.out.println("Ending the test suite");

	}

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub

	}

}
