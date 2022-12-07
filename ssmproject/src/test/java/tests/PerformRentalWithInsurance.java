package tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.AddDemographicScreen;
import pages.CustomerInfoScreen;
import pages.DocumentScreenGen;
import pages.PerformPayment;
import pages.Prospects_screen;
import pages.ReadExcelFile;
import pages.RentalScreen;
import pages.contactInfoScreen;
import pages.login_to_application;
import pages.unitInfoScreen;

public class PerformRentalWithInsurance extends testBase{


	String unitSize="0.10X0.10";
	String unitNumber;
	String GateCode;
	@DataProvider(name = "testData")
	public Object[][] testDataExample() throws IOException {
		ReadExcelFile config=new ReadExcelFile("C:\\Users\\anushree\\OneDrive - E-Softsys LLC\\BookForTest.xls");
		int rows=config.getRowCount(0);
		Object[][] signInCred=new Object[rows][2];
		for(int  i=0;i<rows;i++) {
			System.out.println(signInCred[i][0]= config.getData(0,i,3,"Book1"));
			System.out.println(signInCred[i][1]= config.getData(0,i,4,"Book1"));
		}
		System.out.println(signInCred);
		return signInCred;
	}
	@Test(dataProvider="testdata")
	public void Login(String username, String password) throws InterruptedException {
		login_to_application loginpage=PageFactory.initElements(driver, login_to_application.class);
		try {
		loginpage.login(username,password);
		}
		catch (Exception e) {
			System.out.println("signInCred not found");		}
		}
	
	@Test (dependsOnMethods="Login")
	public void ProspectsClickNewButton() throws InterruptedException {
		Prospects_screen prospects=PageFactory.initElements(driver, Prospects_screen.class);
		prospects.clickProspects();
		prospects.clickNewbutton();
	}

	@Test(dependsOnMethods="ProspectsClickNewButton")
	public void ContactInfoScreen() throws InterruptedException {
		contactInfoScreen contactInfo=PageFactory.initElements(driver, contactInfoScreen.class);
		contactInfo.contactInfoName("Roof", "", "Rent");
		contactInfo.Country("");
		contactInfo.State("Alberta");
		contactInfo.AddressCityZip("", "", "");
		contactInfo.CellPhone("9876543210");
	}

	@Test(dependsOnMethods="ContactInfoScreen")
	public void UnitInfoScreen() throws InterruptedException {
		unitInfoScreen unitInfo=PageFactory.initElements(driver, unitInfoScreen.class);
		unitInfo.clickUnitInfo();
		unitInfo.selectUnitType(unitSize);
		System.out.println(unitInfo.selectUnitsize());
		//System.out.println(unitNumber=unitInfo.selectUnit());
		unitInfo.ClickRental();

	}

	@Test(dependsOnMethods="UnitInfoScreen")
	public void RentalVerify() throws InterruptedException {
		RentalScreen rental=PageFactory.initElements(driver, RentalScreen.class);
		rental.verifyRentalScreen(unitSize, unitNumber);
	}
	
	@Test(dependsOnMethods="RentalVerify")
	public void CustomerInfo() throws InterruptedException {
		CustomerInfoScreen cInfo=PageFactory.initElements(driver, CustomerInfoScreen.class);
		cInfo.clickcustomerInfoDetailsInRentalScreen();
		System.out.println(GateCode=cInfo.gateCodeGeneration());
		cInfo.clickSaveincustomerInfoDetailsInRentalScreen();
	}
	
	@Test(dependsOnMethods="CustomerInfo")
	public void AddDemographic() throws InterruptedException {
		AddDemographicScreen addDemo=PageFactory.initElements(driver,AddDemographicScreen.class);
		addDemo.clickAddDemographic();
		addDemo.selectDemography();
	}
	
	@Test(dependsOnMethods="AddDemographic")
	public void ClickCompleteRental() throws InterruptedException {
		driver.findElement(By.xpath("//button[contains(text(),\"Complete Rental\")]")).click();
	}
	
	@Test(dependsOnMethods="ClickCompleteRental")
	public void PaymentScreen() throws InterruptedException {
		PerformPayment ppay=PageFactory.initElements(driver,PerformPayment.class);
		String amountToPay=ppay.verifyPaymentScreen();
		ppay.cashPayment(amountToPay);
		
	}
	
	@Test(dependsOnMethods="PaymentScreen")
	public void DocumentScreen() throws InterruptedException {
		DocumentScreenGen dgn=PageFactory.initElements(driver, DocumentScreenGen.class);
		dgn.verifyDocumentScreen();
		dgn.performdocgen();
		dgn.clickNextButton();
		
	}
	
	@Test(dependsOnMethods="DocumentScreen")
	public void UnitInfoAfterTransaction() throws InterruptedException {
		
	}
	
	@Test(dependsOnMethods="UnitInfoAfterTransaction")
	public void CustomerListingScreen() throws InterruptedException {
		
	}
}
