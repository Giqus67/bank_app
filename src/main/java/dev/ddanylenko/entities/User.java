package dev.ddanylenko.entities;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

public class User {

    public static long idCounter = 1;

    private final long id;

    private final String login;

    private List<Account> accountList = new ArrayList<>();


    public User(String login) {
        this.id = idCounter++;
        this.login = login;
    }

    public long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", accountList=" + accountList +
                '}';
    }
}
