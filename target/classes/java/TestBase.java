import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.testng.Reporter;

public class TestBase {

    protected static String systemdir = System.getProperty("user.dir");
    public static String currentLoggedStep = "";
    public static final String CAPTURE_SCREEN_FOLDER_PATH = systemdir + "\\test-output\\WebCaptures";
    static protected ExtentReports reporter;
    static protected ExtentTest testReport;
    String sReportFile = "";

    @BeforeSuite
    public void beforeSuite(){
        sReportFile = Paths.get(System.getProperty("user.dir") + "/test-output/Report.html").toString();
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(sReportFile);
        htmlReporter.config().setReportName("AppiumDemo - Automation Report");
        reporter = new ExtentReports ();
        reporter.attachReporter(htmlReporter);
    }

    public static void log(String text) throws Exception {
        Reporter.log(text);
        currentLoggedStep = text;
        //testReport.log(Status.INFO,text);
        testReport.log(Status.PASS, currentLoggedStep);
    }

    public static void logExtentReportFail(String text) {
        testReport.log(Status.DEBUG,text);
    }

    @AfterMethod
    protected void afterMethod(ITestResult result) throws Exception {
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM_yyyy");
        String fileNameMonth = dateFormat.format(now);
        SimpleDateFormat dateFormat1 = new SimpleDateFormat("MM_dd_yyyy");
        String fileNameDate = dateFormat1.format(now);
        String className = this.getClass().getName();
        String imgName = CAPTURE_SCREEN_FOLDER_PATH + fileNameMonth + "\\"
                + fileNameDate + "\\ScreenShots\\" + className + ".jpg";

        if (result.getStatus() == ITestResult.FAILURE) {
            testReport.log(Status.FAIL,  "Test Failed " + testReport.addScreenCaptureFromPath(imgName) );
        }
        else if (result.getStatus() == ITestResult.SUCCESS){
            testReport.log(Status.PASS, "Test passed "+ testReport.addScreenCaptureFromPath(imgName));
        }
        else  {
            testReport.log(Status.SKIP, "Test skipped " + testReport.addScreenCaptureFromPath(imgName) );
        }
        reporter.flush();
    }
}
