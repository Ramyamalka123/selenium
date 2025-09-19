package CheckBoxes;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingCheckBoxes {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		// 1.Select specific checkbox
		//driver.findElement(By.xpath("//input[@id='sunday']")).click();
		
		// 2.select all the checkboxes
		List<WebElement> checkboxes =driver.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));
		
		/*for(int i=0; i<checkboxes.size(); i++) {
			checkboxes.get(i).click();
			
		}						
		//enhanced forloop
		for(WebElement Checkbox:checkboxes) {
			Checkbox.click();
		}
		
		//3.Select last 3 checkboxes
		for (int i=4; i <checkboxes.size();i++) {
			checkboxes.get(i).click();
		}
		//select first 3 checkboxes
		for(int i=0; i <3;i++) {
			checkboxes.get(i).click();
		}*/
		
		//unselect the checkboxes if they are selected first
		for(int i=0; i <3; i++) {
			checkboxes.get(i).click();
		}
		Thread.sleep(3000);
		for(int i=0;i<checkboxes.size();i++) 
		{
			if(checkboxes.get(i).isSelected())
			{
				checkboxes.get(i).click();
			}
		}
		}

}
