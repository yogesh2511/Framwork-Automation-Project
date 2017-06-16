package TestNgPkg;

import java.io.File;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentReportDemo 
{
	 public static ExtentReports extent =null;
	 
	 public static ExtentReports ExtentDemo()
	{
		// HTMLReporter.config().setAutoCreateRelativePathMedia(true);
		 try{
		 extent =new ExtentReports(System.getProperty("user.dir")+"/extentconfig/report.html", true);
			extent.addSystemInfo("HostaName","Yogesh")
			.addSystemInfo("Enviroment", "QA")
			.addSystemInfo("Username", "Yogesh solanki");
			extent.loadConfig(new File(System.getProperty("usr.dir")+"/extentconfig/ReportsConfig.xml"));
			
		 }
		 catch(Exception ex)
		 {
			 System.out.println(ex.getMessage());
		 }
		 return extent;
	}
}
