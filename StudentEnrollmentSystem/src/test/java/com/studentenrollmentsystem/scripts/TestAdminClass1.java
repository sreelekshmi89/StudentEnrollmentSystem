/* TestAdminClass1 :
Created By Milan
Created On :27/02/2022
Purpose: validate the admin page functionality
*/
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

public class TestAdminClass1 extends TestBase {
	
	
	LoginPage objLogin ; 
	HomePage objHome ;
	AdminPage objAdmin ;
	PageUtility objPage ;
	AdminHome objAdhome;

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

	
	
	  
		// Function to delete a student from admin page
		@Test(priority = 1,enabled = false)
		public void deleteStudent() throws InterruptedException {

			objLogin = new LoginPage(driver);
			objAdhome = new AdminHome(driver);
			objHome = new HomePage(driver);

			String alertText = objAdhome.deleteStudent();
			String expectedTitle = AutomationConstants.ADMINDELETESTUDENT;
			Assert.assertEquals(expectedTitle, alertText);
			
						
			
		}
	
		
		// Function to show student details in admin page

		
		  @Test(priority = 2) 
		  
		  public void showStdDetail() throws InterruptedException { objLogin = new
		  LoginPage(driver); objAdhome = new AdminHome(driver);
		  
		  
		  objAdhome.showStdDetails();
		  
		  String expectedURL1 =AutomationConstants.ADMINSHOWSTDETAILS;
			String actualURL1= driver.getCurrentUrl();
			Assert.assertEquals(actualURL1,expectedURL1);
		  
		  }
		
			
			// Function to see the Employee details in admin page
			
			@Test(priority = 3)
			public void empList() throws InterruptedException {
			objLogin = new LoginPage(driver);
			objAdhome =new AdminHome(driver);
			
			objAdhome.employeeList();
			

			String expectedURL1 =AutomationConstants.ADMINEMPLOYEESPAGE;
			String actualURL1= driver.getCurrentUrl();
			Assert.assertEquals(actualURL1,expectedURL1);
			
			
			}
			
			// Function to edit the Employee details in admin page
			
			@Test(priority = 4)
			public void empl_edit() throws InterruptedException {
				
				
				objLogin = new LoginPage(driver);
				objAdhome =new AdminHome(driver);
				objHome = new HomePage(driver);
				
				objAdhome.editEmployee();
				
				String expectedURL1 =AutomationConstants.ADMINEDITEMPLOYEE;
				String actualURL1= driver.getCurrentUrl();
				Assert.assertEquals(actualURL1,expectedURL1);
				
				
			}
			
			// Function to delete the Employee details in admin page
			
			@Test(priority = 5,enabled = false)
			public void empl_delete() throws InterruptedException {
				
				
				objLogin = new LoginPage(driver);
				objAdhome =new AdminHome(driver);
				objHome = new HomePage(driver);
				
				String actual = objAdhome.deleteEmployee();
				
				String expected = AutomationConstants.ADMINDELETEEMPLOYEE;
				Assert.assertEquals(expected,actual);
			}


			


			// Function to Approve Employee in admin page
			
			@Test(priority = 6)
			public void empl_app() throws InterruptedException {
				
				
				objLogin = new LoginPage(driver);
				objAdhome =new AdminHome(driver);
				objHome = new HomePage(driver);
				
				String actual = objAdhome.employee_app();
				
				String expected = AutomationConstants.ADMINAPPROVE;
				Assert.assertEquals(expected,actual);
				
				}
			
			// Function to Reject Employee in admin page
			
			@Test(priority = 7)
			public void empl_rej() throws InterruptedException {
				
				
				objLogin = new LoginPage(driver);
				objAdhome =new AdminHome(driver);
				objHome = new HomePage(driver);
				
				String actual = objAdhome.employee_rej();
				
				String expected = AutomationConstants.ADMINREJECT;
				Assert.assertEquals(expected,actual);
				
				}

			
			@Test(priority = 8)
			public void LogOut() {
				  
				  objAdhome = new AdminHome(driver);
				  
				  objAdhome.logOut();
				  
				  String expectedURL1 =AutomationConstants.LOGINPAGEURL;
					String actualURL1= driver.getCurrentUrl();
					Assert.assertEquals(actualURL1,expectedURL1);
				  
			}
				 


}
