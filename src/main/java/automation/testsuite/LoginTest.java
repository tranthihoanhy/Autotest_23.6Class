package automation.testsuite;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.*;

import automation.common.CommonBase;
import automation.constant.CT_PageURLs;
import automation.page.LoginPage;
import automation.page.LogoutPageFactory;

public class LoginTest extends CommonBase{
	LoginPage login;
	@BeforeMethod
	public void openChrome()
	{
		driver = initFirefoxDriver(CT_PageURLs.URL_CODESTAR);
	}
	
	@Test
	public void logoutSuccessfully()
	{
		login = new LoginPage(driver);
		login.LoginFunction("admin@gmail.com", "12345678");
		assertTrue(driver.findElement(By.xpath("//p[text()='Quản lý người dùng']")).isDisplayed());
	}
	
	@Test
	public void loginFail_UsernameNotExist()
	{
		login = new LoginPage(driver);
		login.LoginFunction("randomemail@gmail.com", "123456");
		assertTrue(driver.findElement(By.xpath("//p[text()='Email này chưa được đăng ký.']")).isDisplayed());
	}
	
}
