package dev.ddanylenko.enums;

import org.springframework.stereotype.Component;

@Component
public class WithdrawAccountOperation implements OperationCommand  {
    @Override
    public void execute() {

    }

    @Override
    public OperationType getOperationType() {
        return OperationType.ACCOUNT_WITHDRAW;
    }
}
