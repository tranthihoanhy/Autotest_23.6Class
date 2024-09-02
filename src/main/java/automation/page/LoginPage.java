package automation.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	private WebDriver driver;
	public LoginPage(WebDriver _driver) {
		this.driver = _driver;
	}
	
	// Xây dựng hàm đăng nhập để sử dụng trong các class test
	public void LoginFunction(String email, String password)
	{
		WebElement textEmail = driver.findElement(By.id("email"));
		if(textEmail.isDisplayed())
		{
			textEmail.sendKeys(email);
		}
		
		WebElement textPassword = driver.findElement(By.id("password"));
		if(textPassword.isDisplayed())
		{
			textPassword.sendKeys(password);
		}
		
		WebElement btnLogin = driver.findElement(By.name("signin"));
		if(btnLogin.isDisplayed())
		{
			btnLogin.click();
		}
	}
}
