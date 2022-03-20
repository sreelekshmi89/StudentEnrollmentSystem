/* TestAdminClass :
Created By Dhannya
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

public class TestAdminClass extends TestBase {
	
	
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

	
	
	  //Function to reset a course in admin page
	  
	  @Test(priority = 1) public void validateResetCourse() throws IOException,
	  InterruptedException {
	  
	  objLogin = new LoginPage(driver); objHome = new HomePage(driver);
	  
	  objAdmin = new AdminPage(driver);
	  
	  
	  objAdmin.clickCourses();
	  
	  objAdmin.clickAddCourse();
	  
	  ArrayList<Object> result = new ArrayList<Object>(); result =
	  ExcelUtility.getRowData("AddCourse");
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
		
		
	
		
		// Function to verify editing a course in admin page

			@Test(priority = 3)
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

			@Test(priority = 4)
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
				

			}
			
			

			
			// Function to search student By name admin page

			@Test(priority = 5)
			public void verifySearchByName() throws InterruptedException {

				objLogin = new LoginPage(driver);
				objHome = new HomePage(driver);
				objAdmin = new AdminPage(driver);

				objAdmin.clickSearch();

				objAdmin.setItem("John");

				//Thread.sleep(2000);
				
				String expectedURL1 =AutomationConstants.ADMINSEARCH;
				String actualURL1= driver.getCurrentUrl();
				Assert.assertEquals(actualURL1,expectedURL1);

			}

			// Function to search student By qualification in admin page
			
			@Test(priority = 6)
			public void verifySearchByQualification() {

				objLogin = new LoginPage(driver);
				objHome = new HomePage(driver);
				objAdmin = new AdminPage(driver);


				//objAdmin.clickSearch();

				objAdmin.setItem("MCA");
				
				String expectedURL1 =AutomationConstants.ADMINSEARCH;
				String actualURL1= driver.getCurrentUrl();
				Assert.assertEquals(actualURL1,expectedURL1);

				
				

			}
			

			// Function to delete a student from admin page
			@Test(priority = 7,enabled = false)
			public void deleteStudent() throws InterruptedException {

				objLogin = new LoginPage(driver);
				objAdhome = new AdminHome(driver);
				objHome = new HomePage(driver);

				String alertText = objAdhome.deleteStudent();
				String expectedTitle = AutomationConstants.ADMINDELETESTUDENT;
				Assert.assertEquals(expectedTitle, alertText);
				
							
				
			}
		
			
			// Function to show student details in admin page

			
			  @Test(priority = 8,enabled = false) 
			  
			  public void showStdDetail() throws InterruptedException {
				  objLogin = new
			  LoginPage(driver); objAdhome = new AdminHome(driver);
			  
			  
			  objAdhome.showStdDetails();
			  
			  String expectedURL1 =AutomationConstants.ADMINSHOWSTDETAILS;
				String actualURL1= driver.getCurrentUrl();
				Assert.assertEquals(actualURL1,expectedURL1);
			  
			  }
			
				
				// Function to see the Employee details in admin page
				
				@Test(priority = 9)
				public void empList() throws InterruptedException {
				objLogin = new LoginPage(driver);
				objAdhome =new AdminHome(driver);
				
				objAdhome.employeeList();
				

				String expectedURL1 =AutomationConstants.ADMINEMPLOYEESPAGE;
				String actualURL1= driver.getCurrentUrl();
				Assert.assertEquals(actualURL1,expectedURL1);
				
				
				}
				
				// Function to edit the Employee details in admin page
				
				@Test(priority = 10)
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
				
				@Test(priority = 11,enabled = false)
				public void empl_delete() throws InterruptedException {
					
					
					objLogin = new LoginPage(driver);
					objAdhome =new AdminHome(driver);
					objHome = new HomePage(driver);
					
					String actual = objAdhome.deleteEmployee();
					
					String expected = AutomationConstants.ADMINDELETEEMPLOYEE;
					Assert.assertEquals(expected,actual);
				}


				


				// Function to Approve Employee in admin page
				
				@Test(priority = 12)
				public void empl_app() throws InterruptedException {
					
					
					objLogin = new LoginPage(driver);
					objAdhome =new AdminHome(driver);
					objHome = new HomePage(driver);
					
					String actual = objAdhome.employee_app();
					
					String expected = AutomationConstants.ADMINAPPROVE;
					Assert.assertEquals(expected,actual);
					
					}
				
				// Function to Reject Employee in admin page
				
				@Test(priority = 13)
				public void empl_rej() throws InterruptedException {
					
					
					objLogin = new LoginPage(driver);
					objAdhome =new AdminHome(driver);
					objHome = new HomePage(driver);
					
					String actual = objAdhome.employee_rej();
					
					String expected = AutomationConstants.ADMINREJECT;
					Assert.assertEquals(expected,actual);
					
					}

			
			@Test(priority = 14)
			
			public void LogOut() {
				  
				  objAdhome = new AdminHome(driver);
				  
				  objAdhome.logOut();
				  
				  String expectedURL1 =AutomationConstants.LOGINPAGEURL;
					String actualURL1= driver.getCurrentUrl();
					Assert.assertEquals(actualURL1,expectedURL1);
				  
			}
				 


}
