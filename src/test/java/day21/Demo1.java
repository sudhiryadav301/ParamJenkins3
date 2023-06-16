package day21;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Demo1 {


	@Parameters({"gridURL"})
	@Test
	public void testA(String gridURL) throws Exception
	{
		Reporter.log("testA of Demo1 of day 21",true);
		WebDriver driver=new RemoteWebDriver(new URL(gridURL),new ChromeOptions());
		//WebDriver driver=new ChromeDriver();
		driver.get("https://demo.actitime.com/login.do");
		System.out.println(driver.getTitle());
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.name("pwd")).sendKeys("manager");
		driver.findElement(By.id("loginButton")).click();
		Thread.sleep(7000);
		System.out.println(driver.getTitle());
		driver.quit();
	}
}


