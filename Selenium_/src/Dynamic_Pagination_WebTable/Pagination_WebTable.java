package Dynamic_Pagination_WebTable;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Pagination_WebTable {

	public static void main(String[] args) {
		// WebDriver driver = new ChromeDriver();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-notifications");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		// driver.get("https://www.techlistic.com/2017/02/automate-demo-web-table-with-selenium.html");
		driver.get("https://www.ecomdeveloper.com/demo/admin/index.php");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("demoadmin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("demopass");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		// driver.findElement(By.xpath("//a[@class='parentcollapsed'][normalize-space()='Customers']")).click();

		/*
		 * //customers
		 * driver.findElement(By.xpath("//li[@id='menu-customer']")).click();
		 * driver.findElement(By.xpath("//a[text()='Customers']")).click();
		 */
		// catageries
		driver.findElement(By.xpath("//li[@id='menu-catalog']")).click();
		driver.findElement(By.xpath("(//a[text()='Categories'])[1]")).click();

		// showing pages
		//String text = driver.findElement(By.xpath("//div[contains(text(),'Pages')]")).getText();////div[@class='col-sm-6 text-right']
		String text = driver.findElement(By.xpath("//div[@class='col-sm-6 text-right']")).getText();
		System.out.println(text);
		int totalpages = Integer.parseInt(text.substring(text.indexOf("(") + 1, text.indexOf("Pages") - 1));

		// repeating pages
		for (int p = 1; p <= totalpages; p++) {
			if (p > 1) 
			{
				WebElement activepage = driver.findElement(By.xpath("//ul[@class='pagination']//a[text()=" + p + "]"));
				activepage.click();
			}
		}

		// reading data from the page
		int noOfRows = driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr")).size();

		for (int r = 5; r <= noOfRows; r++) {
			String catogory = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr[" + r + "]/td[2]")).getText();
			String sortOrder = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr[" + r + "]/td[3]")).getText();

			System.out.println(catogory + " " + sortOrder);
		}

	}

}
