package net.travelphp.testsuite;

import java.io.IOException;




import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;

import net.travelphp.utils.LogReport;
import net.travelphp.utils.ProjectBaseConstantPaths;
import net.travelphp.utils.ReadLocators;

public class TestBase{
	LogReport log;
	public WebDriver driver;
	String browsername;
	@BeforeTest
	public void invokeBrowser() throws IOException {
		browsername = ReadLocators.readPropertiesFile("Browser", ProjectBaseConstantPaths.CONFIG_FILE);
		if (browsername.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", ProjectBaseConstantPaths.CHROME_FILE);
			driver = new ChromeDriver();
			log = new LogReport();
			log.info("Chrome browser started...");

		} else if (browsername.equalsIgnoreCase("ie")) {
			log=new LogReport();
			System.setProperty("webdriver.ie.driver", ProjectBaseConstantPaths.IE_FILE);
			DesiredCapabilities ieCaps = DesiredCapabilities.internetExplorer();
			ieCaps.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, "");
			driver = new InternetExplorerDriver(ieCaps);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			log.info("IE browser started...");
		}
	}
}