package com.zuehlke.testing.cucumber.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class StepDefinitions {

    private Account account;

    @Given("account balance is {double}")
    public void givenAccountBalance(Double initialBalance) {
        account = new Account(initialBalance);
    }

    @When("the account is credited with {double}")
    public void the_account_is_credited_with(Double credit) {
        account.credit(credit);
    }

    @Then("account should have a balance of {double}")
    public void account_should_have_a_balance_of(Double value) {
        assertThat(account.getBalance()).isEqualTo(value);
    }

}