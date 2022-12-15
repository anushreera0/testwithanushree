package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import tests.testBase;

public class CustomerDashboardScreen extends testBase{
	public void verifyCustomerDashboardScreen() {
		driver.findElement(By.linkText("Dashboard")).getText().compareTo("Dashboard");

	}
	public void navigateTocustomerRentalScreen() throws InterruptedException {
		driver.findElement(By.linkText("Rental")).click();
		Thread.sleep(7000);
	}
	public void priorityNotepopup() throws InterruptedException {
		Thread.sleep(5000);
		try {
		WebElement priority=driver.findElement(By.xpath("//h5[@class=\"modal-title\"][contains(text(),\"Priority Note\")]"));
		if(priority.isDisplayed()==true) {
			driver.findElement(By.xpath("//form[contains(@class,\"ng-untouched ng-pristine ng-valid\")]/div/div/button[contains(text(),\"Cancel\")]")).click();			
		}
		else {
			
		}
	}
		catch(Exception e) {
			System.out.println("Priority Note popup is not there!");
		}
	}


}
