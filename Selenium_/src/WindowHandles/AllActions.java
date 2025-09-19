package WindowHandles;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class AllActions {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);

		// dropdown

		driver.findElement(By.xpath("//input[@id='comboBox']")).click();
		driver.findElement(By.xpath("//div[text()='Item 10']")).click();

		// RadioButton
		WebElement male_rd = driver.findElement(By.xpath("//input[@id='male']"));
		WebElement female_rd = driver.findElement(By.xpath("//input[@id='female']"));

		female_rd.click();
		System.out.println(female_rd.isSelected());

		// checkbox
		driver.findElement(By.xpath("//input[@id='sunday']")).click();// to uncheck
		driver.findElement(By.xpath("//input[@id='thursday']")).click();// to uncheck
		List<WebElement> checkboxes = driver
				.findElements(By.xpath("//input[@class='form-check-input' and  @type='checkbox']"));
		System.out.println("no of days" + checkboxes.size());
		for (int i = 0; i < checkboxes.size(); i++) {
			checkboxes.get(i).click();
		}

		// mouse Operations
		Actions actobj = new Actions(driver);
		WebElement src = driver.findElement(By.xpath("//button[text()='Point Me']"));
		actobj.moveToElement(src).click().perform();

		// doubleclick
		WebElement dclick = driver.findElement(By.xpath("//button[text()='Copy Text']"));
		actobj.doubleClick(dclick).click().perform();

		// drag and drop
		WebElement drag = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement drop = driver.findElement(By.xpath("//div[@id='droppable']"));
		actobj.dragAndDrop(drag, drop).perform();

		// handlingalerts

		// simplealert
		driver.findElement(By.cssSelector("button[id='alertBtn']")).click();
		driver.switchTo().alert().accept();

		// confirmationalert
		driver.findElement(By.xpath("//button[text()='Confirmation Alert']")).click();
		driver.switchTo().alert().dismiss();

		// promptalert
		driver.findElement(By.xpath("//button[text()='Prompt Alert']")).click();
		String text = driver.switchTo().alert().getText();
		System.out.println(text);
		driver.switchTo().alert().accept();

		// Click button to open new tab
		driver.findElement(By.xpath("//button[text()='New Tab']")).click();

		// Store current window handle
		String p_window = driver.getWindowHandle();
	   

		// Get all window handles
		Set<String> all_windows = driver.getWindowHandles();

		// Switch to new window
		for (String windowHandle : all_windows) {
			if (!windowHandle.equals(p_window)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}

		// Now perform the click in the new tab
		driver.findElement(By.xpath("//a[text()='Manual Testing Tutorials']")).click();

		// Switch back to the parent/original window if needed
		driver.switchTo().window(p_window);

		// dropdown
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select_multiple");
		Thread.sleep(2000);
		driver.manage().window().maximize();

		driver.switchTo().frame("iframeResult");
		WebElement we = driver.findElement(By.name("cars"));
		Select slcobj = new Select(we);
		if (slcobj.isMultiple()) {

			slcobj.selectByVisibleText("Volvo");
			Thread.sleep(2000);
			slcobj.selectByValue("audi");
			Thread.sleep(2000);
			List<WebElement> alloptions = slcobj.getAllSelectedOptions();
			for (int i = 0; i < alloptions.size(); i++) {
				String options = alloptions.get(i).getText();
				System.out.println("The selected options is:" + options);
			}
			slcobj.deselectByVisibleText("Volvo");
			Thread.sleep(2000);
			slcobj.deselectAll();
			driver.switchTo().defaultContent();
		}
     //rightclick
		driver.get("https://www.amazon.in/");
		driver.navigate().refresh();
		Thread.sleep(2000);
		driver.manage().window().maximize();

		WebElement right = driver.findElement(By.xpath("//a[text()='Customer Service']"));
		Thread.sleep(2000);
		actobj.contextClick(right).perform();
	}
}
