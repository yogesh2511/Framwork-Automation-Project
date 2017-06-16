package Setup;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import TestNgPkg.ExtentReportDemo;

public class Setup 
{
	  public static WebDriver driver=null;
	  public static ExtentReports  extent=ExtentReportDemo.ExtentDemo();
	  public static ExtentTest test;
	  public static String path;
	  public static String RootDirectory=System.getProperty("user.dir");
	  public static Logger log = Logger.getLogger("devpinoyLogger");
	  public static WebDriverWait wait;
	  public static String driverPath = RootDirectory+ "\\DriverExe\\";
		
			public WebDriver getDriver() 
			{
				return driver;
			}

			private static void setDriver(String browserType, String appURL)
			{	
				switch (browserType) 
				{
				case "chrome":
					driver = initChromeDriver(appURL);
					 test=extent.startTest("Chrome browser");
					break;
				case "firefox":
					driver = initFirefoxDriver(appURL);
					test=extent.startTest("firefox browser");
					break;
				case "html":
					driver = initFirefoxDriver(appURL);
					test=extent.startTest("html browser");
					break;
				default:
					System.out.println("browser : " + browserType
							+ " is invalid, Launching Firefox as browser of choice..");
					driver = initFirefoxDriver(appURL);
				}
			}

			private static WebDriver initChromeDriver(String appURL) 
			{
				System.out.println("Launching google chrome with new profile..");
				System.setProperty("webdriver.chrome.driver", driverPath
						+ "chromedriver.exe");
				WebDriver driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.navigate().to(appURL);
				//test=extent.startTest("Redirected to URL");
				return driver;
			}

			private static WebDriver initFirefoxDriver(String appURL) 
			{
				System.out.println("Launching firefox with new profile..");
				System.setProperty("webdriver.gecko.driver", driverPath+ "geckodriver.exe");
				WebDriver driver = new FirefoxDriver();
				driver.manage().window().maximize();
				driver.navigate().to(appURL);
				//test=extent.startTest("Redirected to URL");
				return driver;
			}
			
			private static WebDriver initHTMLDriver(String appURL) 
			{
				
				WebDriver driver = new HtmlUnitDriver();
				
				driver.navigate().to(appURL);
				//test=extent.startTest("Redirected to URL");
				return driver;
			}
				//new HtmlUnitDriver()
			public static void initializeTestBaseSetup(String browserType, String appURL)
			{
				try {
					setDriver(browserType, appURL);

				} catch (Exception e) {
					System.out.println("BrowserType Error....." + e.getStackTrace());
				}
			}
			
			public static void waitForVisitibilty(WebElement element)
			{
				wait=new WebDriverWait(driver,10);
				wait.until(ExpectedConditions.visibilityOf(element));
			}
			
			public static void click(WebElement element)
			{
				waitForVisitibilty(element);
				element.click();
			}
			public static void sendKeys(WebElement element,String keyword)
			{
				waitForVisitibilty(element);
				element.clear();
				element.sendKeys(keyword);
			}
			public static boolean isPageLoaded(WebElement element)
			{
				waitForVisitibilty(element);
				return element.isDisplayed();
				
			}
			public static boolean isElementPresent(WebElement element)
			{
				waitForVisitibilty(element);
				return element.isDisplayed();
				
			}
			public static String getTest(WebElement element)
			{
				waitForVisitibilty(element);
				return element.getText();
			}
			
			public static String getAttributeVolume(WebElement element, String attribute)
			{
				waitForVisitibilty(element);
				return element.getAttribute(attribute);
			}
			
	  

}
