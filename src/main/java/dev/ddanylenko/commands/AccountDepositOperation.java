package dev.ddanylenko.commands;

import dev.ddanylenko.entities.Account;
import dev.ddanylenko.enums.OperationCommand;
import dev.ddanylenko.enums.OperationType;
import dev.ddanylenko.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountDepositOperation implements OperationCommand {

    private final AccountService accountService;
    private final AskService askService;

    @Autowired
    public AccountDepositOperation(AccountService accountService, AskService askService) {
        this.accountService = accountService;
        this.askService = askService;
    }

    @Override
    public void execute() {
        Account account = askService.askID("Please, enter your account ID for deposit. Or enter 0 to exit: ");
        if(askService.checkAccount(account)){
            return;
        }
        double amount = askService.askAmount("Please, amount of money to deposit. Or enter 0 to exit: ");
        accountService.deposit(account.getId(), amount);
    }

    @Override
    public OperationType getOperationType() {
        return OperationType.ACCOUNT_DEPOSIT;
    }

    public void askArguments() {

    }
}
