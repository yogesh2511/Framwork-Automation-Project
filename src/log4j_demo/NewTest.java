package log4j_demo;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import Setup.Setup;
import TestNgPkg.Config;
import TestNgPkg.ExcelUtils;

public class NewTest extends Setup {

	@BeforeMethod
	public static void setup() {
		try {
			//ExcelUtils.setExcelFile(Config.Path_TestData + Config.File_TestData, "BasicConfig");
			initializeTestBaseSetup(Config.Browser, Config.URL);
			test.log(LogStatus.INFO, "Url Open");
			log.debug("WebLink url is open");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	@Test
	public static void AllTest() 
	{
		try {
			
			//Thread.sleep(3000);
		    LoginPage login1=new LoginPage(driver);
			LoginPage.login("yogeshsolanki@rangam.com", "rangam@123");
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		
	}
	
	@Test
	public static void HomepageTest() 
	{
		try {
			
			//Thread.sleep(3000);
			HomePage Homepage=new HomePage(driver);
			//Homepage.("yogeshsolanki@rangam.com", "rangam@123");
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		
	}

	@AfterMethod
	public static void getResult() {
		System.out.println("last");
		driver.close();
		// driver.quit();
	}

}
