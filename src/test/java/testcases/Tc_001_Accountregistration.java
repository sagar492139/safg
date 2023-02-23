package testcases;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Testbase.Baseclass;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjects.Accountregistrationpage;
import pageobjects.Homepage;

public class Tc_001_Accountregistration extends Baseclass {
	//public WebDriver driver;
	
	@Test
	public void test_account_Registration()
	{
		
		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();
		
		Homepage hp=new Homepage(driver);
		hp.clickMyAccount();
		hp.clickRegister();
		
		Accountregistrationpage regpage=new Accountregistrationpage(driver);
		
		regpage.setFirstName("John");
		regpage.setLastName("Canedy");
		regpage.setEmail(randomestring()+"@gmail.com");
		regpage.setTelephone("65656565");
		regpage.setPassword("abcxyz");
		regpage.setConfirmPassword("abcxyz");
		regpage.setPrivacyPolicy();
		
		regpage.clickContinue();
		
		String confmsg=regpage.getConfirmationMsg();
		
		if(confmsg.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
		
	}
		
	
}
