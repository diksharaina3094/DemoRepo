package com.crm.qa.pages;





import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{

	
	

	//Page factory -OR
	@FindBy(name = "username")
	WebElement username;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(xpath = "//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath ="//button[contains(text(),'Sign Up')]")
	WebElement signUpBtn;
	

	@FindBy(xpath = "//img[contains(@class,'img-responsive')]")
	WebElement crmlogo;

	//Initializing Page Objects
	public LoginPage() throws IOException {
		super();
		PageFactory.initElements(driver,this); 
	}
	
	
	//Actions
	public String validateTitlePage()
	{
		return driver.getTitle();
	}
	
	public boolean validateCRMImage()
	{
		return crmlogo.isDisplayed();
	}
	
	public HomePage login(String uname ,String pwd) throws IOException, InterruptedException
	{
		username.sendKeys(uname);
		password.sendKeys(pwd);
		Thread.sleep(3000);
		loginBtn.click();
		
		return new HomePage();
	}

}
