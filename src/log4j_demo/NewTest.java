package log4j_demo;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Setup.Setup;
import TestNgPkg.Config;
import TestNgPkg.ExcelUtils;

public class NewTest extends Setup {

	@BeforeMethod
	public static void setup() {
		try {
			ExcelUtils.setExcelFile(Config.Path_TestData + Config.File_TestData, "BasicConfig");
			initializeTestBaseSetup(Config.Browser, Config.URL);
			test.log(LogStatus.INFO, "Url Open");
			log.debug("WebLink url is open");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	@Test
	public static void Logintest() {
		driver.findElement(By.xpath(".//*[@id='log']")).sendKeys(Config.LoginUsername);
		log.debug("username is entered");
		test.log(LogStatus.INFO, "Email entered");
		driver.findElement(By.xpath(".//*[@id='pwd']")).sendKeys(Config.LoginPassword);
		log.debug("Password entered");
		test.log(LogStatus.INFO, "Password entered");
		driver.findElement(By.xpath(".//*[@id='login']")).click();
		log.debug("Loginbtn clicked");
		test.log(LogStatus.INFO, "Loginbtn clicked");
		test.log(LogStatus.PASS, "Test passed");
	}

	@AfterMethod
	public static void getResult() {
		System.out.println("last");
		driver.close();
		// driver.quit();
	}

}
