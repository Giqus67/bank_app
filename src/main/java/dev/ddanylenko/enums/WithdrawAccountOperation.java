package dev.ddanylenko.enums;

import dev.ddanylenko.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WithdrawAccountOperation implements OperationCommand  {

    private final AccountService accountService;

    @Autowired
    public WithdrawAccountOperation(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public void execute(Object ... args) {
        long accountId = (long) args[0];
        double amount = (double) args[1];
        accountService.accountWithdraw(accountId, amount);
    }

    @Override
    public OperationType getOperationType() {
        return OperationType.ACCOUNT_WITHDRAW;
    }
}
