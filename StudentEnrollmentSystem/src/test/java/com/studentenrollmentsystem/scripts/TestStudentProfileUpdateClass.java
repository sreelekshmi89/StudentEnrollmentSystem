
package com.studentenrollmentsystem.scripts;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.studentenrollmentsystem.constants.AutomationConstants;
import com.studentenrollmentsystem.pages.EnrollPage;
import com.studentenrollmentsystem.pages.HomePage;
import com.studentenrollmentsystem.pages.LoginPage;
import com.studentenrollmentsystem.pages.StudentPage;
import com.studentenrollmentsystem.testbase.TestBase;
import com.studentenrollmentsystem.utilities.ExcelUtility;
import com.studentenrollmentsystem.utilities.PageUtility;

public class TestStudentProfileUpdateClass extends TestBase{
	
	
	  HomePage objHome; 
	  LoginPage objLogin;
	  StudentPage objStudent;
	  PageUtility objPage;
	  EnrollPage objEnroll;
	  
	// Login function for Student
	  
	  @Test (priority = 0)
	  public void validteStudentLogin() throws IOException { 
		  
		  objHome = new HomePage(driver); 
		  objLogin = new LoginPage(driver);
	  
	  objHome.clickLogin(); objLogin.clickLoginButton();
	  
	//Get Data  From Excel
		ArrayList<Object> result = new ArrayList<Object>();
		result = ExcelUtility.getExcelData("Login",1); //Passing sheet name and Column number
	  
	  
	  
	  objLogin.setEmail(result.get(0).toString());
	  
	  objLogin.setPassword(result.get(1).toString());
	  
	  objLogin.setRole(result.get(2).toString());
	  
	  objLogin.clickSignIn();
	  
	  
	  try { String expectedAlert = AutomationConstants.LOGINSUCCESS; 
	  String actualAlert = objLogin.getAlertText();
	  
	  Assert.assertEquals(actualAlert, expectedAlert); 
	  objLogin.alertOK();
	  
	  } catch (InterruptedException e) {
		  // TODO Auto-generated catch block
		  e.printStackTrace(); 
	  }
	  
	} 
	  
	  @Test( priority= 1)
	  
	//Function to validate Update StudentProfile from student page
	  
	  public void validateUpdateViewProfile() throws IOException, InterruptedException {
		  objStudent = new StudentPage(driver);
		  objPage= new PageUtility(driver); 
	      
	      objPage.scrollPageUp(driver);
		
		  objStudent.clickViewProfile();
		  String expectedURL= AutomationConstants.STDPROFILEURL;
		  String actualURL= driver.getCurrentUrl();
		  
		  Assert.assertEquals(actualURL,expectedURL);
		  
		  String actualText=objStudent.getStudentId();
		  System.out.println(actualText);
		  
		  objStudent.clickOnUpdate();
		  
		  
		  String expectedURL1 =AutomationConstants.UPDATESTUDENTURL;
		  String actualURL1= driver.getCurrentUrl();
		  Assert.assertEquals(actualURL1,expectedURL1);
		  
		  
			ArrayList<Object> result = new ArrayList<Object>();
			result = ExcelUtility.getExcelData("StudentProfileUpdate",0);
		  
		  objEnroll = new EnrollPage(driver);
		  //objStudent.setName("John");
		  //objStudent.setPhone("1234567890");
		  
		  objStudent.setAddress(result.get(0).toString());
		  objStudent.clickOnFormUpdate();
		  
		  String expectedURL2=AutomationConstants.HOMEPAGEURL;
		  String actualURL2= driver.getCurrentUrl();
		  Assert.assertEquals(actualURL2,expectedURL2);
				  
		  }
	 
}
