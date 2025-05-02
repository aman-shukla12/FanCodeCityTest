package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentSparkReporterUtil {

    private static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null) {
            createInstance(getReportFilePath());
        }
        return extent;
    }

    public static ExtentReports createInstance(String filePath) {
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(filePath);
        sparkReporter.config().setReportName("FanCode Automation Test Report");
        sparkReporter.config().setDocumentTitle("FanCode Test Execution");

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        extent.setSystemInfo("Project", "FanCode");
        extent.setSystemInfo("QA", "Aman Shukla");
        extent.setSystemInfo("Environment", "QA");

        return extent;
    }

    public static String getReportFilePath() {
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        return "reports/extent-report-" + timestamp + ".html";
    }
}
