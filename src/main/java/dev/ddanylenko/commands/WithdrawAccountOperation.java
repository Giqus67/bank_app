package dev.ddanylenko.commands;

import dev.ddanylenko.entities.Account;
import dev.ddanylenko.enums.OperationCommand;
import dev.ddanylenko.enums.OperationType;
import dev.ddanylenko.services.AccountService;
import dev.ddanylenko.services.AskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WithdrawAccountOperation implements OperationCommand {

    private final AccountService accountService;
    private final AskService askService;
    @Autowired
    public WithdrawAccountOperation(AccountService accountService, AskService askService) {
        this.accountService = accountService;
        this.askService = askService;
    }

    @Override
    public void execute() {
        Account account = askService.askID("Please, enter your account ID for withdraw. Or enter 0 to exit: ");
        if(askService.checkAccount(account)){
            return;
        }
        double amount = askService.askAmount("Please, amount of money to withdraw. Or enter 0 to exit: ");
        accountService.accountWithdraw(account.getId(), amount);
    }

    @Override
    public OperationType getOperationType() {
        return OperationType.ACCOUNT_WITHDRAW;
    }


    public void askArguments() {

    }
}
