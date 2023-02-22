package pages;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageLogin {

	WebDriver driver;
	By field_username;
	By field_password;
	By btn_submit;
	By fields;

	public PageLogin(WebDriver driver) {
		this.driver = driver;
		field_username = By.name("userName");
		field_password = By.name("password");
		btn_submit = By.name("submit");
		fields = By.tagName("input");
	}

	public void login(String user, String pass) {

		driver.findElement(field_username).sendKeys(user);
		driver.findElement(field_password).sendKeys(pass);
		driver.findElement(btn_submit).click();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	public void fields_login(String user, String pass) {

		List<WebElement> loginFields = driver.findElements(fields);

		loginFields.get(1).sendKeys("user");
		loginFields.get(2).sendKeys("pass");

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

	public void verifyFields(String user, String pass) {

		List<WebElement> loginFields = driver.findElements(fields);

		System.out.println(loginFields.size());

		System.out.println(loginFields.size() == 0);

	}

}
