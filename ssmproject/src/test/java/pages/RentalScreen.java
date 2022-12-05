package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RentalScreen {
	public WebDriver driver;

	public void verifyRentalScreen(String UnitSize, String unitNumber) throws InterruptedException {
		Thread.sleep(7000);
		driver.findElement(By.className("lft_padd")).getText().compareTo(UnitSize+"("+unitNumber+")");
		
	}
	
	public void clickcustomerInfoDetailsInRentalScreen() throws InterruptedException {
		driver.findElement(By.linkText("Add Customer Info")).click();
		Thread.sleep(7000);
	}
	
	public void customerInfoDetailsInRentalScreen() throws InterruptedException {
		login_to_application lta=new login_to_application();
		String random=lta.randomnumbersequence();
		Thread.sleep(7000);
		
		driver.findElement(By.cssSelector("[formcontrolname=\"GateCode\"]")).sendKeys(random);
		try {
			String warningGateAccessCode=driver.findElement(By.xpath("//input[@formcontrolname=\"GateCode\"]/following-sibling::div/span")).getText();
			while(warningGateAccessCode.contains("Gate Code "+random+" Already exists")==true) {
				if(warningGateAccessCode.contains("Gate Code "+random+" Already exists")==true) {
				random=lta.randomnumbersequence();
				driver.findElement(By.cssSelector("[formcontrolname=\"GateCode\"]")).sendKeys(random);
				break;
				}
	
			}
		}
		catch(Exception e) {
			
		}
		
	}
	
	/*public void GateCodeError() {
		String random=randomnumbersequence();
			else {
					break;
				}
			}
		
	}*/
	public void clickSaveincustomerInfoDetailsInRentalScreen() throws InterruptedException {
		//customerInfoDetailsInRentalScreen();
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)","");
	
		Thread.sleep(7000);

		WebElement saveInCustomerInfo=driver.findElement(By.xpath("//div[contains(@class,'bottom_button mt-3')]/button[contains(text(),'Save')]"));
		System.out.print(saveInCustomerInfo);
		while(saveInCustomerInfo.isEnabled()) {
		if(saveInCustomerInfo.isEnabled()) {
			try{
				saveInCustomerInfo.click();
				Thread.sleep(7000);
				js.executeScript("window.scrollTo(document.body.scrollHeight,0)","");
				Thread.sleep(4000);
				driver.findElement(By.xpath("//h5[contains(text(),'Rent Unit')]")).getText().compareTo("RENT UNIT");

			}
			catch(Exception e) {
				
			}
		}
		else {
			customerInfoDetailsInRentalScreen();
		}
	}
	}


}
