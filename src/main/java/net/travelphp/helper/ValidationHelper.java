package net.travelphp.helper;

import org.openqa.selenium.WebDriver;



import org.testng.Assert;

import net.travelphp.testsuite.Pageactions;
import net.travelphp.utils.LogReport;
import net.travelphp.utils.ProjectBaseConstantPaths;
import net.travelphp.utils.ReadLocators;


public class ValidationHelper {
	Pageactions page;
	LogReport log;
	ReadLocators read;
	public WebDriver driver;
	
	public ValidationHelper(WebDriver driver)
	{
		this.driver=driver;
	}
	public void performAction(WebDriver driver,String expectedData,String validationMessage) throws Exception
	{
		page = new Pageactions(driver);
		log=new LogReport();
        read=new ReadLocators();
		String actualproduct;
        actualproduct=page.getText(ReadLocators.getData(validationMessage,ProjectBaseConstantPaths.PHPTRAVELS_FILE));
		Assert.assertEquals(actualproduct, expectedData);
		log.info("Successfully validated " + expectedData);
		System.out.println(actualproduct);
		System.out.println(expectedData);
	}

}
