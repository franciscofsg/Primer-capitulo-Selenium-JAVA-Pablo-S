package tests;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tests {

	// Creamos un objeto de tipo WebDriver
	private WebDriver driver;

	@Before
	public void setUp() {

		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");

		// Declaramos el objeto driver de tipo Chromedriver
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://demo.guru99.com/test/newtours");

		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void pruebaUno() throws InterruptedException {

		driver.findElement(By.name("userName")).sendKeys("user");
		driver.findElement(By.name("password")).sendKeys("user");
		driver.findElement(By.name("submit")).click();

		driver.findElement(By.linkText("Flights")).click();
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Assert.assertTrue(driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[1]/font/b")).getText().contains("Thank
		// you for Loggin."));

	}

	@Test
	public void pruedos() throws InterruptedException {

		driver.findElement(By.name("userName")).sendKeys("perro");
		driver.findElement(By.name("password")).sendKeys("perro");
		driver.findElement(By.name("submit")).click();

		driver.findElement(By.linkText("Flights")).click();
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Assert.assertTrue(driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[1]/font/b")).getText().contains("Thank
		// you for Loggin."));

	}

	@After
	public void tearDown() {

		driver.quit();

	}
}