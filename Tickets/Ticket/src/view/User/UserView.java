package view.User;

import javax.swing.JOptionPane;
import controller.UserController;
import domain.User;

public class UserView {
    private UserController userController;


    public UserView(UserController userController) {
        this.userController = userController;
    }

    String[] optionsRol = {"Asignee", "Reporter"} ;

    public void createUser() {
        String id = JOptionPane.showInputDialog(null, "Enter the ID of the user", "ID", -1);
        String name = JOptionPane.showInputDialog(null, "Enter the name of the user", "NAME", -1);
        String rol = (String) JOptionPane.showInputDialog(null, "Enter the rol of the user", "ID", -1, null, optionsRol,optionsRol[0]);
        User user = new User(Integer.parseInt(id), name, rol);
        userController.createUser(user);
        
    }

    public void showAllUsers(){
        String message = "";
        for (User u : userController.getAllUsers()){
        message += u.getId()+" "+u.getName()+" "+u.getRol()+"\n\n";
        }
        JOptionPane.showMessageDialog(null, message, "Users", -1);
  

    }

    public void searchUser(){
        String id = JOptionPane.showInputDialog(null, "Enter the ID of the user", "ID", -1);
        User user = userController.getUserById(Integer.parseInt(id));
        JOptionPane.showMessageDialog(null, "Id: "+user.getId()+" Name: "+user.getName()+" Rol: "+user.getRol(),"USER", 0);

    }

    public void updateUser(){
        String id = JOptionPane.showInputDialog(null, "Enter the ID of the user", "ID", -1);
        //JOptionPane.showMessageDialog(null, "this is the user", "User", -1);
        String newId = JOptionPane.showInputDialog(null, "Enter the ID of the user", "ID", -1);
        String name = JOptionPane.showInputDialog(null, "Enter the name of the user", "NAME", -1);
        String rol = (String) JOptionPane.showInputDialog(null, "Enter the rol of the user", "ID", -1, null, optionsRol,optionsRol[0]);

        userController.updateUser(new User(Integer.parseInt(newId), name, rol), Integer.parseInt(id));
    }

    public void deleteUser(){
        String id = JOptionPane.showInputDialog(null, "Enter the ID of the user", "ID", -1);
        userController.deleteUser(Integer.parseInt(id));
    }

}