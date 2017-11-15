package com.belatrix.connect.steps;

import com.belatrix.connect.framework.ParentScenario;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

public class ManageEventBelaSteps extends ParentScenario {

    @Given("^I not confirm me in the event '(.*?)'$")
    public void I_not_confirm_me_in_the_event(String eventName) throws Throwable {
        startAndroid();
        loginPage.takingSessionActivity();
        System.out.println("La aplicacion se inicio correctamente");
        loginPage.loginOnApp("ejeronimo", "123456");
        mainProfilePage.clickEventsTab();
        manageEventBelaPage.searchEventByName(eventName);
        SetInitialStateToUnRegistered();
    }

    @Given("^I am already register in to the event '(.*?)'$")
    public void I_am_already_register_in_to_the_event(String eventName) throws Throwable {
        startAndroid();
        loginPage.takingSessionActivity();
        System.out.println("La aplicacion se inicio correctamente");
        loginPage.loginOnApp("ejeronimo", "123456");
        mainProfilePage.clickEventsTab();
        manageEventBelaPage.searchEventByName(eventName);
        SetInitialStateToRegistered();
    }

    @When("^I try to confirm my register$")
    public void I_try_to_confirm_my_register() throws Throwable {
        manageEventBelaPage.RegisterUser();
        alertMessageTwoOptions.waitForAlertMessage("Do you want register this event?");
        alertMessageTwoOptions.answerYes();
        manageEventBelaPage.waitElement();
    }

    @When("^I try to unregister me$")
    public void I_try_to_unregister_me() throws Throwable {
        manageEventBelaPage.RegisterUser();
        alertMessageTwoOptions.waitForAlertMessage("Do you want unregister this event?");
        alertMessageTwoOptions.answerYes();
        manageEventBelaPage.waitElement();
    }

    @Then("^the app send a confirmation message '(.*?)'$")
    public void the_app_send_a_confirmation_message(String message) throws Throwable {
        String status = manageEventBelaPage.getStatus();
        Assert.assertEquals(status, message);
    }

    private void SetInitialStateToRegistered() {
        if (manageEventBelaPage.getStatus() == "Register") {
            manageEventBelaPage.RegisterUser();
            alertMessageTwoOptions.waitForAlertMessage("Do you want register this event?");
            alertMessageTwoOptions.answerYes();
            manageEventBelaPage.waitElement();
        }
    }

    private void SetInitialStateToUnRegistered() {
        if (manageEventBelaPage.getStatus() == "Registered") {
            manageEventBelaPage.RegisterUser();
            alertMessageTwoOptions.waitForAlertMessage("Do you want unregister this event?");
            alertMessageTwoOptions.answerYes();
            manageEventBelaPage.waitElement();
        }
    }
}
