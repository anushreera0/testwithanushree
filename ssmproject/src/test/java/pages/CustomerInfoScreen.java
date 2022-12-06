package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;


public class CustomerInfoScreen extends RentalScreen{
	public void clickcustomerInfoDetailsInRentalScreen() throws InterruptedException {
		driver.findElement(By.linkText("Add Customer Info")).click();
		Thread.sleep(7000);
	}

	public String gateCodeGeneration() throws InterruptedException {
		login_to_application lta=new login_to_application();
		String random=lta.randomnumbersequence();
		Thread.sleep(7000);

		driver.findElement(By.cssSelector("[formcontrolname=\"GateCode\"]")).sendKeys(random);
		try {
			String warningGateAccessCode=driver.findElement(By.xpath("//input[@formcontrolname=\"GateCode\"]/following-sibling::div/span")).getText();
			while(warningGateAccessCode.contains("Gate Code "+random+" Already exists")) {
				if(warningGateAccessCode.contains("Gate Code "+random+" Already exists")) {
					random=lta.randomnumbersequence();

				}

			}
		}
		catch(Exception e) {

			driver.findElement(By.cssSelector("[formcontrolname=\"GateCode\"]")).sendKeys(random);

		}
		return random;
	}

	public void inputCustomerInfoDetails() {

	}
	public void militaryInfoDetails() {

	}
	public void businessAccountInfoDetails() {

	}
	public void portalLoginInfoDetails() {

	}
	public void clickSaveincustomerInfoDetailsInRentalScreen() throws InterruptedException {
		//customerInfoDetailsInRentalScreen();
		JavascriptExecutor js=(JavascriptExecutor) driver;
		try {
		
			js.executeScript("window.scrollBy(0,document.body.scrollHeight)","");

			Thread.sleep(7000);
			WebElement saveInCustomerInfo=driver.findElement(By.xpath("//div[contains(@class,\"merchandise_sec ng-star-inserted\")]/div/button[contains(text(),\"Save\")]"));
			while(saveInCustomerInfo.isEnabled()) {
				if(saveInCustomerInfo.isEnabled()) {
					try {	
						saveInCustomerInfo.click();
						Thread.sleep(7000);
						js.executeScript("window.scrollTo(document.body.scrollHeight,0)","");
						Thread.sleep(4000);
						driver.findElement(By.xpath("//h5[contains(text(),'Rent Unit')]")).getText().compareTo("RENT UNIT");			

					}
					
					catch(org.openqa.selenium.StaleElementReferenceException ex) {
						System.out.println("StaleElementReferenceException");

						}
				}
				else {
					gateCodeGeneration();
					System.out.println("Save not found");
				}
			}
		}
		catch (Exception e) {
			System.out.println("Save not clicked");

		}
		}
		
		
}
