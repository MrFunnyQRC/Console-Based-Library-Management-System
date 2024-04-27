import userFactory.*;
import book.*;
import database.*;
import menu.*;
public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        while(true){
            menu.changeMenu();
        }
    }
}