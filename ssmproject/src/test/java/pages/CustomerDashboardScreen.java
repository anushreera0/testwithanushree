package pages;

import org.openqa.selenium.By;

import tests.testBase;

public class CustomerDashboardScreen extends testBase{
public void verifyCustomerDashboardScreen() {
	driver.findElement(By.linkText("Dashboard")).getText().compareTo("Dashboard");
	
}
public void navigateTocustomerRentalScreen() throws InterruptedException {
	driver.findElement(By.linkText("Rental")).click();
	Thread.sleep(7000);
}
}
