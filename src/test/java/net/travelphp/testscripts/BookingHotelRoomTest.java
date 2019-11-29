package net.travelphp.testscripts;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import net.travelphp.helper.BookingDateHelper;
import net.travelphp.testsuite.Pageactions;
import net.travelphp.testsuite.TestBase;
import net.travelphp.utils.LogReport;
import net.travelphp.utils.ProjectBaseConstantPaths;
import net.travelphp.utils.ReadLocators;
import net.travelphp.utils.HotelSelection;
import net.travelphp.utils.LoadProperties;
import net.travelphp.validation.ValidationResult;

public class BookingHotelRoomTest extends TestBase{
	BookingDateHelper date;
	Pageactions page;
	LoadProperties properties;
	ReadLocators read;
	LogReport log;
	 JavascriptExecutor execute;
	 HotelSelection select;
	String url;
	ValidationResult validate;
	@BeforeClass
	public void setup() throws IOException {
        page=new Pageactions(driver);
		properties=new LoadProperties();
		log=new LogReport();
	url=LoadProperties.readConfig("PhpTravels_url", ProjectBaseConstantPaths.CONFIG_FILE);
	driver.get(url);
	driver.manage().window().maximize();
	log.info("Application is open...");
	}
	
	@Test
	public void roomBooking() throws Exception {
		date=new BookingDateHelper();
		read=new ReadLocators();
		page=new Pageactions(driver);
		log=new LogReport();
		validate=new ValidationResult();
		select=new HotelSelection();
	 log.info("STEP#1: Home page validation");
		   validate.homepageValidation(driver);
	 log.info("STEP#2: Entering City name");
           execute=(JavascriptExecutor) driver;
           execute.executeScript("window.scrollBy(0,150)");
		   page.clickOnElement(ReadLocators.readPropertiesFile("loc.destinationcity.btn", ProjectBaseConstantPaths.PHPTRAVELS_FILE));
		   String destination=page.getdata_fromExcel("RoomBooking", "Enter Data", "Destination City");
     	   page.sendKeys(ReadLocators.readPropertiesFile("loc.destinationcity.txt", ProjectBaseConstantPaths.PHPTRAVELS_FILE), destination);
     	   Thread.sleep(3000);
     	   page.clickOnElement(ReadLocators.readPropertiesFile("loc.destination.btn", ProjectBaseConstantPaths.PHPTRAVELS_FILE));
	 log.info("STEP#3: Selecting checkin date");
		   date.effecteddates("Dates", "Number of days", "CheckIn");
		   page.clickOnElement(ReadLocators.readPropertiesFile("loc.checkin.txt", ProjectBaseConstantPaths.PHPTRAVELS_FILE));
		   String checkindate=page.getdata_fromExcel("RoomBooking", "Enter Data", "Checkin date");
		   page.sendKeys(ReadLocators.readPropertiesFile("loc.checkin.txt", ProjectBaseConstantPaths.PHPTRAVELS_FILE), checkindate);
     log.info("STEP#4: Selecting Checkout date");
		   date.effecteddates("Dates", "Number of days", "CheckOut");
		   page.clickOnElement(ReadLocators.readPropertiesFile("loc.checkout.btn", ProjectBaseConstantPaths.PHPTRAVELS_FILE));
		   String checkoutdate=page.getdata_fromExcel("RoomBooking", "Enter Data", "Checkout date");
		   page.sendKeys(ReadLocators.readPropertiesFile("loc.checkout.btn", ProjectBaseConstantPaths.PHPTRAVELS_FILE), checkoutdate);
	 log.info("STEP#4: Selecting Adults");	
           page.clickOnElement(ReadLocators.readPropertiesFile("loc.adults.btn", ProjectBaseConstantPaths.PHPTRAVELS_FILE));
           page.clickOnElement(ReadLocators.readPropertiesFile("loc.adults.btn", ProjectBaseConstantPaths.PHPTRAVELS_FILE));
     log.info("STEP#4: Selecting Children");	
           page.clickOnElement(ReadLocators.readPropertiesFile("loc.childern.btn", ProjectBaseConstantPaths.PHPTRAVELS_FILE)); 
           page.clickOnElement(ReadLocators.readPropertiesFile("loc.childern.btn", ProjectBaseConstantPaths.PHPTRAVELS_FILE)); 
     log.info("STEP#5: clicking Search");
           page.clickOnElement(ReadLocators.readPropertiesFile("loc.search.btn", ProjectBaseConstantPaths.PHPTRAVELS_FILE));
     log.info("STEP#6: hotelpage validation");
           validate.hotelpageValidation(driver);
     log.info("STEP#7: Clicking on modify");
           page.clickOnElement(ReadLocators.readPropertiesFile("loc.modify.btn", ProjectBaseConstantPaths.PHPTRAVELS_FILE));
           validate.cityValidation(driver);
           validate.checkinDateValidation(driver);
           validate.checkoutDateValidation(driver);
           validate.adultsValidation(driver);
           validate.childrenValidation(driver);
     log.info("STEP#7: Clicking on view more"); 
            page.clickOnElement(ReadLocators.readPropertiesFile("loc.gotit.btn", ProjectBaseConstantPaths.PHPTRAVELS_FILE));
            execute.executeScript("window.scrollBy(0,1500)");
            page.clickOnElement(ReadLocators.readPropertiesFile("loc.viewmore.btn", ProjectBaseConstantPaths.PHPTRAVELS_FILE));	
            execute.executeScript("window.scrollBy(0,1500)");
            page.clickOnElement(ReadLocators.readPropertiesFile("loc.viewmore.btn", ProjectBaseConstantPaths.PHPTRAVELS_FILE));	
            execute.executeScript("window.scrollBy(0,1500)");
            page.clickOnElement(ReadLocators.readPropertiesFile("loc.viewmore.btn", ProjectBaseConstantPaths.PHPTRAVELS_FILE));	
            execute.executeScript("window.scrollBy(0,1500)");
            page.clickOnElement(ReadLocators.readPropertiesFile("loc.viewmore.btn", ProjectBaseConstantPaths.PHPTRAVELS_FILE));	
           select.slelecthotel();
     log.info("STEP#8: Verifying details of hotel");
            validate.hotelnameValidation(driver);
            validate.hoteladdressValidation(driver);
            validate.cityValidation(driver);
            validate.checkinDateValidation(driver);
            validate.checkoutDateValidation(driver);
            validate.adultsValidation(driver);
            validate.childrenValidation(driver);
	}
	
	@AfterClass
	public void teardown() {
		page = new Pageactions(driver);
		log = new LogReport();
		log.info("STEP#9: Quiting Driver");
		driver.quit();
	}

}
