package tests;


import java.io.IOException;
import java.time.Duration;
import java.util.stream.IntStream;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v102.webauthn.model.Credential;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;
import com.github.dockerjava.core.dockerfile.DockerfileStatement.Env;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ReadExcelFile;

public class testBase {
	
	public static WebDriver driver;

	@DataProvider(name="LoginCredential")
	public String[][] testData() throws IOException {

		String pathString="C:\\Users\\anushree\\Documents\\BookForTest.xlsx";
		String Environment = "Staging";
		int i,j = 0;
		ReadExcelFile refL=new ReadExcelFile(pathString);
		int totalRows=refL.getRowCount("Book1");
		int totalCols=refL.getCellCount("Book1", 1);
		String loginData[][]=new String[totalRows][totalCols];
		String Credential[][]=new String[totalRows][totalCols];
		/*for(int i=1;i<=totalRows;i++)
		{
			for(int j=0;j<totalCols;j++)
			{
				System.out.println(loginData[i-1][j]=refL.getCellData("Book1",i,j));
			}
		}*/
		for( i=1;i<=totalRows;i++)
		{
			for( j=0;j<totalCols;j++) {
				System.out.println(loginData[i-1][j]=refL.getCellData("Book1",i,j));
				System.out.println(loginData[i-1][j]);
				if(loginData[i-1][j].equals(Environment)){
				for( j=0;j<totalCols;j++){
					System.out.println(Credential[i-1][j]=refL.getCellData("Book1",i,j));
					IntStream.range(0,Credential.length).forEach(x -> 
			        IntStream.range(0, Credential[x].length).forEach(y -> {
			if (Credential[x][y] == null) {
				Credential[x][y] = "";
			}
			}));
					}
				}
			}
		}
		
			
		return Credential;

	}
	
	@DataProvider(name="ContactInfoDetails")
	public String[][] contactInfoData() throws IOException{
		String pathString="C:\\Users\\anushree\\Documents\\BookForContactInfoTest.xlsx";
		int i,j = 0;
		ReadExcelFile refL=new ReadExcelFile(pathString);
		int totalRows=refL.getRowCount("ContactInfo");
		int totalCols=refL.getCellCount("ContactInfo", 1);
		String contactInfo[][]=new String[totalRows][totalCols];
		String detailsContactInfo[][]=new String[totalRows][totalCols];
		
		for( i=1;i<=totalRows;i++)
		{
			for( j=0;j<totalCols;j++) {
				System.out.println(contactInfo[i-1][j]=refL.getCellData("Book1",i,j));
				System.out.println(contactInfo[i-1][j]);
				/*if(contactInfo[i-1][j].equals()){
				for( j=0;j<totalCols;j++){
					System.out.println(detailsContactInfo[i-1][j]=refL.getCellData("Book1",i,j));
					IntStream.range(0,detailsContactInfo.length).forEach(x -> 
			        IntStream.range(0, detailsContactInfo[x].length).forEach(y -> {
			if (detailsContactInfo[x][y] == null) {
				detailsContactInfo[x][y] = "";
			}
			}));
					}
				}*/
			}
		}
		return contactInfo;
		
	}


	@BeforeSuite
	public void initializeVariables() throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		//WebDriver driver=testBase.driver;
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	
	

	/*@BeforeSuite(dependsOnMethods = "initializeVariables")
	public void setUp() throws Exception {
		driver.get("https://stg.ssm-erp.com");
		Thread.sleep(10000);
		System.out.println(driver.getTitle());
		driver.manage().window().maximize();

	}	*/


	/*@AfterSuite
	public void tearDown() {
		System.out.println("Quitting");
		driver.quit();
	}*/

}
