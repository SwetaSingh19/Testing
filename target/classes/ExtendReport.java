package collect;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendReport {
	static ExtentReports report;
	public static ExtentReports getReporter()
	{
		String path=System.getProperty("user.dir")+"\\Report.html";
		ExtentSparkReporter reporter= new ExtentSparkReporter(path);
		reporter.config().setDocumentTitle("Regression Report");
		reporter.config().setReportName("Automation Result");
		report= new ExtentReports();
		report.attachReporter(reporter);
		report.setSystemInfo("Sweta","tester");
		return report;
		
	}

}
