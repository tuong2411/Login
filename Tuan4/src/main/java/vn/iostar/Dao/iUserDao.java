package vn.iostar.Dao;

import java.util.List;

import vn.iostar.Models.UserModel;
public interface iUserDao {
	List<UserModel> findAll();
	UserModel findById(int id);
	void insert(UserModel user);
}
