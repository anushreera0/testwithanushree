package tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import io.github.bonigarcia.wdm.WebDriverManager;

public class testBase {
	public static WebDriver driver;
	@BeforeSuite
	public void initializeVariables() throws InterruptedException {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.get("https://stg.ssm-erp.com");
		Thread.sleep(10000);
		System.out.println(driver.getTitle());
		driver.manage().window().maximize();
		
	}
	@AfterSuite
	public void tearDown() {
		driver.quit();
	}

}
