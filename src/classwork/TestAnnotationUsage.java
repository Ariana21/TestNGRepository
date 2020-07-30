package classwork;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestAnnotationUsage {

	public WebDriver driver;
	public String browser = "FF";
	public String url = "http://newtours.demoaut.com";
	
	@BeforeClass
	public void launch() throws Exception {
		  System.setProperty("webdriver.chrome.driver", "C:\\Users\\bhawn\\Desktop\\Testing\\Selenium\\Srinivas\\Softwares\\driverexes\\chromedriver.exe");
	      System.setProperty("webdriver.gecko.driver", "C:\\Users\\bhawn\\Desktop\\Testing\\Selenium\\Srinivas\\Softwares\\driverexes\\geckodriver.exe");
	       
	      if(browser.equalsIgnoreCase("FF")) {
	      
	    	    driver = new FirefoxDriver();
	      } else {
	            
	            driver = new ChromeDriver();
	      }
	      
	      driver.manage().window().maximize();
	      Thread.sleep(2000);
	      
	      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	      driver.manage().timeouts().pageLoadTimeout(2, TimeUnit.MINUTES);
	      driver.get(url);
	      Thread.sleep(2000);
	     
	}
	
	@Test(priority=1)
	public void login( ) throws Exception {
		
	
		
		WebElement userInput = driver.findElement(By.name("userName"));
		WebElement pwdInput = driver.findElement(By.name("password"));
		WebElement signInImage = driver.findElement(By.name("login"));
		
		userInput.click();
		Thread.sleep(2000);
		userInput.sendKeys("mercury");
		Thread.sleep(2000);
		
		
	//	driver.findElement(By.name("username")).click();
		//Thread.sleep(2000);
		//driver.findElement(By.name("userName")).sendKeys("mercury");
		//Thread.sleep(2000);
		
		//pwdInput.click();
		//Thread.sleep(2000);
		pwdInput.sendKeys("mercury");
		Thread.sleep(2000);
		
		signInImage.click();
		
	}
	
	@Test(priority=5)
	public void flightDetailsPage( ) throws Exception {
	
	}
	
	@AfterClass
	public void closeBrowser( ) throws Exception {
		
		driver.quit();
		
	}
	
}
