package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        // This method is called when any test method starts.
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // This method is called when any test method completes successfully.
    }

    @Override
    public void onTestFailure(ITestResult result) {
        // This method is called when any test method fails.
        TakesScreenshot ts = (TakesScreenshot) DriverManager.getInstance().getDriver();
        byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);

        try (FileOutputStream fos = new FileOutputStream(new File("./" + result.getName() + ".png"))) {
            fos.write(screenshot);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // This method is called when any test method is skipped.
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // This method is called each time a test method fails but is within
        // success percentage for TestNG annotation.
    }

    @Override
    public void onStart(ITestContext context) {
        // This method is called before the SuiteRunner starts.
    }

    @Override
    public void onFinish(ITestContext context) {
        // This method is called after the SuiteRunner has run all
        // the test suites.
    }
}
