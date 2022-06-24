package by.it.academy.Md_AT1.hw3.servise;

import by.it.academy.Md_AT1.hw3.dto.Account;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import static by.it.academy.Md_AT1.hw3.query.CurrencyQueryExecutor.isCurrencyExist;
import static by.it.academy.Md_AT1.hw3.query.UserQueryExecutor.isUserExist;

public class CreateAccount {

    /**
     * Метод создает новый аккаунт пользователя
     * @param connection
     * @return объект класса Account
     * @throws SQLException
     */
    public static Account createUserAccount(Connection connection) throws SQLException {
        Account accountTest = new Account();
        Scanner scanner = new Scanner(System.in);
        BigDecimal maxBalance = new BigDecimal(2_000_000_000);

        boolean valid = true;
        do {
            try{
                System.out.println("Enter user's ID");
                int id = scanner.nextInt();
                System.out.println("Enter user's currency. Choose : dol, euro, rub, yuan");
                String currency = scanner.next();
                if (isUserExist(connection, id) && !isCurrencyExist(connection, id, currency)) {
                    accountTest.setUserID(id);
                    accountTest.setCurrency(currency);
                    System.out.println("Enter user's balance");
                    BigDecimal balance = scanner.nextBigDecimal();
                    while (balance.compareTo(maxBalance) > 0) {
                        System.out.println("Incorrect sum. Try again");
                        balance = scanner.nextBigDecimal();
                    }
                    accountTest.setBalance(balance.setScale(3, RoundingMode.DOWN));
                    System.out.println("New account was created " + accountTest.toString());
                    return accountTest;
                }
            }catch (Exception e) {
                System.out.println("Invalid data, Try again");
                if (scanner.hasNextLine()) {
                    scanner.nextLine();
                }
            }
        }while (!valid);
        return null;
    }
}

