package com.studentenrollmentsystem.scripts;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.studentenrollmentsystem.constants.AutomationConstants;
import com.studentenrollmentsystem.pages.EnrollPage;
import com.studentenrollmentsystem.pages.HomePage;
import com.studentenrollmentsystem.pages.LoginPage;
import com.studentenrollmentsystem.testbase.TestBase;
import com.studentenrollmentsystem.utilities.ExcelUtility;

public class TestEnrollClass extends TestBase {

	HomePage objHome;
	LoginPage objLogin;
	EnrollPage objEnroll;

	//Login function for Student
	
	@Test(priority = 0)
	public void validateRegisterAsStundent() throws IOException {

		objHome = new HomePage(driver);
		objLogin = new LoginPage(driver);

		objHome.clickLogin();
		objLogin.clickRegisterAsNewStudent();

		String expectedURL = AutomationConstants.ENROLLEPAGEURL;
		String actualURL = driver.getCurrentUrl();

		// System.out.println(expectedURL);
		Assert.assertEquals(actualURL, expectedURL);
	}

	//Function to validate Enroll a course in Student page
	
	@Test(priority = 2)
	public void validateEnroll() throws IOException {

		objHome = new HomePage(driver);
		objLogin = new LoginPage(driver);
		
		//objHome.clickLogin();

		
		ArrayList<Object> result = new ArrayList<Object>();
		result = ExcelUtility.getExcelData("Student",0); //Passing sheet name and Column number
		//System.out.println(result);
		
		objLogin.clickLoginButton();

		objLogin.clickRegisterAsNewStudent();

		objEnroll = new EnrollPage(driver);

		objEnroll.setName(result.get(0).toString());

		objEnroll.setEmail(result.get(1).toString());

		objEnroll.setPassword(result.get(2).toString());

		objEnroll.setPhone(result.get(3).toString());

		objEnroll.setAddress(result.get(4).toString());

		objEnroll.setDistrict(result.get(5).toString());

		objEnroll.setState(result.get(6).toString());

		objEnroll.setQualification(result.get(7).toString());

		objEnroll.setPassout(result.get(8).toString());

		objEnroll.setSkills(result.get(9).toString());

		objEnroll.setEmploymentStatus(result.get(10).toString());

		objEnroll.setTechTraining(result.get(11).toString());

		objEnroll.setCourse(result.get(12).toString());

		objEnroll.uploadImage(result.get(13).toString());

		objEnroll.clickRegister();

		objEnroll.TestTransaction();

		objEnroll.closeWindow();

		String expectedAlert = AutomationConstants.PAYMENT;
		try {

			String actualAlert = objLogin.getAlertText();

			Assert.assertEquals(actualAlert, expectedAlert);

			objLogin.alertOK();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	//Function to Check InValidate Enroll in Student page

	@Test(priority = 1, enabled = true)
	public void validateInvalidEnroll() throws IOException {

		objHome = new HomePage(driver);
		objLogin = new LoginPage(driver);

		// Get data from Excel
	
		ArrayList<Object> result = new ArrayList<Object>();
		result = ExcelUtility.getExcelData("Student",1); //Passing sheet name and Column number
		//System.out.println(result);

		//objHome.clickLogin();
		
		objLogin.clickLoginButton();

		objLogin.clickRegisterAsNewStudent();

		objEnroll = new EnrollPage(driver);

		objEnroll.setName(result.get(0).toString());

		objEnroll.setEmail(result.get(1).toString());

		objEnroll.setPassword(result.get(2).toString());

		objEnroll.setPhone(result.get(3).toString());

		objEnroll.setAddress(result.get(4).toString());

		objEnroll.setDistrict(result.get(5).toString());

		objEnroll.setState(result.get(6).toString());

		objEnroll.setQualification(result.get(7).toString());

		objEnroll.setPassout(result.get(8).toString());

		objEnroll.setSkills(result.get(9).toString());

		objEnroll.setEmploymentStatus(result.get(10).toString());

		objEnroll.setTechTraining(result.get(11).toString());

		objEnroll.setCourse(result.get(12).toString());

		objEnroll.uploadImage(result.get(13).toString());

		
		
		String expectedPhoneErrorMessage2 = AutomationConstants.STDEMAILERRORMESSAGE;
		String actualPhoneErrorMessage2 = objEnroll.getEmailErrorMessage();
		Assert.assertEquals(actualPhoneErrorMessage2, expectedPhoneErrorMessage2);

		objEnroll.clickRegister();

	}

}
