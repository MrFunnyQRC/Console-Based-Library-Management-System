package menu.namePassword;
import java.util.Scanner;
import database.*;
import menu.Menu;
import menu.State;
import menuDecorator.TitleMenuDecorator;

public class NameInput implements State {
    @Override
    public void changeMenu(Menu menu) {
        if(menu.getAccountFlag() == 0)System.out.println("Register");
        else System.out.println("Log in");
        System.out.println(">Please input your name<");
        UserDatabase userDatabase = UserDatabase.getInstance();

        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        if(menu.getAccountFlag() == 0){//register
           if(userDatabase.checkUserExists(line)){
               System.out.println("Name has existed!");
               System.out.println("> Enter anything to continue <");
               line = scanner.nextLine();
               menu.restart();
           }
           else{
               menu.setUsername(line);
               menu.setState(new TitleMenuDecorator(new PasswordInput()));
           }
        }

        if(menu.getAccountFlag() == 1){//log in
            if(!userDatabase.checkUserExists(line)){
                System.out.println("Name hasn't existed!");
                System.out.println("> Enter anything to continue <");
                line = scanner.nextLine();
                menu.restart();
            }
            else{
                menu.setUsername(line);
                menu.setState(new TitleMenuDecorator(new PasswordInput()));
            }
        }
    }
}