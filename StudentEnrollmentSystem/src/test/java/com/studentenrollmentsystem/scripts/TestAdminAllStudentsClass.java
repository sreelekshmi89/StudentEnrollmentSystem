
package com.studentenrollmentsystem.scripts;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.studentenrollmentsystem.constants.AutomationConstants;
import com.studentenrollmentsystem.pages.AdminHome;
import com.studentenrollmentsystem.pages.AdminPage;
import com.studentenrollmentsystem.pages.HomePage;
import com.studentenrollmentsystem.pages.LoginPage;
import com.studentenrollmentsystem.testbase.TestBase;
import com.studentenrollmentsystem.utilities.ExcelUtility;
import com.studentenrollmentsystem.utilities.PageUtility;

public class TestAdminAllStudentsClass extends TestBase {

	LoginPage objLogin;
	HomePage objHome;
	AdminPage objAdmin;
	PageUtility objPage;
	AdminHome objAdhome;

	// Login function for Admin

	@Test(priority = 0)

	public void verifyValidAdminLogin() throws IOException {
		objHome = new HomePage(driver);
		objLogin = new LoginPage(driver);

		objHome.clickLogin();
		objLogin.clickLoginButton();

		ArrayList<Object> result = new ArrayList<Object>();
		result = ExcelUtility.getExcelData("Login", 0); // Passing sheet name and Column number
		// System.out.println(result);

		objLogin.setEmail(result.get(0).toString());

		objLogin.setPassword(result.get(1).toString());

		objLogin.setRole(result.get(2).toString());
		objLogin.clickSignIn();

		try {
			String expectedAlert = AutomationConstants.LOGINSUCCESS;
			String actualAlert = objLogin.getAlertText();

			Assert.assertEquals(actualAlert, expectedAlert);
			objLogin.alertOK();

		} catch (InterruptedException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// Function to show student details in admin page

	
	  @Test(dependsOnMethods = { "verifyValidAdminLogin" }) public void
	  showStdDetail() throws InterruptedException { objLogin = new
	  LoginPage(driver); objAdhome = new AdminHome(driver);
	  
	  objAdhome.showStdDetails();
	  
	  String expectedURL1 =AutomationConstants.ADMINSHOWSTDETAILS;
		String actualURL1= driver.getCurrentUrl();
		Assert.assertEquals(actualURL1,expectedURL1);
	  
	  }
	 
	
	
	// Function to delete a student from admin page
	@Test(dependsOnMethods = { "verifyValidAdminLogin" })
	public void deleteStudent() throws InterruptedException {

		objLogin = new LoginPage(driver);
		objAdhome = new AdminHome(driver);
		objHome = new HomePage(driver);

		String alertText = objAdhome.deleteStudent();
		String expectedTitle = AutomationConstants.ADMINDELETESTUDENT;
		Assert.assertEquals(expectedTitle, alertText);
		
		
		
		objAdhome.logOut();
	}

}
