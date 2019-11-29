package net.travelphp.testsuite;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import net.travelphp.dataprovider.ReadDataFromExcel;
import net.travelphp.utils.LogReport;
import net.travelphp.utils.ProjectBaseConstantPaths;

public class Pageactions extends TestBase {
	LogReport log = new LogReport();
	WebElement webElement;
	
	  ReadDataFromExcel reader = getsheet(ProjectBaseConstantPaths.EXPECTED_FILE1);
	  
	  
	public ReadDataFromExcel getsheet(String sheetname) {
		ReadDataFromExcel read = new ReadDataFromExcel();
		try {
			read.setPath(sheetname);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return read;
	}
	 public Pageactions(WebDriver driver) {
		 this.driver=driver;
	 }

	
	  public String getdata_fromExcel(String sheetname, String columnname, String rowname) {
	 
	  String datavalue = reader.getCellDataByColumnName(sheetname, columnname, rowname); 
	  return datavalue;
	  }

	public WebElement selectLocators(String locatorType) {
		String[] locator = locatorType.split(":");

		switch (locator[0]) {
		case "id":
			webElement = driver.findElement(By.id(locator[1]));
			break;
		case "name":
			webElement = driver.findElement(By.name(locator[1]));
			break;
		case "className":
			webElement = driver.findElement(By.className(locator[1]));
			break;
		case "linkText":
			webElement = driver.findElement(By.linkText(locator[1]));
			break;
		case "partialLinkText":
			webElement = driver.findElement(By.partialLinkText(locator[1]));
			break;
		case "tagName":
			webElement = driver.findElement(By.tagName(locator[1]));
			break;
		case "cssSelector":
			webElement = driver.findElement(By.cssSelector(locator[1]));
			break;
		case "xpath":
			System.out.println(locator[1]+"--->>>>");
			webElement = driver.findElement(By.xpath(locator[1]));
			break;

		}
		return webElement;
	}

	public void clickOnElement(String element) {
		webElement = selectLocators(element);
		webElement.click();
	}

	public void sendKeys(String element,String value) {

		webElement = selectLocators(element);
		webElement.sendKeys(value);
	}

	public String getText(String element) {
		webElement = selectLocators(element);
		return webElement.getText();

	}
}
