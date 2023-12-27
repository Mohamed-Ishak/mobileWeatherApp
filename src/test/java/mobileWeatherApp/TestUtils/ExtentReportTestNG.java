package mobileWeatherApp.TestUtils;


import org.testng.annotations.BeforeMethod;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportTestNG {
	static	ExtentReports extent ;
	
	@BeforeMethod
	public static ExtentReports getReport() { 
	String path = System.getProperty("user.dir")+"\\test-output\\Reports\\report.html";
	ExtentSparkReporter reporter = new ExtentSparkReporter(path);
	reporter.config().setReportName("Weather App Report ");
	reporter.config().setDocumentTitle("Weather Results");
	
	extent = new ExtentReports();
	extent.attachReporter(reporter);
	extent.setSystemInfo("Automation Tester", "Mohamed Ishak");
	
	return extent ;
	}
}
