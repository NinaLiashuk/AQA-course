package by.it.academy.Md_AT1.hw3.query;

import by.it.academy.Md_AT1.hw3.dto.Transaction;

import java.math.BigDecimal;
import java.sql.*;

import static java.lang.String.format;

public class BalanceQueryExecutor {

    /**
     * Метод получает баланс акаунта пользователя из таблицы Accounts
     * @param connection
     * @param accountID
     * @return баланс
     * @throws SQLException
     */
    public static BigDecimal getBalance(Connection connection, int accountID) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM Accounts WHERE accountID = " + accountID);
        ResultSet resultSet = statement.executeQuery();
        BigDecimal result = new BigDecimal(0);
        while (resultSet.next()) {
            result = resultSet.getBigDecimal("balance");
            return result;
        }
        System.out.println("Account is not found");
        return result;
    }

    /**
     * Метод меняет баланс пользователя в таблице Accounts
     * @param transaction
     * @param connection
     * @throws SQLException
     */
    public static void changeBalance (Transaction transaction, Connection connection)
            throws SQLException {
        Statement statement = connection.createStatement();
        BigDecimal previousBalance = new BigDecimal(String.valueOf(getBalance(connection, transaction.getAccountID())));
        BigDecimal actualBalance = previousBalance.add(transaction.getAmount());
        statement.executeUpdate(format("UPDATE Accounts SET balance = " + actualBalance + " WHERE accountID = " + transaction.getAccountID() + ";"));
        statement.close();
    }
}
