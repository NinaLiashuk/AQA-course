package by.it.academy.Md_AT1.hw3.query;

import by.it.academy.Md_AT1.hw3.dto.Transaction;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import static java.lang.String.format;

public class TransactionQueryExecutor {

    /**
     * Метод добавляет новую транзакцию в таблицу Transactions
     * @param transaction
     * @param connection
     * @throws SQLException
     */
    public static void addTransaction (Transaction transaction, Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate(format("INSERT INTO Transactions (accountID, amount) VALUES (%d, '%s')",
                transaction.getAccountID(), transaction.getAmount()));
        System.out.println("Transaction was added successfully" + transaction.toString());
        statement.close();
    }
}
