package dev.ddanylenko.services;

import dev.ddanylenko.enums.OperationCommand;
import dev.ddanylenko.enums.OperationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OperationConsoleListener   {
    private final Map<OperationType, OperationCommand> commandMap = new HashMap<>();

    @Autowired
    public OperationConsoleListener(List<OperationCommand> commandList) {
        commandList.forEach(command -> commandMap.put(command.getOperationType(), command));
    }

    public int countOperations() {
        return commandMap.size();
    }

    public void printOperations(){
        int i = 1;
        for(OperationType type : commandMap.keySet()){
            OperationCommand command = commandMap.get(type);
            System.out.println(i + " - " + command.getOperationType());
            i++;
        }
        System.out.println(i + " - EXIT");
        System.out.print("Please, select operation 1-"+ i + ":");
    }

    public void findOperation(String operation){
        int i = 1;
        int number = 0;
        boolean found = false;
        if (operation.matches("\\d+")){
            number = Integer.parseInt(operation);
        }
        for(OperationType type : commandMap.keySet()){
            OperationCommand command = commandMap.get(type);
            if(command.getOperationType().toString().equalsIgnoreCase(operation)){
                System.out.println(command.getOperationType());
                found = true;
            }
            if (i == number){
                System.out.println(command.getOperationType());
                found = true;
            }
            i++;
        }
        if(!found){
            System.out.println("Operation not found, please write again.");
        }
    }
}
