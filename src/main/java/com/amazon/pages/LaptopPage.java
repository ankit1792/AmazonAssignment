package com.amazon.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import com.amazon.browser.DriverManager;

public class LaptopPage extends BasePage{
	
	
//	@FindBy(name="s-ref-checkbox-Apple")
	
	@FindBy(xpath="//li//span[contains(text(),'Apple')]//parent::a//descendant::label//input[@type='checkbox']")
	WebElement checkbox_apple;
	
	
	@FindBy(xpath="//span[contains(text(),'Sort by:')]")
	WebElement btn_sortby;
	
	@FindBy(xpath="//li/a[contains(text(),'Price: High to Low')]")
	WebElement lnk_pricehightolow;
	
	
	
//	public String searchresults="//span[@cel_widget_id='SEARCH_RESULTS-SEARCH_RESULTS']//div[@class='s-include-content-margin s-border-bottom']//span[contains(@aria-label,'out of 5 stars')]";
	
	public String searchResults = "//div[@class='a-section a-spacing-medium']//div[@class='a-section a-spacing-none']//div/span[contains(@aria-label,'out of 5 stars')]";
	
	public ProductDetailsPage findCostliestFiveStarRatedAppleLaptop() throws InterruptedException {
		
		
		List<WebElement> webelements = DriverManager.getDriver().findElements(By.xpath(searchResults));
		
		for(int i=0;i<webelements.size();i++) 
		{
			
			String temp=webelements.get(i).getAttribute("aria-label");
			
			System.out.println(temp);
			
			if(temp.contains("4.7")) 
			{
				click(By.xpath("//div[@data-index='"+i+"']//h2/a"));
				
				System.out.println("success");
				
				break;
			}
		}
		switchToNewWindow();
		return new ProductDetailsPage();
	}
	
	public LaptopPage applyAppleFilter() 
	{
		clickUsingJavaScriptExecutor(checkbox_apple);
		return this;
	}
	
	public LaptopPage applyHighToLowPriceFilter() 
	{
		click(btn_sortby);
		click(lnk_pricehightolow);
		return this;
	}

}
