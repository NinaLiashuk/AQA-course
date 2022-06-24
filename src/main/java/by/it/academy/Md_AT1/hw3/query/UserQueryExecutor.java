package by.it.academy.Md_AT1.hw3.query;

import by.it.academy.Md_AT1.hw3.dto.User;

import java.sql.*;

import static java.lang.String.format;

public class UserQueryExecutor {

    /**
     * Метод проверяет, существует ли в таблице Users пользователь
     * @param connection
     * @param idFromConsole
     * @return boolean
     * @throws SQLException
     */
    public static boolean isUserExist(Connection connection, int idFromConsole) throws SQLException {
        PreparedStatement statement =
                connection.prepareStatement("SELECT * FROM Users WHERE userID = " + idFromConsole);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            return true;
        }
        System.out.println("That user is not exists");
        resultSet.close();
        statement.close();
        return false;
    }

    /**
     * Метод показывает всех пользователей из таблицы Users
     * @param connection
     * @throws SQLException
     */
    public static void showAllUsers (Connection connection) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM Users;");
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            System.out.println('\n' + "userID " + resultSet.getInt("userID"));
            System.out.println("userName " + resultSet.getString("name"));
            System.out.println("userAddress " + resultSet.getString("address") + '\n');
        }
        resultSet.close();
        statement.close();
    }

    /**
     * Метод добавляет пользователя в таблицу Users
     * @param user
     * @param connection
     * @throws SQLException
     */
    public static void addNewUser(User user, Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate(format("INSERT INTO Users (name, address) VALUES ('%s', '%s')", user.getUserName(),
                user.getUserAddress()));
        System.out.println(user.toString());
        statement.close();
    }
}
