package menu;

import menu.mainMenu.IniMenu;
import menuDecorator.*;
public class Menu {
    private State state;
    private int userFlag;//0: customer, 1: admin
    private int accountFlag;// 0: register, 1: login
    private String username;
    private String bookname;
    public Menu(){
        this.state = new TitleMenuDecorator(new IniMenu());
        this.userFlag = 0;
        this.accountFlag = 0;
        this.username= "";
        this.bookname= "";
    }
    public void setState(State state){
        this.state = state;
    }
    public void restart(){
        this.state = new TitleMenuDecorator(new IniMenu());
        this.userFlag = 0;
        this.accountFlag = 0;
        this.username= "";
        this.bookname= "";
    }
    public void setUserFlag(int flag){
        this.userFlag = flag;
    }
    public int getUserFlag(){
        return this.userFlag;
    }
    public void setAccountFlag(int flag){
        this.accountFlag = flag;
    }
    public int getAccountFlag(){
        return this.accountFlag;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public String getUsername(){
        return this.username;
    }
    public void setBookname(String bookname){
        this.bookname = bookname;
    }
    public String getBookname(){
        return this.bookname;
    }
    public void changeMenu(){
        this.state.changeMenu(this);
    }
}
