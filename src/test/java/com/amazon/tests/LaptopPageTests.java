package com.amazon.tests;

import java.io.IOException;

import org.testng.annotations.Test;

import com.amazon.pages.CartPage;
import com.amazon.pages.HamburgerMenuPage;
import com.amazon.pages.HomePage;
import com.amazon.pages.LaptopPage;
import com.amazon.pages.LoginPage;
import com.amazon.pages.PaymentPage;
import com.amazon.pages.ProductDetailsPage;




public class LaptopPageTests extends BaseTest{
	
	HomePage homepage;
	LoginPage loginpage;
	HamburgerMenuPage hamburgerpage;
	LaptopPage laptoppage;
	ProductDetailsPage pdpage;
	CartPage cartpage;
	PaymentPage paymentpage;
	
	@Test(description="Check the apple laptop with 5 star ratings and high cost and store the product details to excel sheet")
	public void TC01() throws IOException, Exception 
	{
		homepage=new HomePage();
		
		loginpage=homepage.clickSignOnHomePage();
		
		homepage=loginpage.loginToWebsite();
		
		hamburgerpage=homepage.clickHamburgerMenu();
		
	//	laptoppage=hamburgerpage.clickOnMobileComputers().clickOnLaptops();
		
		hamburgerpage=hamburgerpage.clickOnMobileComputers();   // 1
		
		laptoppage =hamburgerpage.clickOnLaptops();             // 2
		
		pdpage=laptoppage.applyAppleFilter().applyHighToLowPriceFilter().findCostliestFiveStarRatedAppleLaptop();
		
		cartpage=pdpage.readProductInfo().chooseQty("3").clickAddToCart();
		
		paymentpage = cartpage.proceedToCheckout();
		
	//	cartpage.clickProceedToPay();
		
	}

}
