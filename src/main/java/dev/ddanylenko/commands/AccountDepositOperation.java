package dev.ddanylenko.commands;

import dev.ddanylenko.enums.OperationCommand;
import dev.ddanylenko.enums.OperationType;
import dev.ddanylenko.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountDepositOperation implements OperationCommand {

    private final AccountService accountService;

    @Autowired
    public AccountDepositOperation(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public void execute() {
        long accountId = (long) 1;
        double amount = (double) 1;
        accountService.deposit(accountId, amount);
    }

    @Override
    public OperationType getOperationType() {
        return OperationType.ACCOUNT_DEPOSIT;
    }

    public void askArguments() {

    }
}
