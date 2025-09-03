package dev.ddanylenko.enums;

import dev.ddanylenko.entities.User;
import dev.ddanylenko.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ShowUsersOperation implements OperationCommand{

    private final UserService userService;

    @Autowired
    public ShowUsersOperation(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void execute(Object ... args ) {
        List<User> users = userService.getAll_users();
        if(!users.isEmpty()){
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
