package vn.iostar.Models;

import java.io.Serializable;

public class UserModel implements Serializable {

    private static final long serialVersionUID = 1858601197457756912L;
    private String id;
    private String hoTen;
    private String ngaySinh;
    private String matKhau;

    public UserModel(String id, String hoTen, String ngaySinh, String matKhau) {
        super();
        this.id = id;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.matKhau = matKhau;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    @Override
    public String toString() {
        return "UserModel [id=" + id + ", hoTen=" + hoTen + ", ngaySinh=" + ngaySinh + ", matKhau=" + matKhau + "]";
    }
}
