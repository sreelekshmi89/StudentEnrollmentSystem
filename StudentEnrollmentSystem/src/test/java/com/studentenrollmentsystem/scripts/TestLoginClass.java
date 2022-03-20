package com.studentenrollmentsystem.scripts;


	import java.io.IOException;
    import java.util.ArrayList;

	import org.openqa.selenium.Alert;
	import org.testng.Assert;
	import org.testng.annotations.Test;

	import com.studentenrollmentsystem.constants.AutomationConstants;
	import com.studentenrollmentsystem.pages.HomePage;
	import com.studentenrollmentsystem.pages.LoginPage;
import com.studentenrollmentsystem.testbase.TestBase;
import com.studentenrollmentsystem.utilities.ExcelUtility;

	public class TestLoginClass extends TestBase {

		HomePage objHome;
		LoginPage objLogin;

		// To validate the Login functionality of Admin with Invalid password 


		@Test(priority = 0)
		public void verifyInValidAdminLoginPassword() throws IOException {
			objHome = new HomePage(driver);
			objLogin = new LoginPage(driver);

			objHome.clickLogin();
			objLogin.clickLoginButton();
			
			//Get Data for Admin InValid Login From Excel
			ArrayList<Object> result = new ArrayList<Object>();
			result = ExcelUtility.getExcelData("Login",3); //Passing sheet name and Column number
			//System.out.println(result);

			objLogin.setEmail(result.get(0).toString());
			  
			objLogin.setPassword(result.get(1).toString());
			  
			objLogin.setRole(result.get(2).toString());
			  
			objLogin.clickSignIn();
		    
			try {
				String expectedAlert = AutomationConstants.LOGINADMINVALIDPASWORD;
				String actualAlert = objLogin.getAlertText();

				Assert.assertEquals(actualAlert, expectedAlert);
				objLogin.alertOK();

			} catch (InterruptedException e) { // TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		// To validate the Login functionality of Admin with Invalid credentials
		
		@Test(priority = 1 ,enabled =true)
		public void verifyInValidAdminLogin() throws IOException {
			
			objHome = new HomePage(driver);
			objLogin = new LoginPage(driver);

           
			//Get Data  From Excel
			ArrayList<Object> result = new ArrayList<Object>();
			result = ExcelUtility.getExcelData("Login",4); //Passing sheet name and Column number
			//System.out.println(result);

			objLogin.setEmail(result.get(0).toString());
			  
			objLogin.setPassword(result.get(1).toString());
			  
			objLogin.setRole(result.get(2).toString());

			objLogin.clickSignIn();



			try {
				String expectedAlert = AutomationConstants.LOGININVALID;
				String actualAlert = objLogin.getAlertText();

				Assert.assertEquals(actualAlert, expectedAlert);
				objLogin.alertOK();

			} catch (InterruptedException e) { // TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
		// To validate the Login functionality of Student with Invalid password 
		
		@Test(priority = 2)
		public void verifyInValidStudentLoginPassword() throws IOException {
			objHome = new HomePage(driver);
			objLogin = new LoginPage(driver);

			objHome.clickLogin();
			objLogin.clickLoginButton();
			
			//Get Data for Admin InValid Login From Excel
			
			ArrayList<Object> result = new ArrayList<Object>();
			result = ExcelUtility.getExcelData("Login",6); //Passing sheet name and Column number
			//System.out.println(result);

			objLogin.setEmail(result.get(0).toString());
			  
			objLogin.setPassword(result.get(1).toString());
			  
			objLogin.setRole(result.get(2).toString());
			  
			objLogin.clickSignIn();
		    
			try {
				String expectedAlert = AutomationConstants.LOGINSTDENTINVALIDPASSWORD;
				String actualAlert = objLogin.getAlertText();

				Assert.assertEquals(actualAlert, expectedAlert);
				objLogin.alertOK();

			} catch (InterruptedException e) { // TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
		// To validate the Login functionality of Employee with Invalid password   
		
		
		@Test(priority = 3)
		public void verifyInValidEmployeeLoginPassword() throws IOException {
			objHome = new HomePage(driver);
			objLogin = new LoginPage(driver);

			objHome.clickLogin();
			objLogin.clickLoginButton();
			
			//Get Data for Admin InValid Login From Excel
			ArrayList<Object> result = new ArrayList<Object>();
			result = ExcelUtility.getExcelData("Login",5); //Passing sheet name and Column number
			//System.out.println(result);

			objLogin.setEmail(result.get(0).toString());
			  
			objLogin.setPassword(result.get(1).toString());
			  
			objLogin.setRole(result.get(2).toString());
			  
			objLogin.clickSignIn();
		    
			try {
				String expectedAlert = AutomationConstants.LOGINEMPINVALIDPASSWORD;
				String actualAlert = objLogin.getAlertText();

				Assert.assertEquals(actualAlert, expectedAlert);
				objLogin.alertOK();

			} catch (InterruptedException e) { // TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
		// To validate the Login functionality of Admin with valid credentials

		@Test(priority = 4,enabled = true)
		public void verifyValidAdminLogin() throws IOException {
			
			objHome = new HomePage(driver);
			objLogin = new LoginPage(driver);


			//Get Data From Excel
			ArrayList<Object> result = new ArrayList<Object>();
			result = ExcelUtility.getExcelData("Login",0); //Passing sheet name and Column number
			System.out.println(result);

			objLogin.setEmail(result.get(0).toString());
			  
			objLogin.setPassword(result.get(1).toString());
			  
			objLogin.setRole(result.get(2).toString());
			objLogin.clickSignIn();


			try {
				String expectedAlert =AutomationConstants.LOGINSUCCESS;
				String actualAlert = objLogin.getAlertText();

				Assert.assertEquals(actualAlert, expectedAlert);
				objLogin.alertOK();


			} catch (InterruptedException e) { // TODO Auto-generated catch block
				e.printStackTrace();
			}

			objLogin.LogOut();

		}

		// To validate the Login functionality of Student with valid credentials
		
		@Test(priority = 5)
		public void verifyValidStudentLogin() throws IOException {
			objHome = new HomePage(driver);
			objLogin = new LoginPage(driver);

			ArrayList<Object> result = new ArrayList<Object>();
			result = ExcelUtility.getExcelData("Login",1); //Passing sheet name and Column number
			System.out.println(result);

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

			objLogin.LogOut();

		}
		
		// To validate the Login functionality of Employee with valid credentials

		@Test(priority = 6)
		public void verifyValidEmployeeLogin() throws IOException {
			objHome = new HomePage(driver);
			objLogin = new LoginPage(driver);

			ArrayList<Object> result = new ArrayList<Object>();
			result = ExcelUtility.getExcelData("Login",2); //Passing sheet name and Column number
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

			objLogin.LogOut();

		}
	}



