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
public class CreateUserOperation implements OperationCommand {

    private final UserService userService;
    private final AccountService accountService;

    @Autowired
    public CreateUserOperation(UserService userService, AccountService accountService) {
        this.userService = userService;
        this.accountService = accountService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please, enter your login: ");
        String login = scanner.nextLine();
        User user = userService.createUser(login);
        if (user == null) {
            System.out.println("Account with this login already exists!");
        }
        else{
            accountService.createAccount(user.getId());
            System.out.println(user);
        }
    }

    @Override
    public OperationType getOperationType() {
        return OperationType.USER_CREATE;
    }

}
