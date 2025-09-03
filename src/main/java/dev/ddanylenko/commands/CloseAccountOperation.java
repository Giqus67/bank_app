package dev.ddanylenko.commands;

import dev.ddanylenko.entities.Account;
import dev.ddanylenko.enums.OperationCommand;
import dev.ddanylenko.enums.OperationType;
import dev.ddanylenko.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CloseAccountOperation implements OperationCommand {

    private final AccountService accountService;
    private final AskService askService;

    @Autowired
    public CloseAccountOperation(AccountService accountService, AskService askService) {
        this.accountService = accountService;
        this.askService = askService;
    }


    @Override
    public void execute() {
        Account account= askService.askID("Please, enter your account ID to close");
        if(askService.checkAccount(account)){
            return;
        }
        accountService.accountClose(account.getId());
    }

    @Override
    public OperationType getOperationType() {
        return OperationType.ACCOUNT_CLOSE;
    }

    public void askArguments() {

    }
}
