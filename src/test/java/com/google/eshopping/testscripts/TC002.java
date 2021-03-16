package com.google.eshopping.testscripts;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.eshopping.generic.ExcelLibrary;
import com.google.eshopping.pages.OrderDetailsPage;
import com.google.eshopping.pages.ProductDetailsPage;
import com.google.eshopping.pages.ProductsListPage;

public class TC002 extends BaseTest {
	
	@DataProvider(name="MultipleProducts")
	public String[][] getData(){
		return ExcelLibrary.getMultipleDataInString(XL_PATH, "TC002");
	}
	
	@Test(description="Multiple Test Data", dataProvider="MultipleProducts")
	public void testMultipleProductsAddedToCart(String menuName,
												String productId,
												String increaseQuantity,
												String decreaseQuantity,
												String sizeText,
												String colorName) {
		int pid=(int)Double.parseDouble(productId);
		int increase=(int)Double.parseDouble(increaseQuantity);
		int decrease=(int)Double.parseDouble(decreaseQuantity);
		
		ProductsListPage productsListPage = homePage.clickOnMenu(menuName);
		ProductDetailsPage prdouctDetailsPage = productsListPage.clickOnProduct(pid);
		OrderDetailsPage orderDetailsPage = prdouctDetailsPage.addItemToCart(increase, decrease, sizeText, colorName);
		Assert.assertEquals(orderDetailsPage.isProductDisplayed(pid), true);
	}
}
