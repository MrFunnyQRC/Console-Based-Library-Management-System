package menu.mainMenu;
import menu.*;
import menu.ID.IDChoice;
import menu.namePassword.NameInput;
import menuDecorator.TitleMenuDecorator;

import java.util.Scanner;
public class IniMenu implements State {
    @Override
    public void changeMenu(Menu menu) {
        System.out.println("Account not logged in");
        System.out.println("1.Register");
        System.out.println("2.Log in");
        System.out.println("3.Exit system");
        System.out.println("> Please enter the option number <");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        if(line.equals("1")){
            menu.setAccountFlag(0);
            menu.setState(new TitleMenuDecorator(new IDChoice()));
        }
        if(line.equals("2")){
            menu.setAccountFlag(1);
            menu.setState(new TitleMenuDecorator(new NameInput()));
        }
        if(line.equals("3"))System.exit(0);
    }
}
