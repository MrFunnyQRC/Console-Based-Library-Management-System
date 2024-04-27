package menu.book;

import database.BookDatabase;
import database.UserDatabase;
import java.util.ArrayList;
import java.util.List;
import menu.Menu;
import menu.State;
import menu.mainMenu.AdminMenu;
import menu.mainMenu.CustomerMenu;
import menuDecorator.TitleMenuDecorator;
import user.User;

import java.util.Scanner;

public class BorrowMenu implements State {
    @Override
    public void changeMenu(Menu menu) {
        BookDatabase bookDatabase = BookDatabase.getInstance();
        UserDatabase userDatabase = UserDatabase.getInstance();
        User user = userDatabase.getUser(menu.getUsername());
        List<String> list = bookDatabase.getAvailableBookList();
        Scanner scanner = new Scanner(System.in);
        String line;
        if((!user.getBook().equals("")) || list.size() == 0){
            if(!user.getBook().equals(""))System.out.println("You have borrowed a book, please return it first!");
            else if(list.size() == 0)System.out.println("There isn't any available books in library!");
            System.out.println("> Enter anything to continue <");
            line = scanner.nextLine();
            if(user.getID().equals("Customer"))menu.setState(new TitleMenuDecorator(new CustomerMenu()));
            if(user.getID().equals("Admin"))menu.setState(new TitleMenuDecorator(new AdminMenu()));
            return;
        }
        System.out.println("Here are available books:");
        for(String element:list){
            System.out.print("--");
            System.out.println(element);
        }
        System.out.println(">Input book's title to get the details<");
        System.out.println(">Or you can input \"Return System\" to return the menu<");
        line = scanner.nextLine();
        if(line.equals("Return System")){
            if(user.getID().equals("Customer"))menu.setState(new TitleMenuDecorator(new CustomerMenu()));
            if(user.getID().equals("Admin"))menu.setState(new TitleMenuDecorator(new AdminMenu()));
        }
        else if (bookDatabase.checkBookExists(line)){
            menu.setBookname(line);
            menu.setState(new TitleMenuDecorator(new BookInfor()));
        }else {
            System.out.println(">Invalid input, please try again<");
            System.out.println("> Enter anything to continue <");
            line = scanner.nextLine();
        }
    }
}
