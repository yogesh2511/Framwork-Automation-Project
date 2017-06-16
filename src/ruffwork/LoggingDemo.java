package ruffwork;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;




public class LoggingDemo 

{
	static Logger log = Logger.getLogger("devpinoyLogger");

	
	//public static Logger log = LoggerFactory.getLogger("devpinoyLogger");
	 
	public static void main(String[] args) throws IOException 
	{
		String s="testing object";
		log.debug(s);
		System.out.println(s);
	
	}
	
	
  /*  // Recipient's email ID needs to be mentioned.
    String to = "yogeshsolanki@rangam.com";

    // Sender's email ID needs to be mentioned
    String from = "yogeshsolanki@rangam.com";

    final String username = "yogeshsolanki@rangam.com";//change accordingly
    final String password = "june@2017";//change accordingly
    String filename = "C:/Users/yogeshsolanki/workspace/log4j_demo/extentconfig/report.html";
    // Assuming you are sending email through mail.rangam.com
    String host = "mail.rangam.com";
    String port = "25";
    Properties props = new Properties();
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.smtp.host", host);
    props.put("mail.smtp.port", port);

    // Get the Session object.
    Session session = Session.getInstance(props,
       new javax.mail.Authenticator() {
          protected PasswordAuthentication getPasswordAuthentication() {
             return new PasswordAuthentication(username, password);
          }
       });

    try {
       // Create a default MimeMessage object.
       Message message = new MimeMessage(session);

       // Set From: header field of the header.
       message.setFrom(new InternetAddress(from));

       // Set To: header field of the header.
       message.setRecipients(Message.RecipientType.TO,
          InternetAddress.parse(to));

       // Set Subject: header field
       message.setSubject("Testing Subject");

       // Create the message part
       BodyPart messageBodyPart = new MimeBodyPart();

       // Now set the actual message
       messageBodyPart.setText("This is message body");

       // Create a multipar message
       Multipart multipart = new MimeMultipart();

       // Set text message part
       multipart.addBodyPart(messageBodyPart);

       // Part two is attachment
       messageBodyPart = new MimeBodyPart();
      
       DataSource source = new FileDataSource(filename);
       messageBodyPart.setDataHandler(new DataHandler(source));
       messageBodyPart.setFileName("Report.html");
       multipart.addBodyPart(messageBodyPart);

       // Send the complete message parts
       message.setContent(multipart);

       // Send message
       Transport.send(message);

       System.out.println("Sent message successfully....");

    } catch (MessagingException e) {
       throw new RuntimeException(e);
    }*/
	
	
	/*public static void testing()
	{
		extent =new ExtentReports(System.getProperty("user.dir")+"/extentconfig/report.html", true);
		extent.addSystemInfo("HostaName","Yogesh")
		.addSystemInfo("Enviroment", "QA")
		.addSystemInfo("Username", "Yogesh solanki");
		extent.loadConfig(new File(System.getProperty("usr.dir")+"/extentconfig/ReportsConfig.xml"));
		
		tet=extent.startTest("testing");
		
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\yogeshsolanki\\Downloads\\geckodriver-v0.16.1-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.google.com/");
		driver.findElement(By.xpath(".//*[@id='lst-ib']")).sendKeys("automation");
		driver.findElement(By.id("_fZl")).click();
		
		tet.log(LogStatus.PASS, "Test passed");
	}*/
}
