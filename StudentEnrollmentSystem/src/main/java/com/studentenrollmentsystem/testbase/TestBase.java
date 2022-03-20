package com.studentenrollmentsystem.testbase;

import org.testng.annotations.AfterMethod;
import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.FileHandler;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class TestBase {

	public static WebDriver  driver;
	public static Properties prop = null;

	
	String driverPath = "C:\\Users\\dhann\\Desktop\\NorkaST\\MainProject\\project docs\\StudentEnrollmentSystem\\StudentEnrollmentSystem\\src\\test\\resources\\driver\\chromedriver.exe";
	String driverPath1 = "C:\\Users\\dhann\\Desktop\\NorkaST\\MainProject\\project docs\\StudentEnrollmentSystem\\StudentEnrollmentSystem\\src\\test\\resources\\driver\\geckodriver.exe";

	public static void TestBase() {
		try {
			// Below line creates an object of Properties called 'prop'
			prop = new Properties();
			// Below line creates an object of FileInputStream called 'ip'.
			// Give the path of the properties file which you have created
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "/src/test/resources" + "/config.properties");
			// Below line of code will load the property file
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Parameters("browser")
	@BeforeTest
	public void onSetup(String browserName) {
		TestBase(); // for loading the configurations
		// String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", driverPath);
			driver = new ChromeDriver();

		} else if (browserName.equals("firefox")) {
			// geckodriver
			System.setProperty("webdriver.gecko.driver", driverPath1);
			driver = new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void tearDown(ITestResult iTestResult) throws IOException {
		if (ITestResult.FAILURE == iTestResult.getStatus()) {
			takeScreenshot(iTestResult.getName());
		}
	}

	public String takeScreenshot(String name) throws IOException {

		/*
		 * Step 1) Convert web driver object to TakesScreenshot Step 2) Call
		 * getScreenshotAs method to create image file Step 3) Copy file to Desired
		 * Location
		 */

		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		//Take the screenshot
		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		String destination = System.getProperty("user.dir") + "\\target\\" + name + dateName + ".png";

		File finalDestination = new File(destination);

		// FileHandler.copy(source, finalDestination);//or FileUtils.copyFile import
		// org.apache.commons.io.FileUtils;
		FileUtils.copyFile(source, finalDestination);
		return destination;

	}
	
	  

	@AfterTest
	public void quitDriver() {
		driver.quit();

	}
}
