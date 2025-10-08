package controller;

import java.util.ArrayList;
import domain.User;
import service.UserService;

public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    
    public void createUser(User user){
        userService.createUser(user);
    }

    public ArrayList<User> getAllUsers(){
        return userService.getAllUsers();

    }

    public User getUserById(int id){
        return userService.getUserById(id);
    }

    public void deleteUser(int id){
        userService.deleteUser(id);
    }

    public void updateUser(User user, int id){
        userService.updateUser(user, id);
    }

}
