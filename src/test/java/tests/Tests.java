package tests;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import help.Helpers;
import help.Screenshooter;
import help.WebDriverManager;
import pages.PageLogin;
import pages.PageLogon;
import pages.PageReservation;

public class Tests {

	// Creamos un objeto de tipo WebDriver
	private WebDriver driver;

	@BeforeMethod
	public void setUp() {

		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");

		// Declaramos el objeto driver de tipo Chromedriver
		driver = new ChromeDriver();
		//driver.manage().window().maximize();

		driver.get("https://demo.guru99.com/test/newtours");

//		Helpers helper = new Helpers();
//		helper.sleep(4);

		// Ejecutar codigo javascript
		JavascriptExecutor javascriptexecutor = (JavascriptExecutor) driver;
		String Googlewindows = "window.open('https://www.google.com')";
		javascriptexecutor.executeScript(Googlewindows);

	}

	@Test
	public void pruebaUno() {
		
		WebDriverManager.setWindowSize(driver, "fullscreen");

		PageLogin pagelogin = new PageLogin(driver);
		pagelogin.login("user", "user");

		PageReservation pagereservation = new PageReservation(driver);
		pagereservation.asserPage();

		driver.findElement(By.linkText("Flights")).click();

	}

//	@Test
//	public void pruedos() {
//
//		PageLogon pagelogon = new PageLogon(driver);
//		pagelogon.loginIncorrecto("34", "34");
//		pagelogon.asserLogon();
//
//		Helpers helper = new Helpers();
//		helper.sleep(4);
//
//	}
//
//	@Test
//	public void pruebaTres() {
//
//		PageLogin pagelogin = new PageLogin(driver);
//		pagelogin.login("user", "user");
//
//		PageReservation pagereservation = new PageReservation(driver);
//
//		driver.findElement(By.linkText("Flights")).click();
//
//		Helpers helper = new Helpers();
//		helper.sleep(20);
//
//		pagereservation.selectPassengers(2);
//
//		pagereservation.selectdepartingfrom(4);
//
//		pagereservation.selecttoport("San Francisco");
//
//		helper.sleep(6);
//
//	}
//
//	@Test
//	public void pruebaCantidadDeCampos() {
//
//		PageLogin pagelogin = new PageLogin(driver);
//		pagelogin.verifyFields("user", "user");
//
//	}

	@AfterMethod
	public void tearDown(ITestResult result) {

		if (!result.isSuccess()) {

			Screenshooter.takeScreenshot("Error", driver);

		}

		driver.quit();

	}
}