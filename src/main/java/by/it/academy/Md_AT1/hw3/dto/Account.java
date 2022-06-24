package by.it.academy.Md_AT1.hw3.dto;

import java.math.BigDecimal;

public class Account {
    private int accountID;
    private int userID;
    private BigDecimal balance;
    private String currency;

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountID=" + accountID +
                ", userID=" + userID +
                ", balance=" + balance +
                ", currency=" + currency +
                '}';
    }
}
