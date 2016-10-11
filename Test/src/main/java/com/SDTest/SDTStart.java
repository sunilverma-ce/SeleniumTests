package com.SDTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author Sunil Verma
 */
public class SDTStart {
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\NerdAppSunil\\Bkup\\AutoWork\\Sunil\\Test\\libs\\2.21\\windows\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("http://www.snapdeal.com");
		Thread.sleep(5000);
		driver.manage().window().maximize();

		// Object for SnapDeal home page
		SDHome loginPage = new SDHome(driver);
		UserPage sunilUserPage = loginPage.loginSDUser(driver);

		assert sunilUserPage.userNameCtrl.equals("Sunil Kumar Verma ");
	}
}
