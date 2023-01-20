package pages;


import org.openqa.selenium.By;
import org.testng.Assert;

import tests.testBase;
public class login_to_application extends testBase{


	public String randomsequence() {

		// chose a Character random from this String
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
				+ "0123456789"
				+ "abcdefghijklmnopqrstuvxyz";
int n=5;
		// create StringBuffer size of AlphaNumericString
		StringBuilder sb = new StringBuilder(n);

		for (int i = 0; i <n ; i++) {

		// generate a random number between
		// 0 to AlphaNumericString variable length
		int index= (int)(AlphaNumericString.length()* Math.random());

		// add Character one by one in end of sb
		sb.append(AlphaNumericString.charAt(index));
		}

		return sb.toString();
		}
	public String randomnumbersequence() {

		// chose a Character random from this String
		String AlphaNumericString =  "0123456789";
int n=8;
		// create StringBuffer size of AlphaNumericString
		StringBuilder sb = new StringBuilder(n);

		for (int i = 0; i <n ; i++) {

		// generate a random number between
		// 0 to AlphaNumericString variable length
		int index= (int)(AlphaNumericString.length()* Math.random());

		// add Character one by one in end of sb
		sb.append(AlphaNumericString.charAt(index));
		}

		return sb.toString();
		}
	

	public void login(String UserName, String Password) throws InterruptedException {
		driver.findElement(By.id("signInName")).sendKeys(UserName);
		driver.findElement(By.id("password")).sendKeys(Password);
		driver.findElement(By.id("next")).click();
		Thread.sleep(30000);
		String Dashboard=driver.findElement(By.className("prospectsHeader")).getText();
		Assert.assertEquals(Dashboard, "DASHBOARD");

	}

}

