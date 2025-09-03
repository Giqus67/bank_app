package dev.ddanylenko.enums;

import org.springframework.stereotype.Component;

@Component
public class ShowUsersOperation implements OperationCommand{
    @Override
    public void execute() {

    }

    @Override
    public OperationType getOperationType() {
        return OperationType.SHOW_ALL_USERS;
    }
}
