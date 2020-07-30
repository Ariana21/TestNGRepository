package classwork;

import static org.testng.Assert.*;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertsDemo {

	public WebDriver driver;
	public String browser = "FF";
	public String url = "http://automationpractice.com/index.php";
	

	@Test(priority=0)
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
	     
	      String actUrl = driver.getCurrentUrl();
	      System.out.println(actUrl);
	     
	      boolean retVal = actUrl.contains("automationpractice.com");
	      
	      Assert.assertTrue(retVal, "URL Validation failed");
	      System.out.println("after assert");
	}
	

	@Test(priority=1)
	public void search() throws Exception {
		
	Thread.sleep(2000);	
	driver.findElement(By.xpath("//input[@id='search_query_top']")).sendKeys("T-Shirts");
	Thread.sleep(2000);	
	driver.findElement(By.xpath("//button[@name='submit_search']")).click();
	Thread.sleep(5000);	
	String actVal = driver.findElement(By.xpath("//input[@id='search_query_top']")).getAttribute("value");
	String expVal ="TShirts";
	boolean cond = actVal.equalsIgnoreCase(expVal);
	assertTrue(cond, "Search validation failed.");
//  Assert.assertEquals(actVal, expVal,"Search validation failed.");
	
//	SoftAssert sobj = new SoftAssert();
//	sobj.assertTrue(cond, "Search validation failed.");
//	System.out.println("I am after soft assert");
//  sobj.assertAll();
	}
	
	@Test(priority=5)
	public void closeDriver( ) throws Exception {
		
		driver.quit();
		
	}
	
}
