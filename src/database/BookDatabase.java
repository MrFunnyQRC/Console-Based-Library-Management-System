package database;
import java.util.Map;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.List;
import book.Book;

public class BookDatabase {
    private Map<String, Book> bookDatabase;
    private static BookDatabase instance;//Private static variable that stores a unique instance
    private BookDatabase(){
        bookDatabase = new TreeMap<>();
    }
    public static synchronized BookDatabase getInstance() {//Return unique instance
        if (instance == null) {
            instance = new BookDatabase();
        }
        return instance;
    }
    public int size(){
        return bookDatabase.size();
    }
    public void addBook(String bookname, Book book){
        bookDatabase.put(bookname,book);
    }
    public void removeBook(String bookname){
        bookDatabase.remove(bookname);
    }
    public Book getBook(String bookname){
        return bookDatabase.get(bookname);
    }
    public List<String> getAvailableBookList(){
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, Book> entry : bookDatabase.entrySet()) {
            if(entry.getValue().getState().equals("Available")){
                list.add(entry.getKey());
            }
        }
        return list;
    }
    public boolean checkBookExists(String bookname){
        return bookDatabase.containsKey(bookname);
    }
}
