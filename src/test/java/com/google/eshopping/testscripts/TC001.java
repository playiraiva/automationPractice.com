package com.google.eshopping.testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.eshopping.generic.ExcelLibrary;
import com.google.eshopping.pages.OrderDetailsPage;
import com.google.eshopping.pages.ProductDetailsPage;
import com.google.eshopping.pages.ProductsListPage;

public class TC001 extends BaseTest {
	@Test(description="Verify Whether the Product Added is Displayed in ODP")
	public void testProductIsDisplayedInODP() {
		String sheetName = "TC001";
		String menuName=ExcelLibrary.getStringData(XL_PATH, sheetName, 1, 0);
		int productId=(int)(double)ExcelLibrary.getNumericData(XL_PATH, sheetName, 1, 1);
		int quantityToIncrease = (int)(double)ExcelLibrary.getNumericData(XL_PATH, sheetName, 1, 2);
		int quantityToDecrease = (int)(double)ExcelLibrary.getNumericData(XL_PATH, sheetName, 1, 3);
		String sizeText = ExcelLibrary.getStringData(XL_PATH, sheetName, 1, 4);
		String colorName = ExcelLibrary.getStringData(XL_PATH, sheetName, 1, 5);
		
		ProductsListPage productsListPage = homePage.clickOnMenu(menuName);
		ProductDetailsPage prductDetailsPage = productsListPage.clickOnProduct(productId);
		OrderDetailsPage orderDetailsPage = prductDetailsPage.addItemToCart(quantityToIncrease, quantityToDecrease, sizeText, colorName);
		Assert.assertEquals(orderDetailsPage.isProductDisplayed(productId), false);
	}
}
