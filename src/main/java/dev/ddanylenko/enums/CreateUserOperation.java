package dev.ddanylenko.enums;

import org.springframework.stereotype.Component;

@Component
public class CreateUserOperation implements OperationCommand {
    @Override
    public void execute() {

    }

    @Override
    public OperationType getOperationType() {
        return OperationType.USER_CREATE;
    }
}
