package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import tests.testBase;

public class RentalScreen extends testBase{
SoftAssert softassertion=new SoftAssert();

	public void verifyRentalScreen(String UnitSize, String unitNumber) throws InterruptedException {
		Thread.sleep(7000);
		driver.findElement(By.className("lft_padd")).getText().compareTo(UnitSize+"("+unitNumber+")");

	}
	
	public void selectInsurancePremium(String selectInsurancePremium) throws InterruptedException {
		Thread.sleep(4000);
		try {
		WebElement insDropdown=driver.findElement(By.xpath("//label[contains(text(),'Insurance')]/following-sibling::div[@class='det_rgt']/select"));
		Select sel=new Select(insDropdown);
		sel.selectByVisibleText(selectInsurancePremium);
		Assert.assertEquals(selectInsurancePremium, insDropdown.getText());

		}
		catch (Exception e) {
			System.out.println("error didnt select it");
		}
		
	}

	
}
