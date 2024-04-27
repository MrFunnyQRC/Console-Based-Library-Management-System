package menu.mainMenu;

import menu.Menu;
import menu.State;
import menu.book.BookNameInput;
import menu.book.BorrowMenu;
import menu.book.RemoveMenu;
import menu.book.ReturnMenu;
import menuDecorator.TitleMenuDecorator;

import java.util.Scanner;

public class AdminMenu implements State {
    @Override
    public void changeMenu(Menu menu) {
        System.out.print("Hello! Admin ");
        System.out.println(menu.getUsername());
        System.out.println("1.Add books");
        System.out.println("2.Remove books");
        System.out.println("3.Borrow books");
        System.out.println("4.Return books");
        System.out.println("5.Log out");
        System.out.println("6.Exit system");
        System.out.println("> Please enter the option number <");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        if(line.equals("1")){
            menu.setState(new TitleMenuDecorator(new BookNameInput()));
        }
        if(line.equals("2")){
            menu.setState(new TitleMenuDecorator(new RemoveMenu()));
        }
        if(line.equals("3")){
            menu.setState(new TitleMenuDecorator(new BorrowMenu()));
        }
        if(line.equals("4")){
            menu.setState(new TitleMenuDecorator(new ReturnMenu()));
        }
        if(line.equals("5")){
            menu.restart();
        }
        if(line.equals("6")){
            System.exit(0);
        }
    }
}
