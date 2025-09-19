package WindowHandles;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandles {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click(); //xpath of link
		Set<String> windowIDS = driver.getWindowHandles();
		
		for(String winids :windowIDS ) {
		String	 title = driver.switchTo().window(winids).getTitle();
		System.out.println(title);
		{
			if(title.equals("OrangeHRM")) //|| title.equals("Human Resources Management Software | OrangeHRM HR Software "));
			{
				//driver.close();
				System.out.println(driver.getCurrentUrl());
			}
		}
		}

	}

}
