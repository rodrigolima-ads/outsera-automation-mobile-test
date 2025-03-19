package listeners;

import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.service.ExtentService;
import com.aventstack.extentreports.service.ExtentTestManager;
import enviroment.EnvironmentRuntimeLoader;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MobileListenerAdapter implements ITestListener {

    private AppiumDriver<MobileElement> driver = null;
    private JavascriptExecutor jse = null;
    private static final String CONTEXT_ATTRIBUTE = "AppiumDriver";
    private static final Logger LOGGER = Logger.getLogger(MobileListenerAdapter.class.getName());
    public static String scenario;

    @Override
    public synchronized void onStart(ITestContext context) {
        ExtentService.getInstance().setAnalysisStrategy(AnalysisStrategy.CLASS);
        scenario = context.getName();
    }

    @Override
    public synchronized void onFinish(ITestContext context) {
        ExtentService.getInstance().flush();
    }

    @Override
    public synchronized void onTestStart(ITestResult result) {
        ITestContext context = result.getTestContext();
        try {
            driver = (AppiumDriver<MobileElement>) context.getAttribute(CONTEXT_ATTRIBUTE);
            jse = driver;
            jse.executeScript("browserstack_executor: {\"action\": \"setSessionName\", \"arguments\": {\"name\":\""
                              + result.getMethod().getMethodName() + " "
                              + EnvironmentRuntimeLoader.get().toString().toUpperCase() + "\" }}");
        } catch (Exception e) {
            e.printStackTrace();
        }
        ExtentTestManager.createMethod(result, true);
    }

    @Override
    public synchronized void onTestSuccess(ITestResult result) {
        ITestContext context = result.getTestContext();
        driver = (AppiumDriver<MobileElement>) context.getAttribute(CONTEXT_ATTRIBUTE);
        Report report = new Report();

        ExtentTestManager.log(result, true);
        ExtentTestManager.getTest(result).pass(this.checkExecutionType(driver, report));

        driver.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"O teste passou!\"}}");
    }

    @Override
    public synchronized void onTestFailure(ITestResult result) {
        try {
            ITestContext context = result.getTestContext();
            driver = (AppiumDriver<MobileElement>) context.getAttribute(CONTEXT_ATTRIBUTE);
            Report report = new Report();
            ExtentTestManager.getTest(result).fail(result.getThrowable(), MediaEntityBuilder.createScreenCaptureFromBase64String(report.takeScreenshot()).build());
            ExtentTestManager.getTest(result).fail(this.checkExecutionType(driver, report));
            driver.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"failed\", \"reason\": \"O teste falhou!\"}}");
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, e.toString(), e);
        }
    }

    @Override
    public synchronized void onTestSkipped(ITestResult result) {
        ITestContext context = result.getTestContext();
        driver = (AppiumDriver<MobileElement>) context.getAttribute(CONTEXT_ATTRIBUTE);
        Report report = new Report();

        ExtentTestManager.log(result, true);
        ExtentTestManager.getTest(result).skip(this.checkExecutionType(driver, report));
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ExtentTestManager.log(result, true);
    }

    private Markup checkExecutionType(AppiumDriver<MobileElement> driver, Report report) {
        if (driver.getCapabilities().getCapability("url").toString().contains("browserstack")) {
            return MarkupHelper.createLabel(report.getBSAutomatedSessionURL(), ExtentColor.CYAN);
        } else {
            return MarkupHelper.createLabel("Execução Local!", ExtentColor.CYAN);
        }
    }
}

