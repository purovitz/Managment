package service;

import api.UserService;
import entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {

    List<User> users;

    public UserServiceImpl() {
        this.users = new ArrayList<User>();
    }

    public UserServiceImpl(List<User> users) {
        this.users = users;
    }

    public List<User> getAllUsers() {
        return users;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void removeUserById(int userID) {
        for (int i = 0; i<users.size(); i++){
            //wyciagniecie i-tego usera z listy
            User userFromList = users.get(i);
            //jezeli ID usera z listy jest rowne podanemu userId do usuniecia
            if (userFromList.getId() == userID) {
                //to usun usera z pod i-tego indexu
                users.remove(i);
                // i przerwij petle w koncu user juz zostal usuniety
                break;
            }
        }
    }
}
