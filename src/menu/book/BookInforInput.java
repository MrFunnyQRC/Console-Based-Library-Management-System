package menu.book;

import database.BookDatabase;
import database.UserDatabase;
import menu.Menu;
import menu.State;
import menu.mainMenu.AdminMenu;
import menu.mainMenu.CustomerMenu;
import menuDecorator.TitleMenuDecorator;
import user.User;
import book.*;

import java.util.Scanner;

public class BookInforInput implements State {
    @Override
    public void changeMenu(Menu menu) {
        BookDatabase bookDatabase = BookDatabase.getInstance();
        UserDatabase userDatabase = UserDatabase.getInstance();
        User user = userDatabase.getUser(menu.getUsername());
        Scanner scanner = new Scanner(System.in);
        System.out.println(">Please input book's author<");
        String author = scanner.nextLine();
        System.out.println(">Please input book's press<");
        String press = scanner.nextLine();
        System.out.println(">Please input book's year<");
        String year = scanner.nextLine();
        Book book  = new BookBuilder()
                .title(menu.getBookname())
                .author(author)
                .press(press)
                .year(year)
                .build();
        bookDatabase.addBook(menu.getBookname(),book);
        System.out.println("Book created successful!");
        System.out.println("> Enter anything to continue <");
        String line = scanner.nextLine();
        menu.setState(new TitleMenuDecorator(new AdminMenu()));
    }
}
