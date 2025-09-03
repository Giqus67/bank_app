package dev.ddanylenko.commands;

import dev.ddanylenko.entities.User;
import dev.ddanylenko.enums.OperationCommand;
import dev.ddanylenko.enums.OperationType;
import dev.ddanylenko.services.AccountService;
import dev.ddanylenko.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class AccountCreateOperation implements OperationCommand {
    private final AskService askService;

    @Autowired
    public AccountCreateOperation(AskService askService) {
        this.askService = askService;
    }

    @Override
    public void execute() {
       askService.askLogin();
    }

    @Override
    public OperationType getOperationType() {
        return OperationType.ACCOUNT_CREATE;
    }

}
