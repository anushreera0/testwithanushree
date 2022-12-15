package pages;

import java.lang.reflect.Array;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import tests.testBase;

public class DocumentScreenGen extends testBase {
	public void verifyDocumentScreen() {
		driver.findElement(By.xpath("//h5[contains(text(),\"Document\")]")).getText().compareTo("Document");
		
	}
	public void performdocgen() throws InterruptedException {
		WebElement chk1=driver.findElement(By.xpath("//span[contains(text(),'Select All')]"));
		chk1.click();
		WebElement chk=driver.findElement(By.xpath("//label[contains(@class,'pure-material-checkbox mb-0 mt-2')]/input"));
		if(chk.isSelected()) {
		////select[contains(@class,"form-control")]
			driver.findElement(By.xpath("//button[contains(text(),\"Process All\")]")).click();
			Thread.sleep(10000);
		}
		
	}
	public void TenantLedgerAndTenantNotes() {
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println(windowHandles);
		if(driver.getTitle()!="SSM") {
		while(driver.getTitle()=="Tenant Notes"||driver.getTitle()=="Customer Ledger") {
			driver.close();
		}
		}
		else {
			driver.switchTo().window("SSM");
		}
		
	}
	public void reputationManagement() {
		try{
			WebElement rMVisible=driver.findElement(By.xpath("//button[contains(text(),\"Yes\")]"));
			if(rMVisible.isDisplayed()) {
				driver.findElement(By.xpath("//button[contains(text(),\"Yes\")]")).click();
			}
			else {
				
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		}
	public void clickNextButton() throws InterruptedException {
		driver.findElement(By.xpath("//button[contains(text(),\"Next\")]")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//button[contains(text(),\"Yes\")]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[contains(text(),\"Document Processed\")]")).getText().compareTo("Document Processed");
		driver.findElement(By.xpath("(//span[contains(text(),\"Document Processed\")]/following::button[contains(text(),\"OK\")])[1]")).click();
		
	}

}
