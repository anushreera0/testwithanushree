package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Prospects_screen {
	public WebDriver driver;
	public void clickProspects() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.className("nav-prospect")).click();
		Thread.sleep(7000);
		driver.findElement(By.className("prospectsHeader")).getText().compareTo("PROSPECTS");

	}
	
	@Test(dependsOnMethods="clickProspects",groups={"Rental","Inquiry","Reservation"})
	public void clickNewbutton() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.id("newstore")).click();
		driver.findElement(By.linkText("Contact Info")).getText().compareTo("Contact Info");
	}
	
}