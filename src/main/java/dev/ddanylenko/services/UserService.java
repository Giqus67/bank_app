package dev.ddanylenko.services;

import dev.ddanylenko.entities.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private List<User> users;
    public void create_user(String login){
        for(User user : users){
            if(user.getLogin().equals(login)){
                return;
            }
        }
        User user = new User(login);
        users.add(user);
    }

    public List<User> getAll_users(){
        return this.users;
    }
}
