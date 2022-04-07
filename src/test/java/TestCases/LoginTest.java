package TestCases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.TestBase;

public class LoginTest extends TestBase {

	@Test
	public void loginAsBankManager() throws InterruptedException{
		driver.navigate().to(Config.getProperty("testsiteurl"));
		Thread.sleep(1000);
		driver.findElement(By.cssSelector((OR.getProperty("bmlBtn")))).click();
		Thread.sleep(3000);
	}
}
