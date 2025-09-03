package dev.ddanylenko.enums;

import dev.ddanylenko.entities.User;
import dev.ddanylenko.services.AccountService;
import dev.ddanylenko.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
    public void execute(Object ... args) {
        String login = (String) args[0];
        User user =  userService.create_user(login);
        user.getAccountList().add(accountService.createAccount(user.getId()));
    }

    @Override
    public OperationType getOperationType() {
        return OperationType.USER_CREATE;
    }
}
