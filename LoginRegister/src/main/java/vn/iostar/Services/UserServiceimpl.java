package vn.iostar.Services;

import vn.iostar.Dao.impl.UserDaoImpl;
import vn.iostar.Models.User;

public class UserServiceimpl implements UserService{
	UserDaoImpl userDao = new UserDaoImpl();

	@Override
	public User login(String username, String password) {
		// TODO Auto-generated method stub
		User user = userDao.get(username);
		if(user != null && user.getPassWord().equals(password)) {
			return user;
		}
		return null;
	}

	@Override
	public User get(String username) {
		// TODO Auto-generated method stub
		return userDao.get(username);
	}
}
