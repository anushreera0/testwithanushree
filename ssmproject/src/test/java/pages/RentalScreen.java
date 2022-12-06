package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import tests.testBase;

public class RentalScreen extends testBase{

	public void verifyRentalScreen(String UnitSize, String unitNumber) throws InterruptedException {
		Thread.sleep(7000);
		driver.findElement(By.className("lft_padd")).getText().compareTo(UnitSize+"("+unitNumber+")");

	}

	
}
