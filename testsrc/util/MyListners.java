package util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

import static util.Screenhot.initExtentObject;
import static util.Screenhot.takescreenShot;

public class MyListners  extends OpenUrl implements ITestListener {

   static ExtentReports extent = initExtentObject();
     ExtentTest test;

    public void onTestStart(ITestResult result)
    // before the first line on test method execution
    {


        System.out.println("onTestStart");

        test = extent.createTest(result.getMethod().getMethodName());
    }

    public void onTestSuccess(ITestResult result)
    // after test is passed
    {
        System.out.println("onTestSuccess");
        test.pass(result.getMethod().getMethodName()+": this test is passed");
    }

    public void onTestFailure(ITestResult result)
    // after test is failed
    {
        System.out.println("onTestFailure");

        test.fail(result.getThrowable());

        try {
            test.addScreenCaptureFromPath("./screenshots/"+takescreenShot(driver));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onStart(ITestContext context)
    // on start of test tag (<test> )
    {
        System.out.println("onStart");
    }

    public  void onFinish(ITestContext context)
    // on end of test tag (<test> )
    {
        System.out.println("onFinish");
        extent.flush();
    }

}
