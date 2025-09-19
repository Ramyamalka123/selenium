package FileUploading;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class FileUpLoading {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File Des = new File("C:\\Users\\Malka Ramya\\OneDrive\\Desktop\\textscreenshot\\abc.png3");
		FileHandler.copy(src, Des);
		WebElement location= driver.findElement(By.xpath("//input[@id='singleFileInput']"));
		
		location.sendKeys("C:\\Users\\Malka Ramya\\OneDrive\\Desktop\\textscreenshot\\abc.png3");
		//multiplefiles
		//WebElement multiple = driver.findElement(By.xpath("//input[@id='multipleFilesInput']"));
		String file1="C:\\Users\\Malka Ramya\\OneDrive\\Desktop\\textscreenshot\\abc.png3";
		String file2="C:\\Users\\Malka Ramya\\OneDrive\\Pictures\\family pic\\IMG_20190325_112151.jpg";
		WebElement multiple = driver.findElement(By.xpath("//input[@id='multipleFilesInput']"));
		multiple.sendKeys(file1 + "\n"+ file2 );
	}

}
