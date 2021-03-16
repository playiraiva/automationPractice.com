package com.google.eshopping.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.google.eshopping.generic.WebActionUtil;

public class ProductDetailsPage extends BasePage {
	
	@FindBy(className="icon-plus")
	private WebElement plusIcon;
	
	@FindBy(className="icon-minus")
	private WebElement minusIcon;
	
	@FindBy(id="group_1")
	private WebElement sizeListBox;
	
	@FindBy(xpath="//ul[@id='color_to_pick_list']//a")
	private List<WebElement> colorPickerList;
	
	@FindBy(name="Submit")
	private WebElement addToCartButton;
	
	@FindBy(linkText="Proceed to checkout")
	private WebElement proceedToCheckoutButton;
	
	@FindBy(xpath="//span[@title='Continue shopping']")
	private WebElement continueToShoppingButton;
	
	@FindBy(className="cross")
	private WebElement closeIcon;
	
		
	public WebElement getPlusIcon() {
		return plusIcon;
	}


	public WebElement getMinusIcon() {
		return minusIcon;
	}


	public WebElement getSizeListBox() {
		return sizeListBox;
	}


	public List<WebElement> getColorPickerList() {
		return colorPickerList;
	}


	public WebElement getAddToCartButton() {
		return addToCartButton;
	}


	public WebElement getProceedToCheckoutButton() {
		return proceedToCheckoutButton;
	}


	public WebElement getContinueToShoppingButton() {
		return continueToShoppingButton;
	}


	public WebElement getCloseIcon() {
		return closeIcon;
	}


	public ProductDetailsPage(WebDriver driver, WebActionUtil webActionUtil) {
		super(driver, webActionUtil);
	}
	
	/*public void increaseQuantity(int quantityToIncrease) {
		for(int i=1;i<=quantityToIncrease;i++) {
			webActionUtil.elementClick(getPlusIcon());
		}
	}
	
	public void decreaseQuantity(int quantityToDecrease) {
		for(int i=1;i<=quantityToDecrease;i++) {
			webActionUtil.elementClick(getMinusIcon());
		}
	}*/
	
	public void changeQuantity(int quantity, boolean increase) {
		WebElement ele;
		
		if(increase) {
			ele=getPlusIcon();
		} else {
			ele=getMinusIcon();
		}
		
		for(int i=1;i<=quantity;i++) {
			webActionUtil.elementClick(ele);
		}
	}
	
	public void clickOnColor(String colorName) {
		for(WebElement ele:getColorPickerList()) {
			if(ele.getAttribute("name").equalsIgnoreCase(colorName)) {
				webActionUtil.elementClick(ele);
				break;
			}
		}
	}
	
	public OrderDetailsPage addItemToCart(int quantityToIncrease,
							  int quantityToDecrease,
							  String sizeText,
							  String colorName) {
		changeQuantity(quantityToIncrease, true);
		changeQuantity(quantityToDecrease, false);
		webActionUtil.selectVisibleText(sizeListBox, sizeText);
		clickOnColor(colorName);
		webActionUtil.elementClick(getAddToCartButton());
		webActionUtil.elementClick(getProceedToCheckoutButton());
		return new OrderDetailsPage(driver, webActionUtil);
	}
}
