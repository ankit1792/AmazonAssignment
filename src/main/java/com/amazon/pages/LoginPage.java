package com.amazon.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.amazon.utils.JsonParser;

public class LoginPage extends BasePage{
	
	@FindBy(id="ap_email")
	WebElement txtbox_username;
	
	@FindBy(xpath="//span[contains(text(),'Continue')]/..")
	WebElement btn_continue;
	
	@FindBy(id="ap_password")
	WebElement txtbox_password;
	
//	@FindBy(xpath="//span[contains(text(),'Login')]/..")
	
	@FindBy(id="signInSubmit")
	WebElement btn_login;
	
	
	public HomePage loginToWebsite() throws IOException {
		sendkeys(txtbox_username,JsonParser.getValue("config.global.username"));
		click(btn_continue);
		sendkeys(txtbox_password, JsonParser.getValue("config.global.password"));
		click(btn_login);
		return new HomePage();
	}
	
}
