package dev.ddanylenko.commands;

import dev.ddanylenko.enums.OperationCommand;
import dev.ddanylenko.enums.OperationType;
import dev.ddanylenko.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CloseAccountOperation implements OperationCommand {

    private final AccountService accountService;

    @Autowired
    public CloseAccountOperation(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public void execute() {
        long accountId = (long) 1;
        accountService.accountClose(accountId);
    }

    @Override
    public OperationType getOperationType() {
        return OperationType.ACCOUNT_CLOSE;
    }

    public void askArguments() {

    }
}
