package automation.page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPageFactory {
	private WebDriver driver;
	@FindBy(xpath = "//a[normalize-space()='Admin']") WebElement btnAdmin;
	@FindBy(xpath = "//button[text()='Đăng xuất' and @type='button']")WebElement btnLogout;
	@FindBy(xpath = "//button[text()='Đăng xuất' and @type='submit']") WebElement btnConfirmLogout;

	public LogoutPageFactory(WebDriver _driver) {
		this.driver = _driver;
		PageFactory.initElements(_driver, this);
	}

	// Xây dựng hàm đăng nhập để sử dụng trong các class test
	public void LogoutFunction() {
		btnAdmin.click();
		btnLogout.click();btnConfirmLogout.click();
	}
}
