package dev.ddanylenko.services;

import dev.ddanylenko.configurations.AccountProperties;
import dev.ddanylenko.entities.Account;
import dev.ddanylenko.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService {

    List<Account> accountList = new ArrayList<>();

    private final AccountProperties accountProperties;

    private final UserService userService;

    @Autowired
    public AccountService(AccountProperties accountProperties, UserService userService) {
        this.accountProperties = accountProperties;
        this.userService = userService;
    }

    public Account createAccount(long userId) {
        Account account = new Account(userId, accountProperties.getDefaultAmount());
        User user = userService.findUserById(userId);
        user.getAccountList().add(account);
        userService.updateUser(user);
        accountList.add(account);
        return account;
    }

    public Account findAccountById(long accountId) {
        for (Account account : accountList) {
            if (account.getId() == accountId) {
                return account;
            }
        }
        return null;
    }

    public void deleteAccount(Account account) {
        User user = userService.findUserById(account.getUserId());
        user.getAccountList().remove(account);
        userService.updateUser(user);
        accountList.remove(account);
    }

    public void updateAccount(Account account) {
        User user = userService.findUserById(account.getUserId());
        for(int i = 0; i < user.getAccountList().size(); i++){
            if(user.getAccountList().get(i).getId() == account.getId()){
                user.getAccountList().set(i, account);
                userService.updateUser(user);
            }
        }
        for(int i = 0; i < accountList.size(); i++){
            if(accountList.get(i).getId() == account.getId()){
                accountList.set(i, account);
            }
        }
    }

    public void accountClose(long accountId){
        Account account = findAccountById(accountId);
        User user = userService.findUserById(account.getUserId());
        if(user.getAccountList().size() > 1){
            double value = user.getAccountList().getFirst().getMoneyAmount() + account.getMoneyAmount();
            user.getAccountList().getFirst().setMoneyAmount(value);
            user.getAccountList().remove(account);
            userService.updateUser(user);
            deleteAccount(account);
            System.out.println(user);

        }else{
            System.out.println("You have only one account, you cannot delete this!");
        }
    }

    public void deposit(long accountId, double amount) {
        Account account = findAccountById(accountId);
        account.setMoneyAmount(account.getMoneyAmount() + amount);
        updateAccount(account);
        System.out.println(account);
    }

    public void accountTransfer(long receiverAccountId, long senderAccountId, double amount) {
        Account accountSender = findAccountById(senderAccountId);
        Account accountReceiver = findAccountById(receiverAccountId);
        if(accountSender.getMoneyAmount() >= amount){
            double commission = 0;
            if(accountReceiver.getUserId() != accountSender.getUserId()){
                commission = amount * accountProperties.getDefaultCommission();
            }
            amount += commission;
            accountSender.setMoneyAmount(accountSender.getMoneyAmount() - amount);
            updateAccount(accountSender);
            accountReceiver.setMoneyAmount(accountReceiver.getMoneyAmount() + amount);
            updateAccount(accountReceiver);
            System.out.println("Sender: ");
            System.out.println(accountSender);
            System.out.println("Receiver: ");
            System.out.println(accountReceiver);
        }
        else {
            System.out.println("You have not enough money to transfer!");
        }
    }

    public void accountWithdraw(long accountId, double amount) {
        Account account = findAccountById(accountId);
        if(account.getMoneyAmount() >= amount){
            account.setMoneyAmount(account.getMoneyAmount() - amount);
            updateAccount(account);
            System.out.println(account);
        }
        else {
            System.out.println("You have not enough money to withdraw!");
        }
    }
}
