package br.com.rsinet.hub_tdd.home;



	import java.io.IOException;

	import org.testng.annotations.Test;

	import com.aventstack.extentreports.ExtentReports;
	import com.aventstack.extentreports.ExtentTest;
	import com.aventstack.extentreports.MediaEntityBuilder;
	import com.aventstack.extentreports.Status;
	import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

	public class ExtentReport {

		@Test
		public void loginTest() throws IOException
		{    
	            
		    ExtentHtmlReporter reporter=new ExtentHtmlReporter("./Reports/report_tdd.html");
			
	            
		    ExtentReports extent = new ExtentReports();
		    
	           
		    extent.attachReporter(reporter);
		    
	            
		    ExtentTest logger=extent.createTest("Login");
		    
	            
		    logger.log(Status.INFO, "Login to AdvantageOnlineShopping ");
		   
		    logger.log(Status.PASS, "Title verificado");
		   
	             
		    extent.flush();
			
	            
		    ExtentTest logger2=extent.createTest("Logoff Teste");
		    
		    logger2.log(Status.FAIL, "Title verified");
		    
		    logger2.fail("Failed because of some issues", MediaEntityBuilder.createScreenCaptureFromPath("/Users/rodrigo.vilhena/Desktop/logo.jpg").build());
	        
		    logger2.pass("Failed because of some issues", MediaEntityBuilder.createScreenCaptureFromPath("/Users/rodrigo.vilhena/Desktop/logo.jpg").build());

	            
		    extent.flush();
		    	
		}
		
	}
	

