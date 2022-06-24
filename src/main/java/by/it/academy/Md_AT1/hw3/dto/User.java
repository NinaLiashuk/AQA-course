package by.it.academy.Md_AT1.hw3.dto;

public class User {
    private int UserID;
    private String UserName;
    private String UserAddress;

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getUserAddress() {return UserAddress;}

    public void setUserAddress(String userAddress) {
        UserAddress = userAddress;
    }

    @Override
    public String toString() {
        return "User{" +
                "UserID=" + UserID +
                ", UserName='" + UserName +
                ", UserAddress='" + UserAddress +
                '}';
    }
}
