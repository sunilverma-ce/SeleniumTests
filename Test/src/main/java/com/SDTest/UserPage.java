package com.SDTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Sunil Verma
 */
public class UserPage {

	public UserPage(){}

	public UserPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".accountUserName")
	public WebElement userNameCtrl;

}
