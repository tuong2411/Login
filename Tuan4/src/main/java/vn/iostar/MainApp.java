package vn.iostar;

import vn.iostar.Dao.impl.UserDaoImpl;
import vn.iostar.Models.UserModel;
import java.util.List;

public class MainApp {

    public static void main(String[] args) {
        UserDaoImpl userDao = new UserDaoImpl();
        
        List<UserModel> users = userDao.findAll();
        if (users != null && !users.isEmpty()) {
            System.out.println("All Users:");
            for (UserModel user : users) {
                System.out.println(user);
            }
        } else {
            System.out.println("No users found.");
        }

        int userId = 1;
        UserModel user = userDao.findById(userId);
        if (user != null) {
            System.out.println("User found: " + user);
        } else {
            System.out.println("User with ID " + userId + " not found.");
        }

        UserModel newUser = new UserModel("5", "Nguyen Van A", "2000-01-01", "password123");
        userDao.insert(newUser);
        System.out.println("New user inserted.");
    }
}
