package pkg_stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.But;
import org.testng.Assert;
import pkg_global.GlobalObjects;

public class ParaBank_StepDef extends GlobalObjects {

    @Given("User is in on home page")
    public void user_is_in_on_home_page() {
        pgHome.NavigateHome();
        pgHome.ValidateLoginElements();
    }


    @When("User validates main menu items")
    public void user_validates_main_menu_items() {
        pgHome.ValidateMainMenuItems();
    }
    @When("Main menu item validation should be successful")
    public void main_menu_item_validation_should_be_successful() {
        if(!pgHome.mainMenuItemsCheck){
            Assert.fail("Log: Main menu item validation failed");
        }
    }

    @And("User validates welcome section items")
    public void user_validates_welcome_section_items() {
        pgHome.ValidateWelcomeSectionElements();
    }
    @Then("Welcome section item validation should be successful")
    public void welcome_section_item_validation_should_be_successful() {
        if(!pgHome.mainMenuItemsCheck){
            Assert.fail("Log: Welcome menu item validation failed");
        }
    }

    @When("User perform registration")
    public void user_perform_registration() {
        pgHome.NavigateRegistration();
        pgRegister.RegistrationInit();
    }
    @Then("Registration should be successful")
    public void registration_should_be_successful() {
        if(!pgRegister.registerSuccess){
            Assert.fail("Log: Registration failed");
        }
    }
    @But("Account opening should not be successful")
    public void account_opening_should_not_be_successful() {
        if(pgOpenNewAccount.accountOpenSuccess){
            Assert.fail("Log: Account opened without user intention!");
        }
    }


    @Given("User registration is successful")
    public void user_registration_is_successful() {
        pgHome.NavigateHome();
        pgHome.NavigateRegistration();
        pgRegister.RegistrationInit();
    }

    @When("User initiate New Account Opening")
    public void user_initiate_new_account_opening() {
        pgOpenNewAccount.OpenNewAccount();
    }
    @Then("New Account Opening should be successful")
    public void new_account_opening_should_be_successful() {
        pgOpenNewAccount.NewAccountValidation();
    }

    @And("User initiate Fund Transfer {string}")
    public void user_initiate_fund_transfer(String transferAmount) {
        pgOpenNewAccount.InitFundTransfer(transferAmount);
    }
    @Then("Fund Transfer should be successful")
    public void fund_transfer_should_be_successful() {
        pgOpenNewAccount.FundTransferValidation();
    }

}

