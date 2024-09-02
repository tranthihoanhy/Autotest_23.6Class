package automation.testsuite;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import automation.common.CommonBase;
import automation.constant.CT_PageURLs;

public class Day12_Dropdownlist extends CommonBase{

	@BeforeMethod
	public void openChrome()
	{
		driver = initChromeDriver(CT_PageURLs.URL_SELENIUMEASY3);
	}
	
	@Test
	public void case1_Dropdownlist()
	{
	  Select dropdownDay = new Select(driver.findElement(By.id("select-demo")));
	  //Case1: kiểm tra size của dropdownlist là 7
	  assertEquals(dropdownDay.getOptions().size(),8);
	  
	  //Case2: chọn Monday bằng cách thứ nhất, kiểm tra giá trị sau khi chọn
	  dropdownDay.selectByVisibleText("Monday");
	  assertEquals(dropdownDay.getFirstSelectedOption().getText(), "Monday");
	  
	  //Case3: chọn Tuesday bằng cách 2, kiểm tra giá trị sau khi chọn
	  dropdownDay.selectByValue("Tuesday");
	  assertEquals(dropdownDay.getFirstSelectedOption().getText(), "Tuesday");
	  
	  //Case3: chọn Sunday bằng cách 3, kiểm tra giá trị sau khi chọn
	  dropdownDay.selectByIndex(1);
	  assertEquals(dropdownDay.getFirstSelectedOption().getText(), "Sunday");
	}
}
