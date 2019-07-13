package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{

	
	
	@FindBy(xpath="//td[contains(text(),'User: Diksha Raina')]")
	WebElement userNameLabel;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newContactsLink;
	
	public HomePage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}

	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public ContactsPage clickOnContacts() throws IOException
	{
		contactsLink.click();
		return new ContactsPage(); 
	}
	
	public DealsPage clickOnDeals() throws IOException
	{
		dealsLink.click();
		return new DealsPage();
	}
	
	public TasksPage clickOnTasks() throws IOException
	{
		tasksLink.click();
		return new TasksPage();
	}
	
	public Boolean verifycorrectUseername()
	{
		return userNameLabel.isDisplayed();
		
	}
	
	public void clickOnNewContactLink() 
	{
	Actions action = new Actions(driver);
	action.moveToElement(contactsLink).build().perform();
	newContactsLink.click();
	}
}
