package net.travelphp.helper;

import java.text.SimpleDateFormat;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import org.openqa.selenium.WebDriver;

import net.travelphp.testsuite.Pageactions;
import net.travelphp.utils.LogReport;

public class BookingDateHelper {
	public WebDriver driver;
	Pageactions page;
    LogReport log;
    SimpleDateFormat simpleformat;
	public void effecteddates(String sheetname,String columnname,String rowname) throws Exception {
		log=new LogReport();
		page = new Pageactions(driver);
		DateTimeFormatter dateformat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		LocalDateTime present = LocalDateTime.now();
		String userDate = (dateformat.format(present));
		simpleformat = new SimpleDateFormat("MM/dd/yyyy");
		Calendar getDate = Calendar.getInstance();
		String newdate = page.getdata_fromExcel(sheetname,columnname,rowname);
		log.info(userDate);
		int date = Integer.parseInt(newdate);
		log.info(date);
		getDate.add(Calendar.DATE, date);
		String daysdate = simpleformat.format(getDate.getTime());
		log.info(daysdate);    
	}
	}
