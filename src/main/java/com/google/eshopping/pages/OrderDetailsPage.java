package com.google.eshopping.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.google.eshopping.generic.WebActionUtil;
//id_product=6
public class OrderDetailsPage extends BasePage {
	
	String productdeleteIconXPath = "//td[@class='cart_product']/a[contains(@href,'productId')]/../following-sibling::td[@data-title='Delete']//i[@class='icon-trash']";
	
	@FindBy(xpath="//td[@class='cart_product']/a")
	private List<WebElement> productsList;
	
	public List<WebElement> getProductsList() {
		return productsList;
	}

	public OrderDetailsPage(WebDriver driver, WebActionUtil webActionUtil) {
		super(driver, webActionUtil);
	}
	
	public boolean isProductDisplayed(int productId) {
		String pid = "id_product="+productId;
		for(WebElement ele:getProductsList()) {
			if(ele.getAttribute("href").contains(pid)) {
				return true;
			}
		}
		return false;
	}

	public void deleteProduct(int productId) {
		String pid = "id_product="+productId;
		productdeleteIconXPath=productdeleteIconXPath.replace("productId", pid);
		webActionUtil.elementClick(driver.findElement(By.xpath(productdeleteIconXPath)));
	}
}
