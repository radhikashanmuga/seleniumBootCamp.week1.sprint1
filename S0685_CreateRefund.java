package sprint1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S0685_CreateRefund 
{
	public static void main(String[] args) throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup();
		
		//Handle Notifications
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		//Login to https://login.salesforce.com- mars@testleaf.com, BootcampSel$123
		ChromeDriver driver=new ChromeDriver(options);
		driver.get("https://login.salesforce.com");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("mars@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("BootcampSel$123");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//p[text()='Service Console']")).click();
		driver.findElement(By.xpath("(//button[@type='button']//following::lightning-primitive-icon)[8]")).click();
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "js");
	}
}
