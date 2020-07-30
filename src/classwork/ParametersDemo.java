package classwork;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametersDemo {

	public WebDriver driver;
	public String browser = "FF";
//	public String url = "http://newtours.demoaut.com";
	
	@Parameters("site_url")
	@Test(priority=0)
	public void launch(String url) throws Exception {
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
	
	@Parameters({"search_string"})
	@Test(priority=1)
	public void search(String sstring ) throws Exception {
		
	Thread.sleep(2000);	
	driver.findElement(By.xpath("//input[@id='search_query_top']")).sendKeys(sstring);
	Thread.sleep(2000);	
	driver.findElement(By.xpath("//button[@name='submit_search']")).click();
	}
	
	@Test(priority=5)
	public void closeDriver( ) throws Exception {
		
		driver.quit();
		
	}
}
