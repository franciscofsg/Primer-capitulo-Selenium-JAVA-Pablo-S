package help;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshooter {

	public static void takeScreenshot(String screenName, WebDriver driver) {

		File miScreenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(miScreenShot, new File(screenName + "_" + System.currentTimeMillis() + ".png"));
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
