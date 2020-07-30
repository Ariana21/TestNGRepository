package classwork;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;

public class GroupsDemo {
 
	public WebDriver driver;
	public String browser = "FF";
	public String url = "http://automationpractice.com/index.php";

	@BeforeClass(groups= {"search", "cart"})
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
	
	@Test(priority=1, groups= {"search", "cart"})
	public void home() throws Exception {
		
		System.out.println(driver.findElement(By.xpath("//input[@id='search_query_top']")).isDisplayed());
		Thread.sleep(2000);
		
	}
	
	@Test(priority=1, groups= {"search"})
	public void search() throws Exception {
		
		driver.findElement(By.xpath("//input[@id='search_query_top']")).sendKeys("T-shirts");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@name='submit_search']")).click();
		Thread.sleep(2000);
	}
	
	@Test(priority=5, groups= {"cart"})
   public void clickCart() throws Exception {
	    driver.findElement(By.xpath("//a[@title='View my shopping cart']")).click();
	 
    }
   
	@Test(priority=10, groups= {"search", "cart"})
   public void quit() {
   
        driver.quit();
   }
}
