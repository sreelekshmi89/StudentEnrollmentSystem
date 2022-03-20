/* TestEmployeeClass :
Created By Sreelekshmi Rohith
Created On :27/02/2022
Purpose: validate the employee page functionality
*/
package com.studentenrollmentsystem.scripts;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.studentenrollmentsystem.constants.AutomationConstants;
import com.studentenrollmentsystem.pages.AdminHome;
import com.studentenrollmentsystem.pages.EmployeePage;
import com.studentenrollmentsystem.pages.HomePage;
import com.studentenrollmentsystem.pages.LoginPage;
import com.studentenrollmentsystem.testbase.TestBase;
import com.studentenrollmentsystem.utilities.ExcelUtility;


public class TestEmployeeClass extends TestBase{
	
	
        HomePage objHome;
		LoginPage objLogin;
		EmployeePage objEmp;
		
		//Registration function for Employee 

       @Test(priority = 0)
		public void validateEmployeesignup() throws IOException {

			objHome =new HomePage(driver);
			objLogin = new LoginPage(driver);
			objHome.clickLogin();

			objLogin.clickRegisterAsNewEmployee();

			objEmp = new EmployeePage(driver);

			String expectedUrl =AutomationConstants.EMPLOYEESIGNUPURL;
		    String actualUrl = driver.getCurrentUrl();
			//System.out.println(actualUrl);
			Assert.assertEquals(expectedUrl, actualUrl);	
			
			//Get Data From Excel
			ArrayList<Object> result = new ArrayList<Object>();
			result = ExcelUtility.getExcelData("Employee",0);
			System.out.println(result);

			
			
			objEmp.setName(result.get(0).toString());  

			objEmp.setEmail(result.get(1).toString());

			objEmp.setPassword(result.get(2).toString());

			objEmp.setRole(result.get(3).toString());

			objEmp.clickRegister();

		}

     //Login function for Employee

		@Test(priority = 1)
		public void verifyValidEmployeeLogin() throws IOException {
			objHome = new HomePage(driver);
			objLogin = new LoginPage(driver);

			objHome.clickLogin();
			objLogin.clickLoginButton();
			
			//Get Data From Excel
			ArrayList<Object> result = new ArrayList<Object>();
			result = ExcelUtility.getExcelData("Login",2);
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

		// Function to validate Exit Mark Entry  in employee page
		
		@Test(priority = 2)
		public void validateExitMarkEntry() throws IOException, InterruptedException {

			objHome =new HomePage(driver);
			objLogin = new LoginPage(driver);
			objEmp = new EmployeePage(driver);


			ArrayList<Object> result = new ArrayList<Object>();
			result = ExcelUtility.getExcelData("ExitMarkEntry",0);
			//System.out.println(result);

			
			
			//objHome.clickLogin();
			//verifyValidEmployeeLogin();

			objEmp.clickAllStudents();

			//objEmp.clickSearch("John");
			
			objEmp.clickSearch(result.get(0).toString());

			objEmp.clickMarkEntryButton();

			objEmp.setMark(result.get(1).toString());

			objEmp.clickUpdate();

}
		
		// Function to view student details  in employee page
		
		@Test(priority = 3)
		public void VerifyShowStdDetail() throws InterruptedException, IOException {
		objLogin = new LoginPage(driver);
		objEmp = new EmployeePage(driver);
		
		
		//ArrayList<Object> result = new ArrayList<Object>();
		//result = ExcelUtility.getExcelData("ExitMarkEntry",0);
		//objEmp.clickAllStudents();
		//objEmp.clickSearch(result.get(0).toString());
		//objEmp.clickShowStudentDetails();
		
		
		
		
		}
		
		// Function to search student By qualification in Employee page
		
		@Test(priority = 4)
		public void Search() throws InterruptedException, IOException {
		objLogin = new LoginPage(driver);
		objEmp = new EmployeePage(driver);
		
		objEmp.clickSearchAll();
		
		objEmp.setSearchData();
		
		objLogin.LogOut();
		
		
		
		
		}
}


