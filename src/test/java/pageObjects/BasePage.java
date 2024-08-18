package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ConfigProperties;

public class BasePage {
	
	public static WebDriver driver;
	
	public BasePage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@BeforeClass
	public static void beforeClass()
	{
		
		ConfigProperties.initializePropertiesFile();
		
		if(ConfigProperties.property.getProperty("BrowserType").equalsIgnoreCase("Firefox")) {
			
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else if(ConfigProperties.property.getProperty("BrowserType").equalsIgnoreCase("Chrome")) {
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		
		driver.navigate().to(ConfigProperties.property.getProperty("url"));
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public static void afterClass()
	{
		
		driver.quit();
	}

}
