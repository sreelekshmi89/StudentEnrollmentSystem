package com.studentenrollmentsystem.scripts;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.studentenrollmentsystem.constants.AutomationConstants;
import com.studentenrollmentsystem.pages.HomePage;
import com.studentenrollmentsystem.testbase.TestBase;

public class TestHomeClass extends TestBase {
	
	HomePage objHome;
	
	// Validate Home Link
	
	@Test(priority=1 )
	public void validateHomeLink() throws IOException {
		objHome = new HomePage(driver);
		objHome.clickHome();
		
		String expectedURL = AutomationConstants.HOMEPAGEURL;
		String actualURL=driver.getCurrentUrl();
		Assert.assertEquals(actualURL,expectedURL);
		
		objHome.clickGoThroughCourse();
		String expectedURL1 = AutomationConstants.COURSESPAGEURL;
		String actualURL1=driver.getCurrentUrl();
		//System.out.println(expectedURL);
		Assert.assertEquals(actualURL1,expectedURL1);
		
	
	}
	
	//
	@Test(priority=2,enabled =true)
	public void validateShowMoreButton() throws IOException {
		
		objHome = new HomePage(driver);
		objHome.clickShowMore();
		String expectedURL = AutomationConstants.COURSESPAGEURL;
		String actualURL=driver.getCurrentUrl();
		//System.out.println(expectedURL);
		Assert.assertEquals(actualURL,expectedURL);
		
	}
	
	@Test(priority =3 )
	public void validateCourseLink() throws IOException  {
		
		objHome = new HomePage(driver);
		objHome.clickCourse();
		String expectedURL = AutomationConstants.COURSESPAGEURL;
		String actualURL=driver.getCurrentUrl();
		//System.out.println(expectedURL);
		Assert.assertEquals(actualURL,expectedURL);
		
	}
	
	@Test(priority = 4)
	public void validateLoginButton() throws IOException {
		objHome = new HomePage(driver);
		objHome.clickLogin();
		String expectedURL = AutomationConstants.LOGINPAGEURL;
		String actualURL=driver.getCurrentUrl();
		//System.out.println(expectedURL);
		Assert.assertEquals(actualURL,expectedURL);
		
	}
	@Test(priority = 5,enabled = false)
	public void validateKnowMoreButton() throws IOException{
		
		objHome = new HomePage(driver);
		objHome.clickKnowMore();
		String expectedURL = AutomationConstants.COURSEPAGEURL;
		String actualURL=driver.getCurrentUrl();
		//System.out.println(expectedURL);
		Assert.assertEquals(actualURL,expectedURL);
		
	}
	
	
	

}