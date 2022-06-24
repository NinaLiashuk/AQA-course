package by.it.academy.Md_AT1.hw3.util;

import by.it.academy.Md_AT1.hw3.dto.Account;
import by.it.academy.Md_AT1.hw3.dto.Transaction;
import by.it.academy.Md_AT1.hw3.dto.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import static by.it.academy.Md_AT1.hw3.query.AccountQueryExecutor.addUserAccount;
import static by.it.academy.Md_AT1.hw3.query.AccountQueryExecutor.showAllAccounts;
import static by.it.academy.Md_AT1.hw3.query.BalanceQueryExecutor.changeBalance;
import static by.it.academy.Md_AT1.hw3.query.TransactionQueryExecutor.addTransaction;
import static by.it.academy.Md_AT1.hw3.query.UserQueryExecutor.addNewUser;
import static by.it.academy.Md_AT1.hw3.query.UserQueryExecutor.showAllUsers;
import static by.it.academy.Md_AT1.hw3.servise.CreateAccount.createUserAccount;
import static by.it.academy.Md_AT1.hw3.servise.CreateTransaction.createTransactionAddition;
import static by.it.academy.Md_AT1.hw3.servise.CreateTransaction.createTransactionWithdraw;
import static by.it.academy.Md_AT1.hw3.servise.CreateUser.createUser;

public class ConsoleMenu {

    private static final String JDBC_DRIVER_PATH = "org.sqlite.JDBC";
    private static final String DATABASE_URL = "jdbc:sqlite:c:\\Users\\user\\IdeaProjects\\AutoTest\\DBforHW3.db";

    /**
     * Метод служит для выбора операции с консоли и вызова соответствующих методов
     * @param connection
     * @param scanner
     * @throws SQLException
     */
    public static void chooseOperation(Connection connection, Scanner scanner) throws SQLException {
        if (isDriverExists()){
            connection = DriverManager.getConnection(DATABASE_URL);
            String actionCode;
            do {
                printMenu();
                actionCode = new Scanner(System.in).nextLine();
                switch (actionCode) {
                    case "1":
                        User user = createUser();
                        addNewUser(user, connection);
                        break;
                    case "2":
                        Account accountTest = createUserAccount(connection);
                        if(accountTest != null){
                            addUserAccount(accountTest, connection);
                        }
                        break;
                    case "3":
                        Transaction transactionAdd = createTransactionAddition(connection);
                        if (transactionAdd != null){
                            addTransaction (transactionAdd, connection);
                            changeBalance (transactionAdd, connection);
                        }
                        break;
                    case "4":
                        Transaction transactionSub = createTransactionWithdraw(connection);
                        if(transactionSub != null){
                            addTransaction (transactionSub, connection);
                            changeBalance (transactionSub, connection);
                        }
                        break;
                    case "5":
                        showAllUsers(connection);
                        break;
                    case "6":
                        showAllAccounts(connection);
                        break;
                    case "7":
                        System.out.println("Thanks for using the program!");
                        break;
                    default:
                        System.out.println("Unknown option. Please enter again");
                }

            } while (!"7".equals(actionCode));
            connection.close();
        }
    }

    private static boolean isDriverExists(){
        try{
            Class.forName(JDBC_DRIVER_PATH);
        }catch (ClassNotFoundException e){
            System.out.println("JDBC Driver not found");
            return false;
        }
        return true;
    }

    /**
     * Метод выводит в консоль пользовательское меню
     */
    public static void printMenu() {
        System.out.println("\nPlease select an action");
        System.out.println("1 - add user");
        System.out.println("2 - add account");
        System.out.println("3 - add money");
        System.out.println("4 - withdraw money");
        System.out.println("5 - show all users");
        System.out.println("6 - show all accounts");
        System.out.println("7 - quit\n");
    }
}
