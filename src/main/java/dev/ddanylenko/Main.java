package dev.ddanylenko;

import dev.ddanylenko.services.OperationConsoleListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.Scanner;


@Component
@ComponentScan("dev.ddanylenko")
public class Main {

    public static void main(String[] args) {
        start();
    }

    public static void start(){
        Scanner scanner = new Scanner(System.in);
        try(AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class)) {
            OperationConsoleListener operationConsoleListener = context.getBean(OperationConsoleListener.class);
            boolean exit = false;
            while(!exit){
                operationConsoleListener.printOperations();
                String string = scanner.nextLine();
                operationConsoleListener.findOperation(string);

            }
        }
    }

}