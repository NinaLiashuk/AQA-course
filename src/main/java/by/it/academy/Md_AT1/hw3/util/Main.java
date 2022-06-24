package by.it.academy.Md_AT1.hw3.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import static by.it.academy.Md_AT1.hw3.util.ConsoleMenu.chooseOperation;

public class Main {

    private static final String DATABASE_URL = "jdbc:sqlite:c:\\Users\\user\\IdeaProjects\\AutoTest\\DBforHW3.db";
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection(DATABASE_URL);
        Scanner scanner = new Scanner(System.in);

        chooseOperation(connection, scanner);
    }
}
