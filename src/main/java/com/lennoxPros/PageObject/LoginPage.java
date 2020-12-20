package com.lennoxPros.PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.lennoxPros.BaseUtilis.BasePage;

public class LoginPage extends BasePage
{
	
	@FindBy(xpath = "//a[@class='login-link btn NEEDS_AUTHENTICATION']")
	private WebElement signIn;
	
	@FindBy(xpath="//button[@class='btn lp-nav-toggle']/parent::div[@class='login-div']")
	private WebElement welcomePage;
	
	@FindBy(xpath = "//input[@id='j_username']")
	private WebElement userId;
	@FindBy(xpath = "//input[@id='j_password']")
	private WebElement password;
	@FindBy(xpath = "//button[@id='loginSubmit']")
	private WebElement signInButton;
	
	@FindBy(xpath = "//div[@class='gor-navigation pull-left gor-menu-container v2-hmaburger-menu-container']")
	private WebElement menu;
	
	@FindBy(xpath = "//a[@class='btn-v2']/parent::div[@class='parent level-0 primary-nav-CommercialTopToolsCatalogNode-4 current-selected-item']")
	private WebElement sales_tool;

	@FindBy(xpath = "//a[text()='Build a Proposal']")
	private WebElement build_a_Proposal;
	@FindBy(xpath = "//div[@class='button-set']/a[text()='SELECT LEAD']")
	private WebElement select_lead;

	public LoginPage() {
		PageFactory.initElements(driver.get(), this);
	}
	
	public void navigate_to_signIn() {
		signIn.click();
	}
	public void login_to_Application() {
		userId.sendKeys(user);
		password.sendKeys(pass);
		signInButton.click();
		
	}
	public String getWelcomeMessage() {
		return welcomePage.getText();
	}
	
	public void clickMenu() {
		menu.click();
	}
	public void clickSalesTool() {
		sales_tool.click();
		mouseMoveAction(build_a_Proposal);
	}
	public void clickSelectLead() {
		windowHandling(select_lead);
	}
	
}
