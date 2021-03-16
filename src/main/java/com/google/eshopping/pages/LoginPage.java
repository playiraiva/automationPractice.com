package com.google.eshopping.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.google.eshopping.generic.WebActionUtil;

public class LoginPage extends BasePage {
	
	@FindBy(linkText="Sign in") private WebElement signInLink;
	@FindBy(id="email") private WebElement emailTextField;
	@FindBy(id="passwd") private WebElement passwordTextField;
	@FindBy(id="SubmitLogin") private WebElement signInButton;
	
	public WebElement getSignInLink() {
		return signInLink;
	}

	public WebElement getEmailTextField() {
		return emailTextField;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public WebElement getSignInButton() {
		return signInButton;
	}

	public LoginPage(WebDriver driver, WebActionUtil webActionUtil) {
		super(driver, webActionUtil);
	}
	
	public HomePage login(String username, String password) {
		webActionUtil.elementClick(getSignInLink());
		webActionUtil.enterData(getEmailTextField(), username);
		webActionUtil.enterData(getPasswordTextField(), password);
		webActionUtil.elementClick(getSignInButton());
		return new HomePage(driver,webActionUtil);
	}
}






