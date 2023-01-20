package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.github.dockerjava.api.model.Driver;

import pages.login_to_application;
import pages.CustomerListingScreen;
import pages.CustomerRentalScreen;
import pages.DocumentScreenGen;
import pages.MoveOutScreen;
import pages.PerformPayment;
import pages.CustomerDashboardScreen;

public class MoveOutForPastDueUnits extends testBase{
	@Test(dataProvider = "LoginCredential")
	public void setUp(String EnvName,String Environment, String UserName,String Passowrd) throws Exception {
		try {
		driver.get(Environment);
		Thread.sleep(10000);
		System.out.println(driver.getTitle());
		driver.manage().window().maximize();
		
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("EnvName issue for Login");
			
		}
		
	}
	@Test(dataProvider = "LoginCredential",dependsOnMethods="setUp")
	public void Login(String EnvName,String Environment, String UserName,String Password) throws InterruptedException {
		login_to_application loginpage=PageFactory.initElements(driver, login_to_application.class);
		try {
			
		loginpage.login(UserName,Password);
		
		}
		catch (Exception e) {
			System.out.println("signInCred not found");		}
		}
	@Test(dependsOnMethods ="Login")
	public void CustomerListingScreen() throws InterruptedException {
		CustomerListingScreen cls=PageFactory.initElements(driver, CustomerListingScreen.class);
		cls.clickCustomers();
		cls.filterForCustomerStatus("Past due");
		cls.selectCustomer();
	}
	@Test(dependsOnMethods ="CustomerListingScreen")
	public void CustomerDashboardScreen() throws InterruptedException {
		CustomerDashboardScreen cds=PageFactory.initElements(driver,CustomerDashboardScreen.class);
		cds.verifyCustomerDashboardScreen();
		cds.priorityNotepopup();
		cds.navigateTocustomerRentalScreen();
	}
	@Test(dependsOnMethods ="CustomerDashboardScreen")
	public void ClickMoveoutButton() throws InterruptedException {
		CustomerRentalScreen cMB=PageFactory.initElements(driver, CustomerRentalScreen.class);
		cMB.clickMoveOutButton();
	}
	
	@Test(dependsOnMethods ="ClickMoveoutButton")
	public void clickMoveOutButtoninMOScreen() throws InterruptedException {
		MoveOutScreen mos=PageFactory.initElements(driver, MoveOutScreen.class);
		mos.verifyMoveoutScreen();
		mos.verifyMoveOutBalance();
		mos.selectMoveOutReason();
		mos.clickMoveOutButton();
	}
	
	@Test(dependsOnMethods ="clickMoveOutButtoninMOScreen")
	public void performPaymentatMoveout() throws InterruptedException {
		PerformPayment ppay=PageFactory.initElements(driver,PerformPayment.class);
		String amountToPay=ppay.verifyPaymentScreen();
		ppay.cashPayment(amountToPay);
		
	}
	
	@Test(dependsOnMethods ="performPaymentatMoveout")
	public void documentGen() throws InterruptedException {
		DocumentScreenGen dgn=PageFactory.initElements(driver, DocumentScreenGen.class);
		dgn.verifyDocumentScreen();
		dgn.performdocgen();
		dgn.TenantLedgerAndTenantNotes();
		dgn.clickNextButton();
		driver.quit();
	}
	
	
}
