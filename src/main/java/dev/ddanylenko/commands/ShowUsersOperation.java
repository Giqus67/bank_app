package dev.ddanylenko.commands;

import dev.ddanylenko.entities.User;
import dev.ddanylenko.enums.OperationCommand;
import dev.ddanylenko.enums.OperationType;
import dev.ddanylenko.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ShowUsersOperation implements OperationCommand {

    private final UserService userService;

    @Autowired
    public ShowUsersOperation(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void execute() {
        List<User> users = userService.getAll_users();
        if(users != null && !users.isEmpty()){
            System.out.println("List of users:");
            for(User user : users) {
                System.out.println(user);
            }
        }else{
            System.out.println("No users found");
        }
    }

    @Override
    public OperationType getOperationType() {
        return OperationType.SHOW_ALL_USERS;
    }
}
