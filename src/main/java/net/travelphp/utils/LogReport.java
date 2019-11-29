package net.travelphp.utils;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;

/**
 * Configure the log4j file path.
 */
public class LogReport {

	Logger logger = null;

	public LogReport() {
		getlogger();
		logger = Logger.getLogger(LogReport.class.getName());
	}

	public void getlogger() {
		PropertyConfigurator
				.configure("C:\\Users\\srinischal.thiparani\\AssessmentTwo\\travelsphp\\src\\test\\resources\\log4j.properties");
	}

	public void info(String message) {
		logger.info(message);
		//ThreadPool.getExtentTest().log(LogStatus.INFO, message);
	}

	public void info(int date) {
		logger.info(date);
		
	}
	public void info(List<WebElement> element) {
		logger.info(element);
	}

}
