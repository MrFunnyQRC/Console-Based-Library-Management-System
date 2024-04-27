package userFactory;
import user.*;
public abstract class UserFactory {
    public User gainUser(String username, String password){
        User user = getUser(username, password);
        return user;
    }
    public abstract User getUser(String username, String password);
}
