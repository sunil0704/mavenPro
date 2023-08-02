package javafirst;

import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.*;
import java.io.FileInputStream;
import java.io.IOException;

public class browerLaunch {

	static WebDriver driver = null;

	public void driverset() throws Exception {

		System.setProperty("webdriver.chrome.driver", "D:\\javafirst\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

	}

	@Test
	public void driverset1() throws Exception {

		System.setProperty("webdriver.edge.driver", "D:\\javafirst\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		this.driver = driver;
	}

	@AfterTest
	public void Launch(String str) throws InterruptedException {

		driver.get(str);
		Assert.assertEquals(driver.getTitle(), "Most Reliable App & Cross Browser Testing Platform | BrowserStack");
		System.out.println(driver.getTitle());

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	public void Launch1() {
		driver.findElement(By.xpath(
				"//*[@id=\"post-26\"]/section/div[1]/div/div/div/article[1]/div/div/div/div[2]/div/div[1]/div[2]/div[2]/div/a"))
				.click();
		driver.findElement(By.xpath("//*[@id=\"primary-menu\"]/li[10]/button")).click();
		WebElement ele = driver.findElement(By.name("query"));

		ele.sendKeys("selenium");
		ele.sendKeys(Keys.ENTER);
	
	}
	
 
	public void actionclass() {

		Actions action = new Actions(driver);
		WebElement ele1 = driver.findElement(By.xpath("//*[@id=\"dev-menu-toggle\"]/span"));

		WebElement ele2 = driver.findElement(By.xpath("//*[@id=\"dev-menu-dropdown\"]/li[7]/a"));
		action.moveToElement(ele1).build().perform();

		ele2.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

		driver.findElement(By.xpath("//*[@id=\"customFooterContactBtn\"]/span[2]")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'COMPOSE')]")));

	}

	public void contact() throws InterruptedException {

		driver.findElement(By.name("name")).sendKeys("Raju");

		driver.findElement(By.name("email")).sendKeys("Raju@gmail.com");

		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("window.scrollBy(0,60)");

	}

	public static void takeSnapShot() throws Exception {

		// Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		// Call getScreenshotAs method to create image file
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		// Move image file to new destination
		File DestFile = new File("D:\\javafirst\\Screenshot\\test.png");
		// Copy file at destination
		FileUtils.copyFile(SrcFile, DestFile);
	}

	public void closeBrowser() throws InterruptedException {

		driver.close();
	}

}
