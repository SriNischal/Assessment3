package net.travelphp.validation;

import org.openqa.selenium.WebDriver;
import net.travelphp.helper.ValidationHelper;
import net.travelphp.testsuite.Pageactions;
import net.travelphp.utils.LogReport;
import net.travelphp.utils.ReadLocators;

public class ValidationResult {
	Pageactions page;
	ReadLocators read;
	ValidationHelper helper;
	LogReport log;
	
	
	public void homepageValidation(WebDriver driver) throws Exception {
		page = new Pageactions(driver);
		String expectedproduct = page.getdata_fromExcel("PhpTravelsValidation", "Validation Text", "Home Page");
		helper = new ValidationHelper(driver);
		helper.performAction(driver, expectedproduct, "validate.homepage.txt");
	}

	public void hotelpageValidation(WebDriver driver) throws Exception {
		String expectedproduct = page.getdata_fromExcel("PhpTravelsValidation", "Validation Text", "hotel page");
		helper.performAction(driver, expectedproduct, "validate.hotelpage.txt");
	}

	public void cityValidation(WebDriver driver) throws Exception {
		String expectedcity = page.getdata_fromExcel("PhpTravelsValidation", "Validation Text", "Verifying city");
		helper.performAction(driver, expectedcity, "validate.city.txt");
	
	}
	
	public void checkinDateValidation(WebDriver driver) throws Exception {
		String expectedate = page.getdata_fromExcel("PhpTravelsValidation", "Validation Text", "Verifying Checkin date");
		helper.performAction(driver, expectedate, "validate.checkindate.txt");
	
	}
	
	public void checkoutDateValidation(WebDriver driver) throws Exception {
		String expectedate = page.getdata_fromExcel("PhpTravelsValidation", "Validation Text", "Verifying Checkout date");
		helper.performAction(driver, expectedate, "validate.checkoutdate.txt");
	
	}
	
	public void adultsValidation(WebDriver driver) throws Exception {
		String expectedate = page.getdata_fromExcel("PhpTravelsValidation", "Validation Text", "Verifying adults");
		helper.performAction(driver, expectedate, "validate.adults.txt");
	}
	
	public void childrenValidation(WebDriver driver) throws Exception {
		String expectedate = page.getdata_fromExcel("PhpTravelsValidation", "Validation Text", "Verifying children");
		helper.performAction(driver, expectedate, "validate.children.txt");
	}

	public void hotelnameValidation(WebDriver driver) throws Exception {
		String expectedproduct = page.getdata_fromExcel("PhpTravelsValidation", "Validation Text", "Verifying hotelname");
		helper.performAction(driver, expectedproduct, "validate.hotelname.txt");
	}
	
	public void hoteladdressValidation(WebDriver driver) throws Exception {
		String expectedproduct = page.getdata_fromExcel("PhpTravelsValidation", "Validation Text", "Verifying hoteladdress");
		helper.performAction(driver, expectedproduct, "validate.hoteladdress.txt");
	}
	
}

//validate.paymrnt.txt
