package classwork;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class UsingTestAnnotation {

	@BeforeSuite
	public void befSuite2() {
		System.out.println("I am in before suite of UsingTestAnnotation");
	}
	
	@AfterSuite
	public void afSuite2() {
		System.out.println("I am in after suite of UsingTestAnnotation");
	}
	@Test(priority=1)
	public void launch(){
		
		System.out.println("I am in launch");
		
	}
	
	@Test(priority=2, enabled=true)
	public void homePage(){
		
		System.out.println("I am in homePage");
		Assert.fail();
	}
	
	
	@Test(priority=5, dependsOnMethods = {"launch","homePage"}, alwaysRun=true)
  public void login(){
		
		System.out.println("I am in login");
		
	}
	
	@Test(priority=10, invocationCount=5, invocationTimeOut=5000)
  public void search() throws Exception{
		
		System.out.println("I am in search");
		Thread.sleep(3000);
	}
	
	@Test(priority=15, timeOut=5000, description="flight details test")
	  public void flightdetails() throws Exception{
			
			System.out.println("I am in flightdetails");
			Thread.sleep(10000);
			System.out.println("After sleep");
		}

}
