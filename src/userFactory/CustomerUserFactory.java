package userFactory;

import user.*;


public class CustomerUserFactory extends UserFactory{

    @Override
    public User getUser(String username, String password){
        return new CustomerUser(username, password);
    }
}
