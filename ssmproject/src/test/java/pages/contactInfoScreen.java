package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;

import tests.testBase;

public class contactInfoScreen extends testBase {
	login_to_application lta=new login_to_application();
	//FirstName
	String randomData=lta.randomsequence();
	public void contactInfoName(String firstName, String middleName, String lastName) throws InterruptedException {
		Thread.sleep(5000);

		String FirstName=firstName+randomData;
		driver.findElement(By.cssSelector("[formcontrolname=\"FirstName\"]")).sendKeys(FirstName);
		//LastName
		randomData=lta.randomsequence();
		String LastName=lastName+randomData;
		driver.findElement(By.cssSelector("[formcontrolname=\"LastName\"]")).sendKeys(LastName);

	}
	public void Country(String country) {

	}
	public void State(String state) {
		//State
		Select sel=new Select(driver.findElement(By.cssSelector("[formcontrolname=\"StateId\"]")));
		sel.selectByVisibleText(state);
	}
	public void AddressCityZip(String address,String city, String zipCode) {

	}
	public void CellPhone(String cellPhone) throws InterruptedException {
		//Cell Phone
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("var obj = document.querySelector(\"input[formcontrolname='CellPhoneNumber']\");obj.value= 'cellPhone';var evt = document.createEvent(\"HTMLEvents\");evt.initEvent(\"input\", false, true);obj.dispatchEvent(evt);");
		Thread.sleep(10000);
	}

}
