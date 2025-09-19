package Alerts_popups;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Allow_Block_popupNotifications {

	public static void main(String[] args) {
		//for disabling popup
				ChromeOptions options = new ChromeOptions();
				options.addArguments("disable-notifications");
				WebDriver driver = new ChromeDriver(options);
				driver.manage().window().maximize();
				driver.get("https://www.irctc.co.in/nget/train-search");

	}

}
