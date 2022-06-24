package by.it.academy.Md_AT1.hw3.query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CurrencyQueryExecutor {
    /**
     * Метод проверяет, существует ли в таблице Accounts аккаунт пользователя в заданной валюте
     * @param connection
     * @param id
     * @param currency
     * @return boolean
     * @throws SQLException
     */
    public static boolean isCurrencyExist(Connection connection, int id, String currency) throws SQLException {
        String SQL = "SELECT * FROM Accounts " +
                "WHERE userID = " + id +
                " AND currency = '" + currency + "'";
        PreparedStatement statement =
                connection.prepareStatement(SQL);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            System.out.println("Account in this currency already exists");
            return true;
        }
        return false;
    }
}
