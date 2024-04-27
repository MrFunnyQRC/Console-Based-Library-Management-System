package menu.ID;
import menu.*;
import menu.namePassword.NameInput;
import menuDecorator.TitleMenuDecorator;

import java.util.Scanner;
public class IDChoice implements State {
    @Override
    public void changeMenu(Menu menu) {
        System.out.println("1.Customer");
        System.out.println("2.Admin");
        System.out.println("> Please enter the option number to choose your register identity <");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        if(line.equals("1")){
            menu.setUserFlag(0);
            menu.setState(new TitleMenuDecorator(new NameInput()));
        }
        if(line.equals("2")){
            menu.setUserFlag(1);
            menu.setState(new TitleMenuDecorator(new IDCheck()));
        }
    }
}
