  package WindowHandles;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandlesOperationOnSecondWindow {

	public static void main(String[] args) {
		/*WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.navigate().refresh();
		//driver.findElement(By.xpath("//span[@class='nav-cart-icon nav-sprite']")).click();
		driver.findElement(By.xpath("//a[text()='Mobiles' and @class='nav-a  ']")).click();
		
		String p_window =  driver.getWindowHandle();
		Set<String> allwindows = driver.getWindowHandles();
		for(String windows : allwindows )
		{
			if(!windows.equals(p_window))
			{
				driver.switchTo().window(windows);
				break;
			}
		}
		driver.findElement(By.xpath("//span[@id='productTitle']")).click();*/
		        WebDriver driver = new ChromeDriver();
		        driver.get("https://www.amazon.in");
		        driver.manage().window().maximize();
		        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		        driver.navigate().refresh();

		        driver.findElement(By.xpath("//a[text()='Mobiles' and @class='nav-a  ']")).click();

		        String p_window = driver.getWindowHandle();
		        Set<String> allwindows = driver.getWindowHandles();
		        
		        for(String Window : allwindows) {
		           // if(!Window.equals(p_window)) {
		                driver.switchTo().window(Window);
		                break;
		            //}
		        }

		     // Example: you may want to verify the title or perform other actions here
		        driver.findElement(By.xpath("(//a[text()='Mobiles'])[1]")).click();
		        
		        //driver.quit();  // Always good to close the browser
	}
}
