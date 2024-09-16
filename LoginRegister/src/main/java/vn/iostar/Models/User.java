package vn.iostar.Models;

import java.io.Serializable;
import java.sql.Date;

public class User implements Serializable {

    private static final long serialVersionUID = 1858601197457756912L;
    private int id;
    private String email;
    private String userName;
    private String fullName;
    private String passWord;
    private String avatar;
    private int roleid;
    private String phone;
    private Date createdDate;
    
    public User() {
    	
    }

    public User(int id, String email, String userName, String fullName, String passWord, String avatar, int roleid, String phone, Date createdDate) {
        super();
        this.id = id;
        this.email = email;
        this.userName = userName;
        this.fullName = fullName;
        this.passWord = passWord;
        this.avatar = avatar;
        this.roleid = roleid;
        this.phone = phone;
        this.createdDate = createdDate;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getUserName() {
        return userName;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPassWord() {
        return passWord;
    }

    public String getAvatar() {
        return avatar;
    }

    public int getRoleid() {
        return roleid;
    }

    public String getPhone() {
        return phone;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
