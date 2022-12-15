package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import tests.testBase;

public class MoveOutScreen extends testBase{
	public void verifyMoveoutScreen() throws InterruptedException {
		Thread.sleep(7000);
		driver.findElement(By.xpath("//h6[contains(text(),\"Move-Out\")]")).getText().compareTo("Move-Out");
	}
	public void transferCreditstoExistingUnits() {
		
	}
	public void changeMoveOutDate() {
		
	}
	public void verifyMoveOutBalance() {
		String[] balanceDisplayed=driver.findElement(By.xpath("//p[contains(@class,'text-danger')]")).getText().split("$");
		/*if(balanceDisplayed[1]) {
			
		}*/
	}
	public void selectMoveOutReason() throws InterruptedException {
		Thread.sleep(5000);
		Select sel=new Select(driver.findElement(By.xpath("//select[@title=\"Select\"]")));
		sel.selectByValue("1");
	}
	
	public void clickMoveOutButton() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[contains(text(),\"Move Out\")]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//p[contains(text(),\"Are You Sure You Want to Move-Out the Selected Unit?\")]")).getText().compareTo("Are You Sure You Want to Move-Out the Selected Unit?");
		driver.findElement(By.xpath("//button[contains(text(),\"Yes\")]")).click();
		Thread.sleep(6000);
	}

}
