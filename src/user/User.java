package user;

public interface User {
    public String getID();
    public String getUsername();
    public String getPassword();
    public String getBook();
    public void borrowBook(String book);
    public void returnBook();

}
