package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class unitInfoScreen {
	public WebDriver driver;

	public void clickUnitInfo() throws InterruptedException {
		boolean display=driver.findElement(By.linkText("Unit Info")).isDisplayed();
		if(display==true)
			driver.findElement(By.linkText("Unit Info")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("openModalButton")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("exampleModalLongTitle")).getText().compareTo("Add Unit");
	}
	public String selectUnitType1() throws InterruptedException {
		Thread.sleep(7000);
		String UnitSize="0.10X0.10";
		WebElement unitsize=driver.findElement(By.xpath("//div[@class=\"unit_sel_box\"]/select"));
		Select sel2=new Select(unitsize);
		Thread.sleep(5000);

		sel2.selectByVisibleText(UnitSize);
		return UnitSize;
	}
	
	public void selectUnitType() throws InterruptedException {
		selectUnitType1();
	}
	
	public String selectUnitsize() throws InterruptedException {
		Thread.sleep(5000);
		String unitNumber = null;
		driver.findElement(By.xpath("//a[@class=\"tab_clic_1 collapsed\"]")).click();
		Thread.sleep(20000);
		WebElement checkboxToCheck=driver.findElement(By.xpath("//td/table/tbody/tr/td[1]/div/label"));
		if(checkboxToCheck.isEnabled()==true) {
			checkboxToCheck.click();
		}		
		Thread.sleep(5000);
		if(checkboxToCheck.isSelected()==true) {
			unitNumber=driver.findElement(By.xpath("//td/table/tbody/tr/td[2]")).getText();
		}
		driver.findElement(By.id("selectcardview")).click();
		Thread.sleep(5000);
		
		return unitNumber;
	}
	public void selectUnit() throws InterruptedException {
	
		selectUnitsize();
		
	}
	public void ClickInquiry() throws InterruptedException {
		driver.findElement(By.xpath("//button[contains(text(),\"Rental\")]")).click();
		Thread.sleep(7000);
		driver.findElement(By.xpath("//h5[contains(text(),\"Rental\")]")).getText().compareTo("RENTAL");
		driver.findElement(By.xpath("//h5[contains(text(),\"Rent Unit\")]")).getText().compareTo("RENT UNIT");
	}
	
	public void ClickReservation() throws InterruptedException {
		driver.findElement(By.xpath("//button[contains(text(),\"Rental\")]")).click();
		Thread.sleep(7000);
		driver.findElement(By.xpath("//h5[contains(text(),\"Rental\")]")).getText().compareTo("RENTAL");
		driver.findElement(By.xpath("//h5[contains(text(),\"Rent Unit\")]")).getText().compareTo("RENT UNIT");
	}
	
	public void ClickRental() throws InterruptedException {
		driver.findElement(By.xpath("//button[contains(text(),\"Rental\")]")).click();
		Thread.sleep(7000);
		driver.findElement(By.xpath("//h5[contains(text(),\"Rental\")]")).getText().compareTo("RENTAL");
		driver.findElement(By.xpath("//h5[contains(text(),\"Rent Unit\")]")).getText().compareTo("RENT UNIT");
	}
}
