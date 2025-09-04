package dev.ddanylenko.commands;

import dev.ddanylenko.entities.Account;
import dev.ddanylenko.enums.OperationCommand;
import dev.ddanylenko.enums.OperationType;
import dev.ddanylenko.services.AccountService;
import dev.ddanylenko.services.AskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountTransferOperation implements OperationCommand {

    private final AccountService accountService;
    private final AskService askService;

    @Autowired
    public AccountTransferOperation(AccountService accountService, AskService askService) {
        this.accountService = accountService;
        this.askService = askService;
    }

    @Override
    public void execute() {
        Account senderAccount = askService.askID("Please, enter your account ID: ");
        Account receiverAccount = askService.askID("Please, enter an receiver account ID: ");
        if(askService.checkAccount(senderAccount, receiverAccount)){
            return;
        }
        double amount = askService.askAmount("Please, amount of money to transfer. Or enter 0 to exit: ");
        accountService.accountTransfer(receiverAccount.getId(), senderAccount.getId(), amount);
    }

    @Override
    public OperationType getOperationType() {
        return OperationType.ACCOUNT_TRANSFER;
    }


}
