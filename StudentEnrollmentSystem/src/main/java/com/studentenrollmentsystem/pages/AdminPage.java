package com.studentenrollmentsystem.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminPage {

	WebDriver driver;

	@FindBy(linkText = "Add Course")
	private WebElement addcourse;

	@FindBy(xpath = "/html/body/app-root/app-header/section[2]/div/div[2]/ul[1]/li[2]/a")
	private WebElement Courses;

	@FindBy(id = "cname")
	private WebElement nameofcourse;

	@FindBy(id = "certification")
	private WebElement certification;

	@FindBy(id = "code")
	private WebElement code;

	@FindBy(id = "details")
	private WebElement details;

	@FindBy(name = "price")
	private WebElement price;

	@FindBy(name = "eligibility")
	private WebElement eligibility;

	@FindBy(name = "image")
	private WebElement image;

	@FindBy(xpath = "/html/body/app-root/app-add-course/div/div/div/div/div/div/form/div[5]/button[1]")
	private WebElement addnewcourse;

	@FindBy(xpath = "//*[@id=\"courses\"]/div/div/div[2]/div[1]/div/div/button[1]/a")
	private WebElement knowmore;

	@FindBy(xpath = "//*[@id=\"courses\"]/div/div/div[2]/div[1]/div/div/button[2]/a")
	private WebElement editcourse;

	@FindBy(xpath = "/html/body/app-root/app-update-course/div/div/div/div/div/div/form/div[5]/button[1]")
	private WebElement updatecourse;

	@FindBy(xpath = "/html/body/app-root/app-add-course/div/div/div/div/div/div/form/div[5]/button[2]")
	private WebElement resetAddcourse;

	@FindBy(xpath = "/html/body/app-root/app-update-course/div/div/div/div/div/div/form/div[5]/button[2]")
	private WebElement reset;

	@FindBy(xpath = "/html/body/app-root/app-header/section[2]/div/div[2]/ul[1]/li[6]/a")
	private WebElement search;

	@FindBy(id = "listSearch")
	private WebElement type;

	public AdminPage(WebDriver driver) {
		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}

	public void clickAddNewCourse() {
		if (this.addnewcourse.isDisplayed())

			this.addnewcourse.click();

	}

	public void clickSearch() {
		if (this.search.isDisplayed())

			this.search.click();

	}

	public void clickResetAddcourse() throws InterruptedException {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", resetAddcourse);

	}

	public void MousehoverEdit() throws InterruptedException {
		// Instantiate Action Class
		Actions actions = new Actions(driver);
		// Retrieve WebElemnt 'slider' to perform mouse hover
		// WebElement slider = driver.findElement);
		// Move mouse to x offset 50 i.e. in horizontal direction
		actions.moveToElement(editcourse, 50, 0).perform();
		Thread.sleep(1000);

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", editcourse);

	}

	public void MousehoverKnowMore() {
		// Instantiate Action Class
		Actions actions = new Actions(driver);

		actions.moveToElement(knowmore, 50, 0).perform();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", knowmore);

	}

	public void clickUpdateCourse() {
		if (this.updatecourse.isEnabled())
			this.updatecourse.click();

	}

	public void clickAddCourse() {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", addcourse);

	}

	public void clickCourses() {
		if (this.Courses.isEnabled())
			this.Courses.click();

	}

	public void setItem(String type) {

		if (this.type.isEnabled()) {
			this.type.clear();
			this.type.sendKeys(type);
		}
	}

	public void setNameOfCourse(String nameofcourse) {

		WebElement myDynamicElement = new WebDriverWait(driver, 30)
				.until(ExpectedConditions.presenceOfElementLocated(By.id("cname")));
		myDynamicElement.sendKeys(nameofcourse);

	}

	public void setCertification(String certification) {

		if (this.certification.isEnabled()) {
			this.certification.clear();
			this.certification.sendKeys(certification);
		}
	}

	public void setCode(String code) {

		if (this.code.isEnabled()) {
			this.code.clear();
			this.code.sendKeys(code);
		}
	}

	public void setDetails(String details) {

		if (this.details.isEnabled()) {
			this.details.clear();
			this.details.sendKeys(details);
		}
	}

	public void setPrice(String price) {

		if (this.price.isEnabled()) {
			this.price.clear();
			this.price.sendKeys(price);
		}
	}

	public void setEligibility(String eligibility) {

		if (this.eligibility.isEnabled()) {
			this.eligibility.clear();
			this.eligibility.sendKeys(eligibility);
		}
	}

	public void UploadImage(String image) {

		if (this.image.isEnabled()) {
			this.image.clear();
			this.image.sendKeys(image);
		}
	}

}