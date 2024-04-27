package menu.book;

import database.BookDatabase;
import database.UserDatabase;
import menu.Menu;
import menu.State;
import book.Book;
import menu.mainMenu.AdminMenu;
import menu.mainMenu.CustomerMenu;
import menuDecorator.TitleMenuDecorator;
import user.User;

import java.util.Scanner;

public class BookInfor implements State {
    @Override
    public void changeMenu(Menu menu) {
        BookDatabase bookDatabase = BookDatabase.getInstance();
        Book book = bookDatabase.getBook(menu.getBookname());
        UserDatabase userDatabase = UserDatabase.getInstance();
        User user = userDatabase.getUser(menu.getUsername());
        System.out.println("Book information");
        System.out.print("Title: ");
        System.out.println(book.getTitle());
        System.out.print("Author: ");
        System.out.println(book.getAuthor());
        System.out.print("Press: ");
        System.out.println(book.getPress());
        System.out.print("Year: ");
        System.out.println(book.getYear());
        System.out.println();
        System.out.println("1.Borrow");
        System.out.println("2.return");
        System.out.println("> Please enter the option number <");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        if(line.equals("1")){
            book.setState("Check Out");
            bookDatabase.addBook(menu.getBookname(),book);
            user.borrowBook(menu.getBookname());
            userDatabase.addUser(menu.getUsername(),user);
            System.out.println(">Borrow successful!<");
            System.out.println("> Enter anything to continue <");
            line = scanner.nextLine();
            if(user.getID().equals("Customer"))menu.setState(new TitleMenuDecorator(new CustomerMenu()));
            if(user.getID().equals("Admin"))menu.setState(new TitleMenuDecorator(new AdminMenu()));
        }
        if(line.equals("2")){
            menu.setState(new TitleMenuDecorator(new BorrowMenu()));
        }
    }
}
