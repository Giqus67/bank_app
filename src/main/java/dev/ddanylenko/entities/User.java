package dev.ddanylenko.entities;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class User {

    public static long idCounter = 0;

    private final long id;

    private final String login;

    private List<Account> accountList;


    public User(String login) {
        this.id = idCounter++;
        this.login = login;
        List<Account> accountList = new ArrayList<Account>();
        accountList.add(new Account(this.id));
        this.accountList = accountList;
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", accountList=" + accountList +
                '}';
    }
}
