package TestNgPkg;

import Setup.Setup;

public class Config extends Setup
{
	//#############################################################################################################
		//Excell constant data
	 public static final String URL = "http://store.demoqa.com/products-page/your-account/";
	 public static final String Browser = "firefox";
     public static final String LoginUsername = "testuser_1";
     public static final String LoginPassword = "Test@123";
     public static final String Path_TestData = RootDirectory + "//TestData//";
     public static final String File_TestData = "TestData.xlsx";
	//##############################################################################################################
	//Email constant data 
	public static final String server="mail.rangam.com";
	public static final  String port="25";
	public static final String from = "yogeshsolanki@rangam.com";
	public static final  String Emailpassword = "june@2017";
	public static final String to ="yogeshsolanki@rangam.com";
	public static final String Emailusername="yogeshsolanki@rangam.com";
//	public static String[] bcc = {"yogeshsolanki@rangam.com"};
	public static final String subject = "Automation Report";	
	public static final  String messageBody ="Please Find Attachment For the Report";
	public static final  String attachmentPath=System.getProperty("user.dir")+"\\extentconfig\\report.html";
	public static final String attachmentName="report.html";
	//#############################################################################################################
	
	

}
