package com.google.eshopping.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.google.eshopping.generic.WebActionUtil;

public class HomePage extends BasePage {
	
	@FindBy(linkText="Women") 
	private WebElement womenMenuLink;
	@FindBy(xpath="//a[text()='Women']/../following-sibling::li/a[text()='Dresses']")
	private WebElement dressesMenuLink;
	@FindBy(xpath="//a[text()='Women']/../following-sibling::li/a[text()='T-shirts']")
	private WebElement tShirtsMenuLink;
	@FindBy(linkText="Sign out") 
	private WebElement signOutLink;
	
	
	public WebElement getSignOutLink() {
		return signOutLink;
	}

	public WebElement getWomenMenuLink() {
		return womenMenuLink;
	}

	public WebElement getDressesMenuLink() {
		return dressesMenuLink;
	}

	public WebElement gettShirtsMenuLink() {
		return tShirtsMenuLink;
	}
	
	public HomePage(WebDriver driver, WebActionUtil webActionUtil) {
		super(driver, webActionUtil);
	}
	
	public ProductsListPage clickOnMenu(String menuName) {
		menuName = menuName.toLowerCase();
		switch(menuName) {
			case "women": webActionUtil.elementClick(getWomenMenuLink());
						  	break;
			case "dresses": webActionUtil.elementClick(getDressesMenuLink());
						    break;			  
			case "tshirts": webActionUtil.elementClick(gettShirtsMenuLink());
			  	            break;
		}
		
		return new ProductsListPage(driver, webActionUtil);
	}
	
	public void signOut() {
		webActionUtil.elementClick(getSignOutLink());
	}
}
