package view;

import javax.swing.JOptionPane;
import view.User.*;
public class MainMenu {
    private UserMenu userMenu;
    
    
    public MainMenu(UserMenu userMenu) {
        this.userMenu = userMenu;
    }


    public void showMenu(){
        String[] options = {"User Menu","Ticket Menu", "Comments Menu", "Exit"};
        String opt;
        do {
            opt = (String) JOptionPane.showInputDialog(null, "Choose an option", "Menu",-1,null, options, options[0]);
            switch (opt) {
                case "User Menu":
                    userMenu.ShowUserMenu();
                    break;
                case "Ticket Menu":
                    break;
                case "Comments Menu":
                    break;
                case "Exit":
                    System.out.println("Good bye");
                    break;
                default:
                    System.out.println("Enter a valid option");
                    break;
            }
        }
        while(opt != "Exit");
    }
}