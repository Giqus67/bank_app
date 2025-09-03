package dev.ddanylenko.entities;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Account {

    public static long idCounter = 0;

    private final long id;

    private final long userId;

    @Value("${account.default-amount}")
    private double moneyAmount;

    

    public Account(long userId) {
        this.id = idCounter++;
        this.userId = userId;
        this.moneyAmount = 0;
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
