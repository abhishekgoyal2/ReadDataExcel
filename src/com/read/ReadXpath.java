package com.read;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

@SuppressWarnings("unused")
public class ReadXpath {
	WebDriver driver ;
	XSSFSheet Sheet;
	XSSFWorkbook W;
	String cell;
	FileInputStream fi;
	int lastcell;
	int lastrow ;
//Read from excel
	@Test(description="Read Search keyword through excel")
public void Readexcel() throws IOException, InterruptedException
{
	
		fi = new FileInputStream("C:/Excel xpath_amazon.xlsx");
		W = new XSSFWorkbook(fi);
		Sheet =W.getSheetAt(0);
		lastrow =Sheet.getLastRowNum();
		lastcell =Sheet.getRow(0).getLastCellNum();
		 for(int row = 1;row <= lastrow;row++)
			  
		  {
			 
	    	
		    	for(int i=0;i<lastcell;i++)
		    	  {
		    		
			   cell = Sheet.getRow(1).getCell(0).getStringCellValue();

			   System.out.println(cell); 
			    driver = new FirefoxDriver();
				 
				 String Appurl ="http://www.amazon.in/";
				driver.get(Appurl);
				driver.findElement(By.xpath(cell)).sendKeys("mobile");
//			WebElement Find= driver.findElement(By.xpath(".//*[@id='nav-search']/form/div[2]/div/input"));
//			   Searchtextbox.sendKeys(cell);
//				Find.click();
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				driver.quit();
			}
		    	  }
		  }
}

