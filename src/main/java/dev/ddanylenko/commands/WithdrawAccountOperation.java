package dev.ddanylenko.commands;

import dev.ddanylenko.enums.OperationCommand;
import dev.ddanylenko.enums.OperationType;
import dev.ddanylenko.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WithdrawAccountOperation implements OperationCommand {

    private final AccountService accountService;

    @Autowired
    public WithdrawAccountOperation(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public void execute() {
        long accountId = 1;
        double amount = 1;
        accountService.accountWithdraw(accountId, amount);
    }

    @Override
    public OperationType getOperationType() {
        return OperationType.ACCOUNT_WITHDRAW;
    }


    public void askArguments() {

    }
}
