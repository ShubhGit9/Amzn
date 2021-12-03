package testClasses;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Base.Browsers;
import pomPack.AmazonSignin;

public class Test1 extends Browsers{
	WebDriver driver;
	AmazonSignin amazonSignin;
	
	@BeforeTest
	@Parameters("browser")
	public void launchBrowser(String browser) {
		
		if (browser.equals("Chrome")) {
			driver = openChromeBrowser();
		}
		if (browser.equals("Firefox")) {
			driver = openFirefoxBrowser();
		}
	}
	@BeforeClass
	public void launchApp() {
		driver.get("https://www.amazon.in/");
		amazonSignin = new AmazonSignin(driver);
	}
	
//	@BeforeMethod
//	public void initialise() {
//	
//	}
	
	@Test
	public void test1() {
	Assert.assertEquals(amazonSignin.atributeText(),"Hello, Sign in");
		
	}
	
	@Test
	public void test2() {
		amazonSignin.signInClick();
	  String p= driver.getTitle();
	  System.out.println(p);
		Assert.assertEquals(p,"Amazon Sign In");
	}
	
	@Test
	public void test3() throws IOException {
		amazonSignin.enterUser();
		Assert.assertEquals(driver.getTitle(),"Amazon Sign In");
		}
		
	@Test
	public void test4() throws IOException, InterruptedException {
	amazonSignin.enterPass();
	Thread.sleep(3000);
	Assert.assertEquals(driver.getTitle(),"Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
		
		
	}
	


}
