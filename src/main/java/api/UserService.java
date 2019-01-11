package api;

import entity.User;

import java.util.List;

public interface UserService {
    //Metoda odpowiedzialna za wyciaganie wszystkich userow
    List<User> getAllUsers();
    //Metoda odpowiedzialna za dodawanie nowego usera
    void addUser(User user);
    //Metoda odpowiedzialna za usuniecie usera po jego id
    void removeUserById(int userID);

}
