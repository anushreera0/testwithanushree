package tests;


import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class testBase {
	public static WebDriver driver;
	@BeforeSuite
	public void initializeVariables() throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		//WebDriver driver=testBase.driver;
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
		
	
	@BeforeSuite(dependsOnMethods="initializeVariables")
	public void setUp() throws Exception {
		driver.get("https://stg.ssm-erp.com");
		Thread.sleep(10000);
		System.out.println(driver.getTitle());
		driver.manage().window().maximize();
		
	}
	/*@AfterSuite
	public void tearDown() {
		System.out.println("Quitting");
		driver.quit();
	}*/

}
