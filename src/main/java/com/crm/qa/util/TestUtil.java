package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.IllegalFormatException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import com.crm.qa.base.TestBase;
import com.sun.jna.platform.FileUtils;

public class TestUtil extends TestBase{

	
	public TestUtil() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public static long PAGE_LOAD_TIMEOUT=30;
	public static long IMPLICIT_WAIT =20;
	
	public static String TEST_DATA_SHEET =  "C:\\Users\\Owner\\eclipse-workspace\\FreeCrm\\src\\main\\java\\com\\crm\\qa\\testdata\\FreeCRMTestData.xlsx";
	static Workbook book;
	static Sheet sheet;
	public void switchToFrame()
	{
		driver.switchTo().frame("mainpanel");
		
	}
	public static Object[][] getTestData(String sheetname) throws Exception
	{
		FileInputStream file=null;
		try {
			file= new FileInputStream(TEST_DATA_SHEET);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		try {
			book= WorkbookFactory.create(file);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		sheet=book.getSheet(sheetname);
		Object [][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i =0;i<sheet.getLastRowNum();i++) {
			for(int k =0;k<sheet.getRow(0).getLastCellNum();k++)
			{
				data[i][k]=sheet.getRow(i + 1).getCell(k).toString();
				
			}
		}
		return data;
		
	}
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileHandler.copy(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}
}
