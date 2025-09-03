package dev.ddanylenko.services;

import dev.ddanylenko.configurations.AccountProperties;
import dev.ddanylenko.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {


    private final AccountService accountService;

    private List<User> users;

    @Autowired
    public UserService(AccountService accountService) {
        this.accountService = accountService;
    }

    public boolean create_user(String login){
        for(User user : users){
            if(user.getLogin().equals(login)){
                return false;
            }
        }
        User user = new User(login);
        user.getAccountList().add(accountService.createAccount(user.getId()));
        users.add(user);
        return true;
    }

    public List<User> getAll_users(){
        return this.users;
    }

    public void updateUser(User user){
        for(int i=0; i<users.size(); i++){
            if(users.get(i).getLogin().equals(user.getLogin())){
                users.set(i,user);
            }
        }
    }

    public User findUserById(long id){
        for(User user : this.users){
            if(user.getId() == id){
                return user;
            }
        }
        return null;
    }
}
