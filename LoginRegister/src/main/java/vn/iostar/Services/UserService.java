package vn.iostar.Services;

import vn.iostar.Models.User;

public interface UserService {
	User login(String username, String password);
	User get(String username);
}
