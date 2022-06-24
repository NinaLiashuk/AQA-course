package by.it.academy.Md_AT1.hw3.servise;

import by.it.academy.Md_AT1.hw3.dto.User;

import java.util.Scanner;

public class CreateUser {

    /**
     * Метод создает нового пользователя
     * @return объект класса User
     */

    public static User createUser(){
        User user = new User();
        Scanner scanner = new Scanner(System.in);
        boolean valid = true;
        do{
            try {
                System.out.println("Enter user's name");
                String name = scanner.nextLine();
                while (!isUserNameValid(name)){
                    name = scanner.nextLine();
                }
                user.setUserName(name);
                System.out.println("Enter user's address");
                user.setUserAddress(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid data, Try again");
                if (scanner.hasNextLine()) {
                    scanner.nextLine();
                }
            }
        }while (!valid);
        return user;
    }

    /**
     * Метод проверяет валидность введенного имени
     * @param userName
     * @return
     */
    public static boolean isUserNameValid(String userName){
        String redex = "([A-z]||[А-я])*";
        if (userName.isEmpty()) {
            System.out.println("Is empty");
            return false;
        }
        if (userName.matches(redex)){
            return true;
        }
        System.out.println("Accept only cyrillic and latin letters without any gaps");
        return false;
    }
}

