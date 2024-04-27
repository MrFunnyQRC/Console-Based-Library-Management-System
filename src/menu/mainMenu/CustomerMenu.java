package menu.mainMenu;

import book.Book;
import database.BookDatabase;
import database.UserDatabase;
import menu.ID.IDChoice;
import menu.Menu;
import menu.State;
import menu.book.BorrowMenu;
import menu.book.ReturnMenu;
import menu.namePassword.NameInput;
import menuDecorator.TitleMenuDecorator;
import user.User;

import java.util.Scanner;

public class CustomerMenu implements State {
    @Override
    public void changeMenu(Menu menu) {
        System.out.print("Hello! Customer ");
        System.out.println(menu.getUsername());
        System.out.println("1.Borrow books");
        System.out.println("2.Return books");
        System.out.println("3.Log out");
        System.out.println("4.Exit system");
        System.out.println("> Please enter the option number <");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        if(line.equals("1")){
            menu.setState(new TitleMenuDecorator(new BorrowMenu()));
        }
        if(line.equals("2")){
            menu.setState(new TitleMenuDecorator(new ReturnMenu()));
        }
        if(line.equals("3")){
            menu.restart();
        }
        if(line.equals("4")){
            System.exit(0);
        }
    }
}
