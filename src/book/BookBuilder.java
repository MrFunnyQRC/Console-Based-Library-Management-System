package book;

public class BookBuilder {
    private String title;
    private String author;
    private String press;
    private String year;

    public BookBuilder title(String title){
        this.title = title;
        return this;
    }
    public BookBuilder author(String author){
        this.author = author;
        return this;
    }
    public BookBuilder press(String press){
        this.press = press;
        return this;
    }
    public BookBuilder year(String year){
        this.year = year;
        return this;
    }
    public Book build(){
        return new Book(title, author, press, year);
    }
}
