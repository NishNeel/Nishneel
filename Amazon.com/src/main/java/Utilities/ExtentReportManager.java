package Utilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener {

	public ExtentSparkReporter sparkReport; // UI of the Report.
	public ExtentReports commonExtent; //common functionalities like details of project
	public ExtentTest test; //Test cases execution and status update
	
	public String reportName;
	public void onStart(ITestContext context) {
		
		String timeStamp = new SimpleDateFormat("YYYY.MM.DD.HH.MM.SS").format(new Date());
		reportName = "ExtentReport-"+timeStamp+".html";
		sparkReport = new ExtentSparkReporter(".\\Reports\\"+ reportName);
		
		sparkReport.config().setDocumentTitle("Project Name");
		sparkReport.config().setReportName("Name of the report");
		sparkReport.config().setTheme(Theme.DARK);
		
		commonExtent = new ExtentReports();
		commonExtent.attachReporter(sparkReport);
		
		commonExtent.setSystemInfo("Environment", "QA");
		commonExtent.setSystemInfo("Tester Name", "Nishanth");
		
		String browser = context.getCurrentXmlTest().getParameter("browser");
		commonExtent.setSystemInfo("browser Name",browser);
		
		List<String> includeGroups = context.getCurrentXmlTest().getIncludedGroups();
		if (!includeGroups.isEmpty()) {
			commonExtent.setSystemInfo("included groups",includeGroups.toString());
		}

	  }
	
	public void onTestSuccess(ITestResult result) {
		test = commonExtent.createTest(result.getName());
		test.log(Status.PASS, " Test method successfully executed... " + result.getName() );
	  }

	public void onTestFailure(ITestResult result) {
		test = commonExtent.createTest(result.getTestClass().getName());
		test.log(Status.FAIL, " Test method is failed... " + result.getMethod().getGroups());
		test.log(Status.FAIL, " Test method failed cause is... " + result.getThrowable());

	}
	
	 public void onTestSkipped(ITestResult result) {
			test = commonExtent.createTest(result.getName());
			test.log(Status.SKIP, " Test method is skipped... " + result.getName());
	  }
	 
	 public void onFinish(ITestContext context) {
		 commonExtent.flush();
	 }
	 
}
