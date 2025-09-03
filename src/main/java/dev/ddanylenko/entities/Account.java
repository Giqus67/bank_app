package dev.ddanylenko.entities;

import dev.ddanylenko.configurations.AccountProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

public class Account {

    public static long idCounter = 1;

    private final long id;

    private final long userId;

    private double moneyAmount;

    public Account(long userId, double moneyAmount) {
        this.id = idCounter++;
        this.userId = userId;
        this.moneyAmount = moneyAmount;
    }

    public void setMoneyAmount(double moneyAmount) {
        this.moneyAmount = moneyAmount;
    }

    public static long getIdCounter() {
        return idCounter;
    }

    public long getId() {
        return id;
    }

    public long getUserId() {
        return userId;
    }

    public double getMoneyAmount() {
        return moneyAmount;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", userId=" + userId +
                ", moneyAmount=" + moneyAmount +
                '}';
    }
}
