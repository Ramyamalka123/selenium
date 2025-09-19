package Alerts_popups;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class NotificationPopUps {

	public static void main(String[] args) {
		/*//for disabling popup
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-notifications"); 
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.irctc.co.in/nget/train-search");*/

		//for allow and block notification(click on lock symbol in url )
		ChromeOptions options = new ChromeOptions();
		HashMap<String,Integer> mymap = new HashMap<String, Integer>();
		HashMap<String,Object> profile = new HashMap<String,Object>();
		HashMap<String,Object> pref = new HashMap<String,Object>();
		
		
		mymap.put("notifications", 1); //(0=default,1=allow,2=block) //notifications , geolocations
		mymap.put("media_stream", 2);
		mymap.put("geolocation", 1);
		//mymap.put("camera", 0);
	    profile.put("managed_default_content_settings", mymap);
		pref.put("profile", profile);
		options.setExperimentalOption("prefs", pref);
		
		//options.addArguments("disable-notifications");
		//options.addArguments("disable-media_stream");
		//options.addArguments("disable-geolocation");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.irctc.co.in/nget/train-search");

	}

}
