package pages;

import org.openqa.selenium.By;

import tests.testBase;

public class CustomerListingScreen extends testBase{
	public void clickCustomers() {
		driver.findElement(By.linkText("/customer")).click();
		driver.findElement(By.className("prospectsHeader")).getText().compareTo("CUSTOMERS");
	}
	public void filterForCustomerStatus(String status) throws InterruptedException {
		driver.findElement(By.name("status")).sendKeys(status);
		Thread.sleep(7000);
	}
	public void selectCustomer() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"scrollMe\"]/tbody/tr[1]/td[5]")).click();
		Thread.sleep(7000);
	}

}
