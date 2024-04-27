package menu.book;

import book.Book;
import database.BookDatabase;
import database.UserDatabase;
import menu.Menu;
import menu.State;
import menu.mainMenu.AdminMenu;
import menu.mainMenu.CustomerMenu;
import menuDecorator.TitleMenuDecorator;
import user.User;

import java.util.Scanner;

public class ReturnMenu implements State {
    @Override
    public void changeMenu(Menu menu){
        UserDatabase userDatabase = UserDatabase.getInstance();
        User user = userDatabase.getUser(menu.getUsername());
        Scanner scanner = new Scanner(System.in);
        String line;
        if(user.getBook().equals("")){
            System.out.println("You haven't borrowed any books, please borrow first");
        }
        else {
            BookDatabase bookDatabase = BookDatabase.getInstance();
            Book book = bookDatabase.getBook(user.getBook());
            book.setState("Available");
            bookDatabase.addBook(menu.getBookname(), book);
            user.returnBook();
            userDatabase.addUser(menu.getUsername(), user);
            System.out.println("Book has returned!");
        }
        System.out.println("> Enter anything to continue <");
        line = scanner.nextLine();
        if(user.getID().equals("Customer"))menu.setState(new TitleMenuDecorator(new CustomerMenu()));
        if(user.getID().equals("Admin"))menu.setState(new TitleMenuDecorator(new AdminMenu()));
    }
}
