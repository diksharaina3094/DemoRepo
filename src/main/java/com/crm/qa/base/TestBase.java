package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;



public class TestBase {

	public static WebDriver driver ;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	public TestBase() throws IOException
	{
		prop = new Properties(); 
		FileInputStream ip= new FileInputStream("C:\\Users\\Owner\\eclipse-workspace\\FreeCrm\\src\\main\\java\\com\\crm\\qa\\config\\config.properties"); 
		
		
		prop.load(ip);
		
		prop.getProperty("name");
		 
	}

public static void initialization() throws IOException {
	String browsername = prop.getProperty("browser");
	if(browsername.equals("chrome"))
	{
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\Chrome Driver\\chromedriver_win32\\chromedriver.exe");
		
        driver = new ChromeDriver();
	}
	else if(browsername.equals("Firefox"))
	{
		System.setProperty("webdriver.gecko.driver", "E:\\Selenium\\Gecko driver\\geckodriver-v0.24.0-win64\\geckodriver.exe");
		
		driver = new FirefoxDriver();
	}
	else if(browsername.equals("IE"))
	{
     System.setProperty("webdriver.ie.driver", "E:\\Selenium\\IEDriverServer_x64_3.14.0\\IEDriverServer.exe");
     driver = new InternetExplorerDriver();
	}
	
	e_driver = new EventFiringWebDriver(driver);
	// Now create object of EventListerHandler to register it with EventFiringWebDriver
	eventListener = new WebEventListener();
	e_driver.register(eventListener);
	driver = e_driver;
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS); 
	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	driver.get(prop.getProperty("url"));
	
	
	
	
}

} 