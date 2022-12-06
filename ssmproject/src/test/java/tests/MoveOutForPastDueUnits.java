package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pages.login_to_application;
import pages.CustomerListingScreen;
import pages.CustomerRentalScreen;
import pages.DocumentScreenGen;
import pages.MoveOutScreen;
import pages.PerformPayment;
import pages.CustomerDashboardScreen;

public class MoveOutForPastDueUnits extends testBase{
	@Test
	public void Login() throws InterruptedException {
		login_to_application loginpage=PageFactory.initElements(driver, login_to_application.class);
		loginpage.login("ez Manager", "Esoft@555");
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
		cds.navigateTocustomerRentalScreen();
	}
	@Test(dependsOnMethods ="CustomerDashboardScreen")
	public void ClickMoveoutButton() {
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
		dgn.clickNextButton();
	}
	
	
}
