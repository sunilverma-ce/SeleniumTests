package com.SDTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Sunil Verma
 */
public class SDHome {

	public SDHome(WebDriver myWD){
		PageFactory.initElements(myWD, this);
	}

	@FindBy(className = "accountUserImg")
	public WebElement accountName;

	@FindBy(css = "span[class='accountBtn btn rippleWhite']")
	public WebElement loginBtn;

	@FindBy(id = "userName")
	public WebElement userName;

	@FindBy(id = "checkUser")
	public WebElement checkUser;

	@FindBy(id = "j_password_login_uc")
	public WebElement passwdCtrl;

	@FindBy(id = "submitLoginUC")
	public WebElement clickToLogin;

	public UserPage loginSDUser(WebDriver driver){
		Actions action = new Actions(driver);
		action.moveToElement(accountName).build().perform();
		loginBtn.click();

		// Test variablwa Remove This
		String loginID = "test@gmail.com";
		String password = "TestPs";

		driver.switchTo().frame("iframeLogin");
		userName.sendKeys(loginID);
		if (checkUser.isDisplayed())
			checkUser.click();

		WebDriverWait myWait = new WebDriverWait(driver, 15);
		myWait.until(ExpectedConditions.visibilityOf(passwdCtrl));
		passwdCtrl.sendKeys(password);
		clickToLogin.click();
		return new UserPage();
	}

}
