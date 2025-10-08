package service;

import domain.User;
import dao.User.UserIMP;
import java.util.ArrayList;
import util.Validator;

public class UserService {
    private UserIMP userImpl;

    public UserService(UserIMP userImpl) {
        this.userImpl = userImpl;
    }

    public void createUser(User user) {
    userImpl.createUser(user);

    }

    public ArrayList<User> getAllUsers() {
        return userImpl.getAllUsers();

    }

    public User getUserById(int id) {
        return userImpl.getUserById(id);
    }

    public void updateUser(User user, int id) {
        if (userImpl.getUserById(user.getId()) == null) {

        } else {
            if (Validator.isValidName(user.getName()) || Validator.isValidName(user.getRol())) {
                userImpl.updateUser(user, id);
            }
        }
        
    }

    public void deleteUser(int id){
        if(getUserById(id) == null){
            System.out.println("User not found");
        }
        userImpl.deleteUser(id);
    }
}
