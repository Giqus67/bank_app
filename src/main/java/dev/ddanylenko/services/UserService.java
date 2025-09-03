package dev.ddanylenko.services;

import dev.ddanylenko.configurations.AccountProperties;
import dev.ddanylenko.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private List<User> users = new ArrayList<>();

    public User createUser(String login){
        if(users != null){
            for(User user : users){
                if(user.getLogin().equals(login)){
                    return null;
                }
            }
        }
        User user = new User(login);
        users.add(user);
        return user;
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
