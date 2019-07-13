package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{

	//Page factory
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	@CacheLookup
	WebElement contactsLabel;
	
	@FindBy(id="first_name")
	WebElement firstname;
	@FindBy(id="surname")
	WebElement lastname;
	@FindBy(name="client_lookup")
	WebElement company;
	@FindBy(xpath="//input[@type='submit' and @value='Save']")
	WebElement savebtn;
	
	//initialize page factory
	
	public ContactsPage() throws IOException {
	PageFactory.initElements(driver, this);
		
	}
	
	public boolean verifyContactsLabel()
	{
		return contactsLabel.isDisplayed();
	}

	public void selectContactByName(String name)
	{
		driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[1]/td[2]/table/tbody/tr/td/form/form/table/tbody/tr[6]/td[1]/input")).click();
	}
	public void createNewContact(String title,String Fname,String Lname,String comp)
	
	{
	 Select select = new Select(driver.findElement(By.name("title")));
	 select.selectByVisibleText(title);
	 firstname.sendKeys(Fname);
	 lastname.sendKeys(Lname);
	 company.sendKeys(comp);
	 savebtn.click();
	}
	}
