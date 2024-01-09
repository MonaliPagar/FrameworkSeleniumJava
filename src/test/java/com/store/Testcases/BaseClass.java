package com.store.Testcases;

import java.io.File;
import java.time.Duration;
import org.apache.logging.log4j.Logger;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import java.io.IOException;


import com.store.Utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	ReadConfig readConfig = new ReadConfig();
	
	String url = readConfig.getBaseUrl();
	String browser = readConfig.getBrowser();
	
	public String emailAddress = readConfig.getEmail() ;
	String password = readConfig.getPassword();
	
	
	public static Logger logger;
	public static WebDriver driver;
	
	
	@BeforeClass
	public void setup() 
	{
		String browser = "chrome";
		
		switch(browser.toLowerCase())
		{
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
			
			
		case "msedge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
			
			
		case "":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
			
		default:
			driver=null;
			break;
		}
		
		
		//implicitly wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		
		//for logging
		logger = LogManager.getLogger("MyStoreV1");
		
		//open url
		driver.get(url);
		logger.info("url opened");
		
		
		
	}
	
	
	
	
	
	@AfterClass
	public void tearDown()
	{
		driver.close();
		driver.quit();
	}
	
	
	
	
	
	public void captureScreenshot(WebDriver driver,String testName) throws IOException 
	{
		TakesScreenshot screenshot = ((TakesScreenshot)driver);
		
		File src= screenshot.getScreenshotAs(OutputType.FILE);
		File dest = new File(System.getProperty("user.dir") +"//screenshots//" +testName + ".png");
		
		FileUtils.copyFile(src,dest);
	}
	}




