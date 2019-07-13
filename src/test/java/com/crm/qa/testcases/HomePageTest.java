package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase{

	LoginPage loginPage;
	HomePage homepage;
	TestUtil testutil;
	ContactsPage contactspage;
	public HomePageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	
	@BeforeMethod
	public void setup() throws IOException, InterruptedException
	{
		initialization();
		testutil=new TestUtil();
		loginPage = new LoginPage();
		homepage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest()
	{
		String Hompagetitle= homepage.verifyHomePageTitle();
		Assert.assertEquals(Hompagetitle, "CRMPRO","Home Page title not matched");
	}
	
	@Test(priority=2)
	public void verifycorrectUseernameTest()
	{
		testutil.switchToFrame();
		Assert.assertTrue(homepage.verifycorrectUseername());
	}
	
	@Test(priority=3)
	public void verifyContactsLinkTest() throws IOException
	{
		testutil.switchToFrame();
		contactspage = homepage.clickOnContacts();
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
}
