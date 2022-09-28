package globalData;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class extentReportsNG {

	
	public static ExtentReports getReportObject() {
		String path=System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter rep=new ExtentSparkReporter(path);
		rep.config().setReportName("Automation");
		rep.config().setDocumentTitle("Test Result");
		ExtentReports ext=new ExtentReports();
		ext.attachReporter(rep);
		ext.setSystemInfo("Tester", "Rupjit");
		return ext;
		
		
	}
	
}
