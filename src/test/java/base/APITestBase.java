package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import service.TodoService;
import service.UserService;
import utility.ExtentSparkReporterUtil;

import java.lang.reflect.Method;

public class APITestBase {

    protected static ExtentReports extent;
    protected static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    public static TodoService todoService;
    public static UserService userService;

    @BeforeClass
    public void setUp()
    {
        userService = UserService.getUserService();
        todoService = TodoService.getTodoService();
    }

    @BeforeSuite
    public void setupSuite() {
        extent = ExtentSparkReporterUtil.getInstance();
    }

    @BeforeMethod
    public void createTest(Method method) {
        ExtentTest extentTest = extent.createTest(method.getName());
        test.set(extentTest);
    }

    @AfterMethod
    public void tearDownTest() {
        extent.flush();
    }

    public ExtentTest getTest() {
        return test.get();
    }


}
