package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pages.Prospects_screen;
import pages.RentalScreen;
import pages.contactInfoScreen;
import pages.login_to_application;
import pages.unitInfoScreen;

public class PerformRentalWithInsurance extends testBase{
	String unitSize="0.10X0.10";
	String unitNumber;
	String GateCode;
	@Test
	public void Login() throws InterruptedException {
		login_to_application loginpage=PageFactory.initElements(driver, login_to_application.class);
		loginpage.login("ez Manager", "Esoft@555");
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
		unitInfo.selectUnitsize();
		System.out.println(unitNumber=unitInfo.selectUnit());
		unitInfo.ClickRental();

	}

	@Test(dependsOnMethods="UnitInfoScreen")
	public void RentalVerify() throws InterruptedException {
		RentalScreen rental=PageFactory.initElements(driver, RentalScreen.class);
		rental.verifyRentalScreen(unitSize, unitNumber);
		rental.clickcustomerInfoDetailsInRentalScreen();
		System.out.println(GateCode=rental.customerInfoDetailsInRentalScreen());
		rental.clickSaveincustomerInfoDetailsInRentalScreen();
	}

}
