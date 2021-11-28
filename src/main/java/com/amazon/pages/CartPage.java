package com.amazon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {

	@FindBy(xpath="//a[contains(text(),'Proceed to Buy')]")
	WebElement btn_proceedtobuy;


	@FindBy(xpath="//span[contains(text(),'Proceed to checkout')]")
	WebElement proceedToCheckout;




	public PaymentPage proceedToCheckout()
	{
		
		clickUsingJavaScriptExecutor(proceedToCheckout);
		
		switchToNewWindow();

		return new PaymentPage();
	}

 /*	
	public PaymentPage clickProceedToPay() 
	{

		click(btn_proceedtobuy);
		return new PaymentPage();
	}

 */	
}
