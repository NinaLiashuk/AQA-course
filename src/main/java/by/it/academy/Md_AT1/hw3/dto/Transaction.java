package by.it.academy.Md_AT1.hw3.dto;

import java.math.BigDecimal;

public class Transaction {
    private int transactionID;
    private int accountID;
    private BigDecimal amount;

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public int getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionID=" + transactionID +
                ", accountID=" + accountID +
                ", amount=" + amount +
                '}';
    }
}
