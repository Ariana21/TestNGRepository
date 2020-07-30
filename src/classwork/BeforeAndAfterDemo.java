package classwork;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BeforeAndAfterDemo {
    
	@BeforeSuite
	public void befSuite() {
		
		System.out.println("I am in before suite");
	}
	
	@AfterSuite
	public void afSuite() {
		
		System.out.println("I am in after suite");
	}
	
	@BeforeTest
	public void befTest() {
		
		System.out.println("I am in before Test");
	}
	
	@AfterTest
	public void afTest() {
		
		System.out.println("I am in after Test");
	}
	
	@BeforeClass
	public void befClass() {
		
         System.out.println("I am in before class");
	}
	
	@AfterClass
	public void afClass() {
		
		System.out.println("I am in after class");
	}
	@BeforeMethod
	public void launch() {
		
		System.out.println("In Before method");
	}
	
	@AfterMethod
	public void logout() {
		
		System.out.println("In After method");
	}
	
	@Test(priority=1)
	public void homepage() {
		
		System.out.println("In Home page");
		
	}
	@Test(priority=5)
	public void login() {
		
		System.out.println("In login");
	}
	
	
	
	
	
}
