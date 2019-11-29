package net.travelphp.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import net.travelphp.testsuite.TestBase;

public class HotelSelection extends TestBase{
    LogReport log;
    public WebDriver driver;
    String hotelname;
    
    @Test
	public void slelecthotel() {
        log = new LogReport();
		List<WebElement> element = driver.findElements(By.xpath("//p[@class='rating-text text-muted']//span[text()='4 / 5']"));
		log.info(element.size());
		List<WebElement> price = driver.findElements(By.xpath("p.theme-ctas.theme-ctas--tablet-up>a.marketing-button.marketing-button--secondary.theme-preview-link"));
		List<String> prices = new ArrayList<String>();
		for (WebElement e : price) {
		prices.add(e.getText());
		}
		List<String> sortedPrices = new ArrayList<String>(prices);
		Collections.sort(sortedPrices);
		for(int index=0;index<price.size();index++) {
			log.info(sortedPrices.get(index));
			if(hotelname=="Springs Hotel And Spa") {
				driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[68]")).click();
			}
		}
	}
}
