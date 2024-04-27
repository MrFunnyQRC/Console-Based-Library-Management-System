package database;
import java.util.Map;
import java.util.TreeMap;
import user.User;

public class UserDatabase {
    private Map<String, User> userDatabase;
    private static UserDatabase instance;//Private static variable that stores a unique instance
    private UserDatabase(){
        userDatabase = new TreeMap<>();
    }
    public static synchronized UserDatabase getInstance() {//Return unique instance
        if (instance == null) {
            instance = new UserDatabase();
        }
        return instance;
    }
    public void addUser(String username, User user){
        userDatabase.put(username,user);
    }
    public User getUser(String username){
        return userDatabase.get(username);
    }
    public boolean checkUserExists(String username){
        return userDatabase.containsKey(username);
    }
}
