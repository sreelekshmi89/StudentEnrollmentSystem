package com.studentenrollmentsystem.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminHome {
	WebDriver driver;

	@FindBy(xpath = "/html/body/app-root/app-header/section[2]/div/div[2]/ul[1]/li[7]/a")
	private WebElement logOut;

	@FindBy(linkText = "ALL STUDENTS")
	private WebElement students;

	@FindBy(linkText = "EMPLOYEES")
	private WebElement emp;

	@FindBy(linkText = "EMPLOYEE APPROVAL")
	private WebElement emp_app;

	@FindBy(xpath = "/html/body/app-root/app-employeeapproval/div/ul[1]/li/div[2]/button[1]")
	private WebElement approv_bt;

	@FindBy(xpath = "/html/body/app-root/app-employees/div/ul[1]/li/div[2]/button[1]")
	private WebElement edit_bt;

	@FindBy(xpath = "/html/body/app-root/app-students/div/ul[54]/li/div/div[2]/button[1]")
	private WebElement delete_bt;

	@FindBy(xpath = "/html/body/app-root/app-update-employee/div/div/form/div/div[1]/input")
	private WebElement edit_name;

	@FindBy(xpath = "/html/body/app-root/app-update-employee/div/div/form/div/div[3]/input")
	private WebElement edit_role;

	@FindBy(xpath = "/html/body/app-root/app-update-employee/div/div/form/div/div[2]/input")
	private WebElement edit_email;

	@FindBy(xpath = "/html/body/app-root/app-update-employee/div/div/form/div/div[4]/button")
	private WebElement update_bt;

	@FindBy(linkText = "SEARCH")
	private WebElement search;

	@FindBy(id = "listSearch")
	private WebElement listSearch;

	@FindBy(xpath = "/html/body/app-root/app-students/div/ul[48]/li/div/div[2]/button[1]")
	private WebElement delete;

	@FindBy(xpath = "/html/body/app-root/app-employeeapproval/div/ul[1]/li/div[2]/button[2]")
	private WebElement reject_bt;

	@FindBy(xpath = "/html/body/app-root/app-students/div/ul[1]/li/div/div[2]/button[2]")
	private WebElement showDetails;

	@FindBy(id = "//button[@class='btn btn-primary']")
	private WebElement details;

	public AdminHome(WebDriver driver) {
		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);

	}

	public void logOut() {
		logOut.click();
	}

	public String deleteStudent() throws InterruptedException {

		students.click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		// Thread.sleep(1000);

		js.executeScript("arguments[0].click()", delete);

		// delete.click();
		Alert alert = driver.switchTo().alert();
		String alertText2 = alert.getText();
		System.out.println(alertText2);
		alert.accept();

		return alertText2;
	}

	public void showStdDetails() throws InterruptedException {

		students.click();

		if (this.listSearch.isEnabled()) {
			this.listSearch.clear();
			this.listSearch.sendKeys("John");

		}

		Thread.sleep(2000);

		showDetails.click();

	}

	public void employeeList() throws InterruptedException {

		emp.click();

	}

	public String employee_app() throws InterruptedException {

		emp_app.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");

		js.executeScript("arguments[0].click()", approv_bt);

		Thread.sleep(1000);
		Alert alert = driver.switchTo().alert();
		String alertText3 = alert.getText();
		alert.accept();
		return alertText3;

	}

	public String employee_rej() throws InterruptedException {

		emp_app.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");

		js.executeScript("arguments[0].click()", reject_bt);
		// Thread.sleep(1000);
		// reject_bt.click();
		Thread.sleep(1000);
		Alert alert = driver.switchTo().alert();
		String alertText4 = alert.getText();
		alert.accept();
		return alertText4;

	}

	public void search() throws InterruptedException {

		search.click();
		if (this.listSearch.isEnabled()) {
			this.listSearch.clear();
			this.listSearch.sendKeys("John");
			Thread.sleep(1000);
		}

	}

	public String deleteEmployee() throws InterruptedException {

		emp.click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		js.executeScript("arguments[0].click()", delete_bt);

		Alert alert = driver.switchTo().alert();
		String alertText2 = alert.getText();
		System.out.println(alertText2);
		alert.accept();
		return alertText2;
	}

	public void editEmployee() throws InterruptedException {

		emp.click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");

		js.executeScript("arguments[0].click()", edit_bt);

		js.executeScript("window.scrollBy(0,1000)");
		if (this.edit_role.isEnabled()) {
			this.edit_role.clear();
			this.edit_role.sendKeys("Mentor");
			update_bt.click();
		}

	}

}
