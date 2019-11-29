package net.travelphp.utils;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.Test;

import net.travelphp.helper.BookingDateHelper;
import net.travelphp.testsuite.Pageactions;

public class BookingDate {
	public WebDriver driver;
	LogReport log;
	Pageactions page = new Pageactions(driver);
	BookingDateHelper date;

	@Test
	public void updatedates() throws Exception {
		log = new LogReport();
		date = new BookingDateHelper();
		
		date.effecteddates("Calendar", "Number of days", "Subtract month");

		date.effecteddates("Calendar", "Number of days", "Add month");
		
		date.effecteddates("Calendar", "Number of days", "days to add");

	}

}
