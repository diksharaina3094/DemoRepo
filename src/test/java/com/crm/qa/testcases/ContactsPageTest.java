package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homepage;
	TestUtil testutil;
	ContactsPage contactspage;
	String sheetname = "contacts";
	
	@BeforeMethod
	public void setup() throws IOException, InterruptedException
	{
		initialization();
		testutil=new TestUtil();
		loginPage = new LoginPage();
		contactspage = new ContactsPage();
		homepage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		testutil.switchToFrame();
		contactspage = homepage.clickOnContacts();
		
	}
	
	
	
//	@Test(priority=1)
//	public void verifyContactsLabelTest()
//	{
//		Assert.assertTrue(contactspage.verifyContactsLabel(),"Contacts label is missing ");
//		
//	}
//	
//
//	@Test(priority=2)
//	public void selectContactByNameTest()
//	{
//		contactspage.selectContactByName("test1 test2");
//		
//	}
	
	@DataProvider
	public Object[][] getTestData() throws Exception
	{
		Object[][] data= TestUtil.getTestData(sheetname);
		return data;
	}
//	@Test(priority=1)
//	public void validateCreateNewContactTest() throws IOException
//	{
//		homepage.clickOnNewContactLink();
//		contactspage.createNewContact("Mr.", "Tom", "Peter", "Google");
//		 
//	}
	
	@Test(priority=1,dataProvider="getTestData")
	public void validateCreateNewContactTest(String title,String Fname,String Lname,String comp) throws IOException
	{
		homepage.clickOnNewContactLink();
		contactspage.createNewContact(title, Fname, Lname, comp);
		 
	}
	
	
	@AfterMethod
	public void teardown()
	{
		//driver.quit();
	}
	public ContactsPageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

}
