package menu.ID;
import menu.*;
import menu.namePassword.NameInput;
import menuDecorator.TitleMenuDecorator;

import java.util.Scanner;

public class IDCheck implements State {
    @Override
    public void changeMenu(Menu menu) {
        System.out.println("> Please enter administrator authentication password <");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        if(line.equals("admin")){//here is the administrator authentication password
            menu.setState(new TitleMenuDecorator(new NameInput()));
        }
        else{
            System.out.println("Wrong authentication password!");
            System.out.println("> Enter anything to continue <");
            line = scanner.nextLine();
            menu.restart();
        }
    }
}
