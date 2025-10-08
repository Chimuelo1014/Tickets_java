package view.User;
import javax.swing.JOptionPane;

import view.User.*;;
public class UserMenu {
    private UserView userview;
    

    public UserMenu(UserView userview) {
        this.userview = userview;
    }


    public void ShowUserMenu(){
        String options[] = {"Create User","List Users","Search User","Update User","Delete User", "Exit"}; 
        String opt;
        do {
            opt = (String) JOptionPane.showInputDialog(null, "Choose an option", "User Menu", -1, null, options, options[0]);
            switch (opt) {
                case "Create User":
                    userview.createUser();
                    break;
                case "List Users":
                    userview.showAllUsers();
                    break;
                case "Search User":
                    userview.searchUser();
                    break;
                case "Update User":
                    userview.updateUser();
                    break;
                case "Delete User":
                    userview.deleteUser();
                    break;
                case "Exit":
                    break;
                default:
                    System.out.println("Enter a valid option");
                    break;
            }
        } while (opt != "Exit");
    }
}