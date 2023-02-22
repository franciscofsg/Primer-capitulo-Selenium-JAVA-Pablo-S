package help;

import org.openqa.selenium.WebDriver;

public class WebDriverManager {

	public static void setWindowSize(WebDriver driver, String size) {

		if (size.toLowerCase() == "maximized") {
			driver.manage().window().maximize();
		}

		if (size.toLowerCase() == "fullscreen") {

			driver.manage().window().fullscreen();

		}

	}

}
