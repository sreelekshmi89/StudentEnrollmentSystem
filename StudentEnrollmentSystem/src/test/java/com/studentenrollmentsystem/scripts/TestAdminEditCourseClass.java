
package com.studentenrollmentsystem.scripts;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.studentenrollmentsystem.constants.AutomationConstants;
import com.studentenrollmentsystem.pages.AdminPage;
import com.studentenrollmentsystem.pages.HomePage;
import com.studentenrollmentsystem.pages.LoginPage;
import com.studentenrollmentsystem.testbase.TestBase;
import com.studentenrollmentsystem.utilities.ExcelUtility;
import com.studentenrollmentsystem.utilities.PageUtility;

public class TestAdminEditCourseClass extends TestBase {

	LoginPage objLogin;
	HomePage objHome;
	AdminPage objAdmin;
	PageUtility objPage;

	// Login function for Admin

	@Test(priority = 0)
	public void verifyValidAdminLogin() throws IOException {
		objHome = new HomePage(driver);
		objLogin = new LoginPage(driver);

		objHome.clickLogin();
		objLogin.clickLoginButton();

		// Excel.getCellData();

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

	// Function to verify editing a course in admin page

	@Test(dependsOnMethods = { "verifyValidAdminLogin" })
	public void verifyEditCourse() throws IOException, InterruptedException {

		objLogin = new LoginPage(driver);
		objHome = new HomePage(driver);
		objAdmin = new AdminPage(driver);
		objPage = new PageUtility(driver);

		objAdmin.clickCourses();

		objPage.scrollPageDown(driver);

		objAdmin.MousehoverEdit();

		ArrayList<Object> result = new ArrayList<Object>();
		result = ExcelUtility.getRowData("AddCourse");

		objAdmin.setEligibility("Any Degree");

		objAdmin.UploadImage(result.get(6).toString());

		objAdmin.clickUpdateCourse();
		
		String expectedURL1 =AutomationConstants.ADMINEDITCOURSE;
		String actualURL1= driver.getCurrentUrl();
		Assert.assertEquals(actualURL1,expectedURL1);

	}

	// Function to verify Know more about a course in admin page

	@Test(dependsOnMethods = { "verifyValidAdminLogin" })
	public void verifyKnowMore() throws IOException, InterruptedException {

		objLogin = new LoginPage(driver);
		objHome = new HomePage(driver);
		objAdmin = new AdminPage(driver);
		objPage = new PageUtility(driver);

		objAdmin.clickCourses();

		objPage.scrollPageDown(driver);

		objAdmin.MousehoverKnowMore();

		
		
		String expectedURL1 =AutomationConstants.COURSEPAGEURL;
		String actualURL1= driver.getCurrentUrl();
		Assert.assertEquals(actualURL1,expectedURL1);
		
		objLogin.LogOut();

	}

}
