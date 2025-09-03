package dev.ddanylenko.enums;

import dev.ddanylenko.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountCreateOperation implements OperationCommand {
    private AccountService accountService;

    @Autowired
    public AccountCreateOperation(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public void execute(Object ... args) {
        long userId = (long) args[0];
        accountService.createAccount(userId);
    }

    @Override
    public OperationType getOperationType() {
        return OperationType.ACCOUNT_CREATE;
    }
}
