package utility;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import base.TestBase;

public class ExtentReportManager extends TestBase
{
	public static ExtentReports report;
	public static ExtentReports getReportInstance()
	{
		if (report==null)
		{
			@SuppressWarnings("unused")
			String reportName = new SimpleDateFormat("dd-MM-YYYY ss-mm-HH").format(new Date());
			ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("C:\\Users\\ADMIN\\eclipse-workspace\\workspace1\\Selenium_Project\\ExtentReport\\Report.html");
			report = new ExtentReports();
			report.attachReporter(htmlReporter);
			report.setSystemInfo("OS", "Window");
			report.setSystemInfo("Enviroment", "SIT");
			report.setSystemInfo("Build Number", "102.02.02.126");
			report.setSystemInfo("Browser", "chrome");
			htmlReporter.config().setDocumentTitle("UI Testing Documents");
			htmlReporter.config().setReportName("UI Test Report");
		}
		return report;
		
	}
	
}
