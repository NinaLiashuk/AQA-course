package by.it.academy.Md_AT1.hw3.servise;

import by.it.academy.Md_AT1.hw3.dto.Transaction;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import static by.it.academy.Md_AT1.hw3.query.AccountQueryExecutor.isAccountExist;
import static by.it.academy.Md_AT1.hw3.query.BalanceQueryExecutor.getBalance;

public class CreateTransaction {

    /**
     * Метод создает транзакцию пополнения баланса в таблице Transactions
     * @param connection
     * @return объект класса Transaction
     * @throws SQLException
     */
    public static Transaction createTransactionAddition (Connection connection) throws SQLException {
        Transaction transaction = new Transaction();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter accountID");
        int accountID;
        BigDecimal balance;
        BigDecimal amount;
        BigDecimal ableAmountForAdd = new BigDecimal(100_000_000);
        boolean valid = true;
        do {
            try {
                accountID = scanner.nextInt();
                if (isAccountExist(connection, accountID)) {
                    transaction.setAccountID(accountID);
                    balance = getBalance(connection, accountID);
                    System.out.println("Your balance = " + balance + ". Max value of transaction = 100 000 000");
                    if (balance.compareTo(new BigDecimal(1_900_000_000)) == 1){
                        ableAmountForAdd = new BigDecimal(2_000_000_000).subtract(balance);
                        System.out.println("Your balance almost full. You can add no more then " + ableAmountForAdd);
                    }
                    System.out.println("Enter sum");
                    try {
                        amount = scanner.nextBigDecimal();
                        while (!(amount.compareTo(new BigDecimal(100_000_000)) <= 0 &&
                                amount.compareTo(ableAmountForAdd) <= 0)) {
                            System.out.println("Sum is too big. Try again");
                            amount = scanner.nextBigDecimal();
                        }
                        transaction.setAmount(amount.setScale(3, RoundingMode.DOWN));
                    } catch (InputMismatchException e) {
                        System.out.println("Out of the bounds");
                    }
                    System.out.println(transaction);
                    return transaction;
                } else {
                    return null;
                }
            } catch (Exception e) {
                System.out.println("Invalid data, Try again");
                if (scanner.hasNextLine()) {
                    scanner.nextLine();
                }
            }
        }while (!valid);
        return null;
    }

    /**
     * Метод создает транзакцию уменьшения баланса в таблице Transactions
     * @param connection
     * @return объект класса Transaction
     * @throws SQLException
     */
    public static Transaction createTransactionWithdraw (Connection connection) throws SQLException {
        Transaction transaction = new Transaction();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter accountID");
        int accountID;
        BigDecimal balance;
        BigDecimal amount;
        BigDecimal maxAmount = new BigDecimal(100_000_000);
        boolean valid = true;
        do {
            try {
                accountID = scanner.nextInt();
                if (isAccountExist(connection, accountID)) {
                    transaction.setAccountID(accountID);
                    balance = getBalance(connection, accountID);
                    System.out.println("Your balance = " + balance + ". Max value of transaction = 100 000 000");
                    System.out.println("Enter sum");
                    try {
                        amount = scanner.nextBigDecimal();
                        while (!(amount.compareTo(balance) <= 0 && amount.compareTo(maxAmount) <= 0)) {
                            System.out.println("Sum is too big. Try again");
                            amount = scanner.nextBigDecimal();
                        }
                        transaction.setAmount(amount.multiply(new BigDecimal(-1)).setScale(3, RoundingMode.DOWN));
                    } catch (InputMismatchException e) {
                        System.out.println("Out of the bounds");
                    }
                    System.out.println("Transaction was created: " + transaction);
                    return transaction;
                } else {
                    return null;
                }
            } catch (Exception e) {
                System.out.println("Invalid data, Try again");
                if (scanner.hasNextLine()) {
                    scanner.nextLine();
                }
            }
        } while (!valid) ;
        return null;
    }
}
