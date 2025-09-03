package dev.ddanylenko.enums;

public interface OperationCommand{
    public void execute(Object ... args);
    OperationType getOperationType();
}
