package pages;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import help.Helpers;

public class PageLogon {

	WebDriver driver;
	By field_username;
	By field_password;
	By btn_submit;
	By xpathlogon;

	public PageLogon(WebDriver driver) {
		this.driver = driver;
		field_username = By.name("userName");
		field_password = By.name("password");
		btn_submit = By.name("submit");
		xpathlogon = By.xpath(
				"/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[3]/form/table/tbody/tr[4]/td/table/tbody/tr[1]/td/font/b");
	}

	public void loginIncorrecto(String user, String pass) {

		driver.findElement(field_username).sendKeys(user);
		driver.findElement(field_password).sendKeys(pass);
		driver.findElement(btn_submit).click();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

	public void asserLogon() {
		
		Assert.assertTrue(driver.findElement(xpathlogon).getText().contains("sign-in here"));

	}

}
