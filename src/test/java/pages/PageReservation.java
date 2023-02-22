package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class PageReservation {

	By passengers;
	WebDriver driver;
	By xpathassertlogin;
	By departingfrom;
	By toport;

	public PageReservation(WebDriver driver) {
		this.driver = driver;
		xpathassertlogin = By.xpath(
				"/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[1]/font/b");
		passengers = By.name("passCount");
		departingfrom = By.name("fromPort");
		toport = By.name("toPort");

	}

	public void asserPage() {

		Assert.assertTrue(driver.findElement(xpathassertlogin).getText().contains("Thank you for Loggin."));

	}

	public void selectPassengers(int cantidad) {

		Select selectpas = new Select(driver.findElement(passengers));
		selectpas.selectByVisibleText(Integer.toString(cantidad));

	}

	public void selectdepartingfrom(int index) {

		Select selecdepart = new Select(driver.findElement(departingfrom));
		selecdepart.selectByIndex(index);

	}

	public void selecttoport(String port) {

		Select selectoport = new Select(driver.findElement(toport));
		selectoport.selectByValue(port);

	}

}
