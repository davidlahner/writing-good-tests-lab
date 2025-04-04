package com.zuehlke.testing.cucumber.example;

public class Account {
    private double balance;

    public Account(double initialBalance) {
        this.balance = initialBalance;
    }

    public Double getBalance() {
        return balance;
    }

    public void credit(double credit) {
        this.balance += credit;
    }
}
