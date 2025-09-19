package WindowHandles;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClosingSpecificBrowserWindow {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//a[text()='OrangeHRM, Inc']")).click();

		Set<String> Allwindows = driver.getWindowHandles();
	  // driver.findElement(By.xpath("//input[@type='email']")).click();
		
		
		for(String winids: Allwindows) {
			String title =driver.switchTo().window(winids).getTitle();
			System.out.println(title);
			if(title.equals("OrangeHRM") ||title.equals("Human Resources Management Software | OrangeHRM HR Software"))
		 	{
			driver.close();
		 	}
		}	
	}
}
