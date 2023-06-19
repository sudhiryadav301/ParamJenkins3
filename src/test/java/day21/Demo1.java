package day21;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Demo1 {

	@Parameters({"gridURL","appURL"})
	@Test
	public void testA(String gridURL,String appURL) throws Exception
	{
		ExtentReports report=new ExtentReports();	
		ExtentSparkReporter spark = new ExtentSparkReporter("report/Spark.html");
		report.attachReporter(spark);
		ExtentTest extentTest = report.createTest("testA");
		extentTest.info("testA of Demo1 of day 21");
		WebDriver driver=new RemoteWebDriver(new URL(gridURL),new ChromeOptions());
		driver.get(appURL);

		extentTest.info(driver.getTitle());
		
		extentTest.info("Enter username, pw & click login");
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.name("pwd")).sendKeys("manager");
		driver.findElement(By.id("loginButton")).click();
		Thread.sleep(7000);
		extentTest.info(driver.getTitle());
		driver.quit();
		report.flush();
	}
}
