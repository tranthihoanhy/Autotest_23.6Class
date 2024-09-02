package automation.testsuite;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.annotations.*;

import automation.common.CommonBase;
import automation.constant.CT_PageURLs;
import automation.page.LoginPageFactory;
import automation.page.LogoutPageFactory;

public class LoginTestFactory extends CommonBase {
	LoginPageFactory loginFactory;
	LogoutPageFactory logoutFactory;

	// Ctrl + A -> Ctrl + Shift + F
	@BeforeMethod
	public void openFireFox() {
		driver = initFirefoxDriver(CT_PageURLs.URL_ALADA);
	}

	@Test
	public void logoutSuccessfully() throws InterruptedException {
		loginFactory = new LoginPageFactory(driver);
		loginFactory.LoginFunction("admin@gmail.com", "12345678");
		assertTrue(driver.findElement(By.xpath("//p[text()='Quản lý người dùng']")).isDisplayed());
		Thread.sleep(10000);
		logoutFactory = new LogoutPageFactory(driver);
		logoutFactory.LogoutFunction();
		assertTrue(driver.findElement(By.xpath("//h4[text()='Đăng nhập']")).isDisplayed());
	}

	@Test
	public void loginFail_IncorrectPass() {
		loginFactory = new LoginPageFactory(driver);
		loginFactory.LoginFunction("admin@gmail.com", "123_incorrect");
		assertTrue(driver.findElement(By.xpath("//h4[text()='Đăng nhập']")).isDisplayed());
	}
}
