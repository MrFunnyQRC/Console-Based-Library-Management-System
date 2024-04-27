package menu.book;

import database.BookDatabase;
import database.UserDatabase;
import menu.Menu;
import menu.State;
import menu.mainMenu.AdminMenu;
import menu.mainMenu.CustomerMenu;
import menu.namePassword.PasswordInput;
import menuDecorator.TitleMenuDecorator;
import user.User;

import java.util.Scanner;

public class BookNameInput implements State {
    @Override
    public void changeMenu(Menu menu) {
        BookDatabase bookDatabase = BookDatabase.getInstance();
        UserDatabase userDatabase = UserDatabase.getInstance();
        User user = userDatabase.getUser(menu.getUsername());
        System.out.println(">Please input book's title<");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        if(line.equals("Return System") || bookDatabase.checkBookExists(line)){
            if(line.equals("Return System"))System.out.println(">Illegal name, please try again<");
            else if(bookDatabase.checkBookExists(line)) System.out.println(">Name has existed, please try again<");
            System.out.println("> Enter anything to continue <");
            line = scanner.nextLine();
            menu.setState(new TitleMenuDecorator(new AdminMenu()));
        }
        else{
            menu.setBookname(line);
            menu.setState(new TitleMenuDecorator(new BookInforInput()));
        }
    }
}
