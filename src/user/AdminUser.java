package user;

public class AdminUser implements User{
    private String username;
    private String password;
    private String book;
    public AdminUser(String username, String password){
        this.username = username;
        this.password = password;
        this.book = "";
    }
    @Override
    public String getID(){
        return "Admin";
    }
    @Override
    public String getUsername(){return this.username;}
    @Override
    public String getPassword(){return this.password;}
    @Override
    public String getBook(){
        return this.book;
    }
    @Override
    public void borrowBook(String book){
        this.book = book;
    }
    @Override
    public void returnBook(){
        this.book = "";
    }
}
