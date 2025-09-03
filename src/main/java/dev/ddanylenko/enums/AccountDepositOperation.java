package dev.ddanylenko.enums;

import org.springframework.stereotype.Component;

@Component
public class AccountDepositOperation implements OperationCommand {
    @Override
    public void execute() {

    }

    @Override
    public OperationType getOperationType() {
        return OperationType.ACCOUNT_DEPOSIT;
    }
}
