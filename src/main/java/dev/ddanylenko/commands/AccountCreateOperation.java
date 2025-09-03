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
    private AccountService accountService;
    private UserService userService;

    @Autowired
    public AccountCreateOperation(AccountService accountService, UserService userService) {
        this.accountService = accountService;
        this.userService = userService;
    }

    @Override
    public void execute() {
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        long userId = 0;
        while (loop){
            System.out.print("Please, enter your account ID. Or enter 0 to exit: ");
            if(!scanner.hasNextInt()){
                System.out.println("You should enter an integer!");
            }else{
                userId = scanner.nextInt();
                if(userId != 0){
                    User user = userService.findUserById(userId);
                    if(user != null){
                        accountService.createAccount(userId);
                        System.out.println(user);
                        loop = false;
                    }
                    else{
                        System.out.println("Account with this ID not found!");
                    }
                }
                else{
                    loop = false;
                }
            }
        }
    }

    @Override
    public OperationType getOperationType() {
        return OperationType.ACCOUNT_CREATE;
    }

}
