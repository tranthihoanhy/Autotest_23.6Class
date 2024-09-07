package automation.testsuite;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import automation.common.CommonBase;
import automation.constant.CT_PageURLs;

public class HandleDatePicker extends CommonBase {
	@BeforeMethod
	public void openChrome() {
		driver = initChromeDriver(CT_PageURLs.URL_GURU99_2);
	}

	@Test
	public void checkGuru() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement button = driver.findElement(By.name("btnLogin"));
		// Login to Guru99
		driver.findElement(By.name("uid")).sendKeys("test");
		driver.findElement(By.name("password")).sendKeys("123456");
		// Perform Click on LOGIN button using JavascriptExecutor
		button.click();
		//js.executeScript("arguments[0].click();", button);
	}

	@Test
	public void inputBirthDay() {
		WebElement bdayText = driver.findElement(By.name("bdaytime"));
		bdayText.sendKeys("11202002");
		bdayText.sendKeys(Keys.TAB);
		bdayText.sendKeys("0900AM");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		assertTrue(
				driver.findElement(By.xpath("//div[contains(text(),'Your Birth Date is 2002-11-20')]")).isDisplayed());
	}
}
