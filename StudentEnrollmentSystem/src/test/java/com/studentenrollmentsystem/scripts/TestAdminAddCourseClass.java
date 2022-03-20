package com.studentenrollmentsystem.scripts;
import java.io.IOException;
import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.studentenrollmentsystem.constants.AutomationConstants;
import com.studentenrollmentsystem.pages.AdminHome;
import com.studentenrollmentsystem.pages.AdminPage;
import com.studentenrollmentsystem.pages.EmployeePage;
import com.studentenrollmentsystem.pages.HomePage;
import com.studentenrollmentsystem.pages.LoginPage;
import com.studentenrollmentsystem.testbase.TestBase;
import com.studentenrollmentsystem.utilities.ExcelUtility;
import com.studentenrollmentsystem.utilities.PageUtility;

public class TestAdminAddCourseClass extends TestBase {

	LoginPage objLogin ; 
	HomePage objHome ;
	AdminPage objAdmin ;
	PageUtility objPage ;
	AdminHome objAdHome;

	//Login function for Admin 
	
	@Test(priority = 0)
	public void verifyValidAdminLogin() throws IOException {
		
		objLogin =new LoginPage(driver); 
		objHome = new HomePage(driver);
		
		objHome.clickLogin();
		objLogin.clickLoginButton();

		ArrayList<Object> result = new ArrayList<Object>();
		result = ExcelUtility.getExcelData("Login",0); //Passing sheet name and Column number
		//System.out.println(result);

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

	//Function to reset a course in admin page
	
	@Test(priority = 1)
	public void validateResetCourse() throws IOException, InterruptedException {

		objLogin = new LoginPage(driver);
		objHome = new HomePage(driver);
		
		objAdmin = new AdminPage(driver);

		//verifyValidAdminLogin();

		objAdmin.clickCourses();

		objAdmin.clickAddCourse();

		ArrayList<Object> result = new ArrayList<Object>();
		result = ExcelUtility.getRowData("AddCourse");
        objAdmin.setNameOfCourse(result.get(0).toString());

		objAdmin.clickResetAddcourse();
		
		String expectedURL =AutomationConstants.ADMINADDCOURSE;
		  String actualURL= driver.getCurrentUrl();
		  Assert.assertEquals(actualURL,expectedURL);

		
	}
	
	//Function to add a course in admin page

	@Test(priority = 2)
	public void validateAddCourse() throws IOException, InterruptedException {

		objLogin = new LoginPage(driver);
		objHome = new HomePage(driver);
		objAdmin = new AdminPage(driver);
		objPage = new PageUtility(driver);

		//verifyValidAdminLogin();

		//objAdmin.clickCourses();

		objPage.scrollPageUp(driver);

		

		ArrayList<Object> result = new ArrayList<Object>();
		result = ExcelUtility.getRowData("AddCourse");



		

		objAdmin.setNameOfCourse(result.get(0).toString());

		objAdmin.setCertification(result.get(1).toString());

		objAdmin.setCode(result.get(2).toString());

		objAdmin.setDetails(result.get(3).toString());

		objAdmin.setPrice(result.get(4).toString());

		objAdmin.setEligibility(result.get(5).toString());

		objAdmin.UploadImage(result.get(6).toString());


		objAdmin.clickAddNewCourse();


		String expectedURL1 =AutomationConstants.ADMINADDCOURSE;
		String actualURL1= driver.getCurrentUrl();
		Assert.assertEquals(actualURL1,expectedURL1);

	}
	
	@Test(priority = 3)
	
	  public void LogOut() {
	  
	  objAdHome = new AdminHome(driver);
	  
	  objAdHome.logOut(); 
	  
	  String expectedURL1 =AutomationConstants.LOGINPAGEURL;
		String actualURL1= driver.getCurrentUrl();
		Assert.assertEquals(actualURL1,expectedURL1);
	  
	  }
	 
	  

	

}
