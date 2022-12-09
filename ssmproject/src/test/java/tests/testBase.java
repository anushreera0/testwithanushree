package tests;


import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.ReadExcelFile;

public class testBase {
	String Environment = "Staging";
	public Object[][] Data;
	public static WebDriver driver;
	
	@DataProvider(name="LoginCredential")
	public Object[][] testData() throws IOException {
	ReadExcelFile refL=new ReadExcelFile("https://globalesoftsys-my.sharepoint.com/personal/anushree_e-softsys_com/Documents/BookForTest.xlsx?web=1");
	Data = refL.getData();
	refL.getEnvironment(Environment);
	return Data;
	}
	
	
	@BeforeSuite
	public void initializeVariables() throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		//WebDriver driver=testBase.driver;
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
		
	
	
	/*@AfterSuite
	public void tearDown() {
		System.out.println("Quitting");
		driver.quit();
	}*/

}
