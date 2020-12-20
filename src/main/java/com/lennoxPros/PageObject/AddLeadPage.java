package com.lennoxPros.PageObject;

import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.lennoxPros.BaseUtilis.BasePage;

public class AddLeadPage extends BasePage {

	@FindBy(xpath = "//input[@id='firstName']")
	private WebElement firstname;

	@FindBy(xpath = "//input[@id='lastName']")
	private WebElement lastname;
	@FindBy(id = "phNo")
	private WebElement phno;
	@FindBy(id = "email")
	private WebElement email;
	@FindBy(id = "calender1")
	private WebElement requestDate;
	@FindBy(xpath = "//div[@class='time-select schedul-req-time']")
	private WebElement requestTime;

	@FindBy(xpath = "//a[@class='btn btn-primary hide-mobile introjs-l-9 introjs-l-83']")
	private WebElement addLead;

	@FindBy(xpath = "//div[@class='leads-uploads-add']/div[ @class='leads-uploads-add-icon']")
	private WebElement addDoc;

	@FindBy(xpath = "//select[@class='styled-select documents']/ancestor::div[@class='row align-items-center mb-30 custom-row']")
	private WebElement docType;
	@FindBy(xpath = "//a[@class='btn btn-primary mr-15 add-documents-to-page mb-15']")
	private WebElement addToLead;
	@FindBy(xpath = "//div[@class='lead-details-header']//div[@class='lead-details-header-name stronger']")
	private WebElement success;

	public AddLeadPage() {
		PageFactory.initElements(driver.get(), this);
	}

	public void addLead() {
		addLead.click();
	}

	public void addLeadDetaila() {
		firstname.sendKeys(firstNam);
		lastname.sendKeys(lastName);
		;
		phno.sendKeys(phoneNo);
		email.sendKeys(eMail);
		requestDate.sendKeys(dateVal);
		requestTime.sendKeys(schtime);

	}

	public void addDocument() {
		addDoc.click();
	}

	public void handlingDocuments() {
		String current_Window=driver.get().getWindowHandle();
		Set<String> window=driver.get().getWindowHandles();
		for(String win:window) {
			driver.get().switchTo().window(win);
			Select s=new Select(docType);
			s.selectByIndex(1);
			
		}}

	public String getHeaderMessage1() {
		String message = success.getText();
		return message;
	}

}
