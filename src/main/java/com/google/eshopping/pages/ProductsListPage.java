package com.google.eshopping.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.google.eshopping.generic.WebActionUtil;

public class ProductsListPage extends BasePage {
	
	@FindBy(xpath="//a[@class='product_img_link']")
	private List<WebElement> productsList;
		
	public List<WebElement> getProductsList() {
		return productsList;
	}

	public ProductsListPage(WebDriver driver, WebActionUtil webActionUtil) {
		super(driver, webActionUtil);
	}
	
	public ProductDetailsPage clickOnProduct(int productId) {
		String pid = "id_product="+productId;
		for(WebElement ele:getProductsList()) {
			if(ele.getAttribute("href").contains(pid)) {
				webActionUtil.jsClick(ele);
				break;
			}
		}
		return new ProductDetailsPage(driver, webActionUtil);
	}
}
