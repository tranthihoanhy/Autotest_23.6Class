package automation.testsuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import automation.common.CommonBase;

public class Day8_Practice extends CommonBase{
	@BeforeMethod
	public void openBrowser()
	{
		driver = initChromeDriver("https://alada.vn/tai-khoan/dang-ky.html");
	}
	
	@Test
	public void getElementBy()
	{
		WebElement txtHovaTen = driver.findElement(By.id("txtFirstname"));
		System.out.println(txtHovaTen);
		
		WebElement txtEmail = driver.findElement(By.name("txtEmail"));
		System.out.println(txtEmail);
		
		WebElement linkChinhSach = driver.findElement(By.linkText("chính sách"));
		System.out.println(linkChinhSach);
		
		WebElement linkThoaThuanSuDung = driver.findElement(By.partialLinkText("sử dụng"));
		System.out.println(linkThoaThuanSuDung);
		
		WebElement checkboxDongY = driver.findElement(By.className("marleft0"));
		System.out.println(checkboxDongY);
		
		WebElement buttonDangKy = driver.findElement(By.tagName("button"));
		System.out.println(buttonDangKy);
		
		WebElement txtHoVaTen2 = driver.findElement(By.xpath("//input[@placeholder='Nhập họ và tên']"));
	}
}
