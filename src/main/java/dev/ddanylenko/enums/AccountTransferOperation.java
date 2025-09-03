package dev.ddanylenko.enums;

import dev.ddanylenko.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountTransferOperation implements OperationCommand {

    private final AccountService accountService;

    @Autowired
    public AccountTransferOperation(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public void execute(Object ... args) {
        long receiverAccountId = (long) args[0];
        long senderAccountId = (long) args[1];
        double amount = (double) args[2];
        accountService.accountTransfer(receiverAccountId, senderAccountId, amount);
    }

    @Override
    public OperationType getOperationType() {
        return OperationType.ACCOUNT_TRANSFER;
    }
}
