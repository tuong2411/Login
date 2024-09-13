package vn.iostar.Dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.iostar.Configs.DBConnection;
import vn.iostar.Dao.iUserDao;
import vn.iostar.Models.UserModel;

public class UserDaoImpl implements iUserDao {

	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;

	public List<UserModel> findAll() {
		String sql = "select * from ct4";
		List<UserModel> list = new ArrayList<>();
		try {
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				list.add(new UserModel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public UserModel findById(int id)
	{
		String sql = "Select * FROM ct4 WHERE id = ?";
		try {
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			if(rs.next())
			{
				return new UserModel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
		
			}
		}catch(Exception e){
				e.printStackTrace();
			}
		return null;
		}

	public void insert(UserModel user)
	{
		String sql = "Insert into ct4(id, hoTen, NgaySinh, matKhau) VALUES (?,?, ?, ?)";
		try {
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getId());
			ps.setString(2, user.getHoTen());
			ps.setString(3, user.getNgaySinh());
			ps.setString(4, user.getMatKhau());
			ps.executeUpdate();
			
			}catch(Exception e){
			e.printStackTrace();
		}
	}

	public class MainApp {

		public static void main(String[] args) {
			UserDaoImpl userDao = new UserDaoImpl();

			List<UserModel> users = userDao.findAll();

			if (users != null && !users.isEmpty()) {
				for (UserModel user : users) {
					System.out.println(user);
				}
			} else {
				System.out.println("No users found.");
			}

			UserModel user = userDao.findById(1);
			if (user != null) {
				System.out.println("User found: " + user);
			} else {
				System.out.println("User not found.");
			}
		}
	}
}
