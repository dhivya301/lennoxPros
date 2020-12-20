package steps;

import org.junit.Assert;

import com.lennoxPros.BaseUtilis.BasePage;
import com.lennoxPros.PageObject.AddLeadPage;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddLeadSteps {

	BasePage bp;
	AddLeadPage ap;
	
	 public AddLeadSteps() {
		// TODO Auto-generated constructor stub
		 bp=new BasePage();
		 ap=new AddLeadPage();
	}
	@Given("^navitage to the add Lead page$")
	public void navitage_to_the_add_Lead_page()  {
		ap.addLead();
	   
	}

	@When("^user is entering the required fields$")
	public void user_is_entering_the_required_fields()  {
		ap.addLeadDetaila();
		ap.addDocument();
		ap.handlingDocuments();
		
	    
	}

	@Then("^user is able to add successfully$")
	public void user_is_able_to_add_successfully() {
		String header="CHITRA D";
		Assert.assertTrue(header.equals(ap.getHeaderMessage1()));
	    
	}


}
