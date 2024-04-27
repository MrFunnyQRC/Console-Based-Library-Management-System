package book;

public class Book {
    private final String title;
    private final String author;
    private final String press;
    private final String year;
    private String state; // "Check Out" or "Available"

    Book(String title, String author, String press, String year){
        this.title = title;
        this.author = author;
        this.press = press;
        this.year = year;
        this.state = "Available";
    }
    public String getTitle(){
        return this.title;
    }
    public String getAuthor(){
        return this.author;
    }
    public String getPress(){
        return this.press;
    }
    public String getYear(){
        return this.year;
    }
    public String getState(){
        return this.state;
    }
    public void setState(String state){
        this.state = state;
    }
}
