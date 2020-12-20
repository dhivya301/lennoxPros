package steps;

import java.io.IOException;

import org.junit.Assert;

import com.lennoxPros.BaseUtilis.BasePage;
import com.lennoxPros.PageObject.LoginPage;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class LoginSteps {
	
	BasePage bp;
	LoginPage lp;
	
	 public LoginSteps() {
		
		bp=new BasePage();
		lp=new LoginPage();
	}
	
	@Given("^navigate to application$")
	public void navigate_to_application() throws IOException  {
		bp.setUp();
		lp.navigate_to_signIn();
		bp.captureScreenShot( "SignInPage");
		
		
	    
	}

	@When("^User is entering the username and password$")
	public void user_is_entering_the_username_and_password() throws IOException  {
		lp.login_to_Application();
	    bp.captureScreenShot("HomePage");
	    
	}

	@Then("^navigate to the home page of an application$")
	public void navigate_to_the_home_page_of_an_application()  {
		String message="\r\n" + 
	    		"					Welcome, ";
	    Assert.assertEquals(message, lp.getWelcomeMessage());
	   
	}

	@Then("^Select the sales tools from the menu$")
	public void select_the_sales_tools_from_the_menu() {
		lp.clickMenu();
		lp.clickSalesTool();
	}

	@Then("^Click on the Select Lead$")
	public void click_on_the_Select_Lead()  {
		lp.clickSelectLead();
		String title="\r\n" + 
				"        LennoxPROs.com";
		Assert.assertTrue(title.equals(bp.getPageTitle()));
	    
	}



}
