package Homeworks.HW9.Bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Bank {

    private final int moneySupply;
    private final int atmsCount;
    private final int usersCount;

    private int atmDefaultBalanceLimit = 1000;
    private int userDefaultBalanceLimit = 100;

    private List<ATM> atmList;
    private List<User> userList;

    public Bank(int moneySupply, int atmsCount, int usersCount) {
        this.moneySupply = moneySupply;
        this.atmsCount = atmsCount;
        this.usersCount = usersCount;

        createAtms();
        createUsers();

        System.out.println("Money supply: " + moneySupply);
    }

    private void createAtms() {
        atmList = new ArrayList<>();
        for (int i = 0; i < atmsCount; i++) {
            int balance = new Random().nextInt(atmDefaultBalanceLimit);
            atmList.add(new ATM(i, balance));
            System.out.println("Created new ATM with id " + i + " and balance " + balance);
        }
    }

    private void createUsers() {
        userList = new ArrayList<>();
        for (int i = 0; i < usersCount; i++) {
            int balance = new Random().nextInt(userDefaultBalanceLimit);
            userList.add(new User(i, balance));
            System.out.println("Created new User with id: " + i + " and balance " + balance);
        }
    }

    public void makeOperations(int count) {
        for (int i = 0; i < count; i++) {
            makeRandomOperation();
        }
    }

    private void makeRandomOperation() {

    }
}