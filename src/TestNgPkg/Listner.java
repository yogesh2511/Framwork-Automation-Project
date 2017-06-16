package TestNgPkg;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.LogStatus;

import Setup.Setup;

public class Listner extends Setup implements ITestListener
{

	@Override
	public void onTestStart(ITestResult result)
	{
		
		
	}

	@Override
	public void onTestSuccess(ITestResult result)
	{
		try{
		  System.out.println("passed method:"+result.getName());
		  ErrorScreenShot.captureScreenshot();		
		  
		}catch(Exception e)
		{
			  test.log(LogStatus.PASS,result.getThrowable() );
			  test.log(LogStatus.PASS, "passed method screenshot below"+test.addScreenCapture(path));
			System.out.println(e.getMessage());
		}
		 extent.endTest(test);
		  extent.flush();
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
		try{
		  System.out.println("failed method:"+result.getName());
		
		  //test.log(LogStatus.FAIL,result.getThrowable() );
		
		  ErrorScreenShot.captureScreenshot();
		
		  test.log(LogStatus.FAIL, "failed method screenshot below"+test.addScreenCapture(path));
		 
		  extent.endTest(test);
		  extent.flush();
		}
		catch(Exception e)
		{
			 test.log(LogStatus.WARNING,result.getThrowable() );
			  test.log(LogStatus.WARNING, "passed method screenshot below"+test.addScreenCapture(path));
			System.out.println(e.getMessage());
			
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) 
	{
		try{
		 System.out.println("skipped method:"+result.getName());
		  test.log(LogStatus.SKIP,result.getThrowable() );
		  ErrorScreenShot.captureScreenshot();
		  test.log(LogStatus.SKIP, "skipped method screenshot below"+test.addScreenCapture(path));
		  extent.endTest(test);
		  extent.flush();
		  }
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result)
	{
		
		
	}

	@Override
	public void onStart(ITestContext context)
	{
		
		
	}

	@Override
	public void onFinish(ITestContext context)
	{	try{
		 // extent.flush();
		 MailMonitor.sendmail(Config.server,
				  Config.port,
				  Config.from,
				  Config.Emailpassword,
				  Config.to,
				  Config.Emailusername,
				  Config.subject,
				  Config.messageBody,
				  Config.attachmentPath,
				  Config.attachmentName);
	}catch(Exception e)
	{
		System.out.println(e.getMessage());
	}
	}

}
