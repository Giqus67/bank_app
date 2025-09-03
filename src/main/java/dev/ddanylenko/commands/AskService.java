package dev.ddanylenko.commands;

import dev.ddanylenko.entities.Account;
import dev.ddanylenko.entities.User;
import dev.ddanylenko.services.AccountService;
import dev.ddanylenko.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class AskService {

    private final AccountService accountService;
    private final UserService userService;

    @Autowired
    public AskService(AccountService accountService, UserService userService) {
        this.userService = userService;
        this.accountService = accountService;
    }

    public void askLogin(){
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        long userId = 0;
        while (loop){
            System.out.print("Please, enter your user ID. Or enter 0 to exit: ");
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
            scanner.nextLine();
        }
    }

    public Account askID(String string) {
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        Account account = null;
        long accountId = 0;
        while (loop){
            System.out.print(string);
            if(!scanner.hasNextInt()){
                System.out.println("You should enter an integer! Or enter 0 to exit.");
                scanner.nextLine();
            }else{
                accountId = scanner.nextLong();
                account = accountService.findAccountById(accountId);
                if(accountId == 0){
                    return null;
                }
                if(account == null){
                    System.out.println("Account does not exist!");
                }else{
                    loop = false;
                }
            }
        }
        return account;
    }

    public boolean checkAccount(Account ... accounts) {
        for(Account account : accounts){
            if(account == null){
                System.out.println("Account does not exist!");
                return true;
            }
        }
        return false;
    }

    public double askAmount(String string) {
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        double amount = 0;
        while (loop){
            System.out.print(string);
            if(!scanner.hasNextInt()){
                System.out.println("You should enter an integer!");
            }else{
                amount = scanner.nextLong();
                if(amount < 0){
                    System.out.println("You should enter an positive integer!");
                }else{
                    loop = false;
                }
            }
        }
        return amount;
    }

}
