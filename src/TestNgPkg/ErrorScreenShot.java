package TestNgPkg;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import Setup.Setup;

public class ErrorScreenShot extends Setup {
	// static WebDriver driver;
	// public static String path=null;
	public static String captureScreenshot()

	{

		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			Date d = new Date();
			String screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";
			//System.out.println("screenshotName:" + screenshotName);
			path = System.getProperty("user.dir") + "\\ErrorScreenshot\\" + screenshotName;
			File screenshotPath = new File(System.getProperty("user.dir") + "\\ErrorScreenshot\\" + screenshotName);
			FileUtils.copyFile(scrFile, screenshotPath);
			System.out.println("Error capture successfully");
		} catch (Exception e) {

			System.out.println("captureScreenshot method fail");
		}
		return path;
	}
}
