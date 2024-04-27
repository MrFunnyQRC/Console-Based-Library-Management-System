package menu.namePassword;

import database.UserDatabase;
import menu.Menu;
import menu.State;
import menu.mainMenu.AdminMenu;
import menu.mainMenu.CustomerMenu;
import menuDecorator.TitleMenuDecorator;
import userFactory.*;
import user.User;
import java.util.Scanner;

public class PasswordInput implements State {
    @Override
    public void changeMenu(Menu menu) {
        if(menu.getAccountFlag() == 0)System.out.println("Register");
        else System.out.println("Log in");
        System.out.println(">Please input your password<");
        UserDatabase userDatabase = UserDatabase.getInstance();

        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        if(menu.getAccountFlag() == 0) {//register
            UserFactory userFactory = new CustomerUserFactory();
            if(menu.getUserFlag() == 1){
                userFactory = new AdminUserFactory();
            }
            User user = userFactory.gainUser(menu.getUsername(),line);
            userDatabase.addUser(menu.getUsername(),user);
            System.out.println("Register successful!");
            System.out.println("> Enter anything to continue <");
            line = scanner.nextLine();
            menu.restart();
        }
        if(menu.getAccountFlag() == 1){//log in
            User user = userDatabase.getUser(menu.getUsername());
            if(!user.getPassword().equals(line)){
                System.out.println("Password wrong!");
                System.out.println("> Enter anything to continue <");
                line = scanner.nextLine();
                menu.restart();
            }
            else{
                System.out.println("Log in successful!");
                System.out.println("> Enter anything to continue <");
                line = scanner.nextLine();
                if(user.getID().equals("Customer"))menu.setState(new TitleMenuDecorator(new CustomerMenu()));
                if(user.getID().equals("Admin")){menu.setState(new TitleMenuDecorator(new AdminMenu()));}
            }
        }
    }
}