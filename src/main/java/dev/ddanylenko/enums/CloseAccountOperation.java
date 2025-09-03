package dev.ddanylenko.enums;

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
    public void execute(Object ... args) {
        long accountId = (long) args[0];
        accountService.accountClose(accountId);
    }

    @Override
    public OperationType getOperationType() {
        return OperationType.ACCOUNT_CLOSE;
    }
}
