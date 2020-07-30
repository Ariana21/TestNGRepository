package classwork;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemo {

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
	     
	}
	

	@Test(priority=1, dataProvider="SData")
	public void search(String sstring, String username ) throws Exception {
		
	Thread.sleep(2000);	
	driver.findElement(By.xpath("//input[@id='search_query_top']")).clear();
	Thread.sleep(2000);	
	driver.findElement(By.xpath("//input[@id='search_query_top']")).sendKeys(sstring);
	Thread.sleep(2000);	
	driver.findElement(By.xpath("//button[@name='submit_search']")).click();
	System.out.println(username);
	}
	
	@Test(priority=5)
	public void closeDriver( ) throws Exception {
		
		driver.quit();
		
	}
	
	@DataProvider(name="SData")
	public String[][] provideData(){
		
		String[][] dataset = { {"T-Shirts", "testuser1"},
		         		       {"Shirts", "testuser2"},
		         		       {"Shorts","testuser3"},
		         		       {"Pants","testuser4"}
		                     };
		return dataset;
		}
				
	
}
