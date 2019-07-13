package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;
	public LoginPageTest() throws IOException {
		super();    // calls super class constructor
		
	}
	@BeforeMethod
	public void setup() throws IOException
	{
		initialization();
		 loginpage=new LoginPage();
	}
	
 
	@Test(priority=1)
	public void loginPageTitleTest()
	{
		String title=loginpage.validateTitlePage();
		Assert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.");
		
		}
	@Test(priority=2)
	public void validateImageTest()
	{
		Boolean b=loginpage.validateCRMImage();
		Assert.assertTrue(b);
	}
	@Test()
	public void loginTest() throws IOException, InterruptedException
	{
		homepage= loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		Thread.sleep(3000);
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
}
