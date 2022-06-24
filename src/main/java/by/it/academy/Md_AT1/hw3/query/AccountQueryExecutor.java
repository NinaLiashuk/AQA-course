package by.it.academy.Md_AT1.hw3.query;

import by.it.academy.Md_AT1.hw3.dto.Account;

import java.sql.*;

import static java.lang.String.format;

public class AccountQueryExecutor{

    /**
     * Метод проверяет, существует ли в таблице Accounts аккаунт пользователя
     * @param connection
     * @param accountID
     * @return boolean
     * @throws SQLException
     */
    public static boolean isAccountExist (Connection connection, int accountID) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM Accounts WHERE accountID = " + accountID);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            return true;
        }
        System.out.println("Account is not found");
        return false;
    }

    /**
     * Метод показывает все аккаунты из таблицы Accounts
     * @param connection
     * @throws SQLException
     */

    public static void showAllAccounts(Connection connection) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM Accounts");
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            System.out.println('\n' + "AccountID " + resultSet.getInt("accountID"));
            System.out.println("UserID " + resultSet.getInt("userID"));
            System.out.println("Balance " + resultSet.getInt("balance"));
            System.out.println("Currency " + resultSet.getString("currency") + '\n');
        }
        resultSet.close();
        statement.close();
    }

    /**
     * Метод добавляет аккаунт в таблицу Accounts
     * @param accountTest
     * @param connection
     * @throws SQLException
     */
    public static void addUserAccount(Account accountTest, Connection connection) throws SQLException{
        Statement statement = connection.createStatement();
        statement.executeUpdate(format("INSERT INTO Accounts (userID, balance, currency) VALUES (%d, '%s', '%s')", accountTest.getUserID(),
                accountTest.getBalance(), accountTest.getCurrency()));
        System.out.println(accountTest.toString());
        statement.close();
    }
}
