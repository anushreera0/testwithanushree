package pages;

import org.openqa.selenium.By;

import tests.testBase;

public class CustomerRentalScreen extends testBase{
	public void verifyCustomerRental(String firstName, String lastName,String unitNumber) {
		driver.findElement(By.xpath("(//li/span/following-sibling::text())[1]")).getText().compareTo(firstName+" "+lastName);
		driver.findElement(By.xpath("(//div[contains(@class,\"det_rgt\")]/span)[1]")).getText().compareTo(unitNumber);
	}
	public void clickMoveOutButton() {
		driver.findElement(By.xpath("//button[@dataname=\"Move-Out\"]")).click();

	}
}
