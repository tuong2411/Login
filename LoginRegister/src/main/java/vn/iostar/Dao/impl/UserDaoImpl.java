package vn.iostar.Dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import vn.iostar.Models.User;
import vn.iostar.Dao.iUserDao;
import vn.iostar.configs.DBConnection;

public class UserDaoImpl implements iUserDao {
    
    public Connection conn = null;
    public PreparedStatement ps = null;
    public ResultSet rs = null;


    @Override
    public User get(String username) {
        User user = null;
        String query = "SELECT * FROM users WHERE username = ?";

        try {
        	DBConnection dbConnection = new DBConnection();
        	conn = dbConnection.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, username); 
            rs = ps.executeQuery();

            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setEmail(rs.getString("email"));
                user.setUserName(rs.getString("username"));
                user.setFullName(rs.getString("full_name"));
                user.setPassWord(rs.getString("password"));
                user.setAvatar(rs.getString("avatar"));
                user.setRoleid(rs.getInt("role_id"));
                user.setPhone(rs.getString("phone"));
                user.setCreatedDate(rs.getDate("created_date"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return user;
    }

    public boolean addUser(User user) {
        String query = "INSERT INTO users (email, username, full_name, password, avatar, role_id, phone, created_date) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try {
        	DBConnection dbConnection = new DBConnection();
        	conn = dbConnection.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getUserName());
            ps.setString(3, user.getFullName());
            ps.setString(4, user.getPassWord());
            ps.setString(5, user.getAvatar());
            ps.setInt(6, user.getRoleid());
            ps.setString(7, user.getPhone());
            ps.setDate(8, user.getCreatedDate());

            return ps.executeUpdate() > 0; 
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return false;
    }

    private void closeResources() {
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
