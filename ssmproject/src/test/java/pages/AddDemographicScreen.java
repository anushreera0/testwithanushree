package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class AddDemographicScreen extends RentalScreen{
	public void clickAddDemographic() throws InterruptedException {
		driver.findElement(By.linkText("Add Demographic")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//h5[contains(text(),'Demographic')]")).getText().compareTo("DEMOGRAPHIC");
	}

	public void selectDemography() {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		WebElement chk1=driver.findElement(By.xpath("(//input[@type=\"checkbox\"]/following-sibling::span)[1]"));
		try{
			chk1.click();
			WebElement chk=driver.findElement(By.xpath("(//input[@type=\"checkbox\"][contains(@class,\"ng-valid ng-dirty ng-touched\")])[1]"));
			if(chk.isSelected() == true) {
				try {
					Thread.sleep(5000);
					js.executeScript("window.scrollBy(0,document.body.scrollHeight)","");
					driver.findElement(By.xpath("//div[contains(@class,\"merchandise_sec ng-star-inserted\")]/app-demographic/div/button[contains(text(),\"Save\")]")).click();
				}
				catch(Exception e){
					System.out.println("Save not found");

				}
				Thread.sleep(6000);
				js.executeScript("window.scrollTo(document.body.scrollHeight,0)","");
				driver.findElement(By.xpath("//h5[contains(text(),'Rent Unit')]")).getText().compareTo("RENT UNIT");
			}
			else {
				System.out.println("Save not clicked in AddDemographicScreen");
			}
			}
		catch(Exception e){
			System.out.println("checkbox not checked");
		}
	}
}
