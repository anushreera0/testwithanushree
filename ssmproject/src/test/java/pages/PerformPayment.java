package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class PerformPayment extends RentalScreen{
	public String verifyPaymentScreen() {
		driver.findElement(By.xpath("//h5[contains(text(),\"Payments\")]")).getText().compareTo("Payments");
		String[] amountToPay=driver.findElement(By.className("totalamt_pos")).getText().split(":");
		System.out.println(amountToPay[1]=amountToPay[1].trim());
		driver.findElement(By.xpath("//input[contains(@class,'form-control col-md-6 bg_gray form-control-sm ng-untouched ng-pristine ng-valid')]")).getText().compareTo(amountToPay[1]);
		return amountToPay[1];

	}
	
	public void cashPayment(String amountToPay) throws InterruptedException {
		Thread.sleep(7000);
		Select sel=new Select(driver.findElement(By.xpath("//td/select[contains(@class,'form-control form-control-sm')]")));
		sel.selectByVisibleText("Cash");
		clickPayNow();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[contains(text(),\"Pay $\")]")).click();
		Thread.sleep(2000);
		transactionSuccess();

	}
	public void checkPayment() {
		
	}
	public void hostedPagePaymentOpenEdge() {
		
	}
	public void hostedPagePaymentTD() {
		
	}
	public void offlinePayment() {
		
	}
	public void clickPayNow() {
		driver.findElement(By.xpath("//button[contains(text(),\"Pay Now\")]")).click();
	}
	public void transactionSuccess() throws InterruptedException {
		Thread.sleep(10000);
		////figcaption[contains(text(),"Transaction is in Progress. Please do not leave the page!")]
		WebElement TransSuccess=driver.findElement(By.xpath("//span[contains(text(),'Transaction Success!')]"));
		
		
		if(TransSuccess.isDisplayed()==true) {
		try {
			driver.findElement(By.xpath("//span[contains(text(),\"Transaction Success!\")]/following::button")).click();
			Thread.sleep(10000);
			
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Transaction Success popup Error");
		}
		}
		else {
			System.out.println("Payment failed");
		}
	}
	public void autopayOpenEdge() {
		
	}
	public void autopayTD() {
		
	}
	public void verifyAutopaySetup() {
		
	}
}
