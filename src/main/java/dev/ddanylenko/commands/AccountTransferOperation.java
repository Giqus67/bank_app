package dev.ddanylenko.commands;

import dev.ddanylenko.enums.OperationCommand;
import dev.ddanylenko.enums.OperationType;
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
    public void execute() {
        long receiverAccountId = (long) 1;
        long senderAccountId = (long) 1;
        double amount = (double) 1;
        accountService.accountTransfer(receiverAccountId, senderAccountId, amount);
    }

    @Override
    public OperationType getOperationType() {
        return OperationType.ACCOUNT_TRANSFER;
    }


    public void askArguments() {

    }
}
