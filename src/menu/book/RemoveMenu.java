package menu.book;

import database.BookDatabase;
import menu.Menu;
import menu.State;
import menu.mainMenu.AdminMenu;
import menu.mainMenu.CustomerMenu;
import menuDecorator.TitleMenuDecorator;

import java.util.List;
import java.util.Scanner;

public class RemoveMenu implements State {
    @Override
    public void changeMenu(Menu menu) {
        BookDatabase bookDatabase = BookDatabase.getInstance();
        List<String> list = bookDatabase.getAvailableBookList();
        Scanner scanner = new Scanner(System.in);
        String line;
        if(list.size() == 0){
            System.out.println("There isn't any available books in library!");
            System.out.println("> Enter anything to continue <");
            line = scanner.nextLine();
            menu.setState(new TitleMenuDecorator(new AdminMenu()));
            return;
        }
        System.out.println("Here are available books:");
        for(String element:list){
            System.out.print("--");
            System.out.println(element);
        }
        System.out.println(">Input book's title to remove book<");
        System.out.println(">Or you can input \"Return System\" to return the menu<");
        line = scanner.nextLine();
        if(line.equals("Return System")){
            menu.setState(new TitleMenuDecorator(new AdminMenu()));
        }
        else if (bookDatabase.checkBookExists(line)){
            bookDatabase.removeBook(line);
            System.out.println(">Remove successful!<");
            System.out.println("> Enter anything to continue <");
            line = scanner.nextLine();
            menu.setState(new TitleMenuDecorator(new AdminMenu()));
        }else {
            System.out.println(">Invalid input, please try again<");
            System.out.println("> Enter anything to continue <");
            line = scanner.nextLine();
        }
    }
}
