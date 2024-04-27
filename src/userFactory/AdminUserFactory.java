package userFactory;

import user.*;


public class AdminUserFactory extends UserFactory{

    @Override
    public User getUser(String username, String password){
        return new AdminUser(username, password);
    }
}
