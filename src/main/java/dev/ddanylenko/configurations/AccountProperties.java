package dev.ddanylenko.configurations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AccountProperties {
    private final double defaultAmount;
    private final double defaultCommission;

    public AccountProperties(@Value("${account.default-amount}") double defaultAmount,
                             @Value("${account.transfer-commission}") double defaultCommission) {
        this.defaultAmount = defaultAmount;
        this.defaultCommission = defaultCommission;
    }

    public double getDefaultAmount() {
        return defaultAmount;
    }

    public double getDefaultCommission() {
        return defaultCommission;
    }
}
