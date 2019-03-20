package com.example.demo.pojo;

public class Administrator {

    private String admin_name;
    private String admin_password;
    private Integer manage_user;
    private Integer manage_maintenance;
    private Integer manage_admin;
    private Integer version;

    public String getAdmin_name() {
        return admin_name;
    }

    public void setAdmin_name(String admin_name) {
        this.admin_name = admin_name;
    }

    public String getAdmin_password() {
        return admin_password;
    }

    public void setAdmin_password(String admin_password) {
        this.admin_password = admin_password;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getManage_user() {
        return manage_user;
    }

    public void setManage_user(Integer manage_user) {
        this.manage_user = manage_user;
    }

    public Integer getManage_maintenance() {
        return manage_maintenance;
    }

    public void setManage_maintenance(Integer manage_maintenance) {
        this.manage_maintenance = manage_maintenance;
    }

    public Integer getManage_admin() {
        return manage_admin;
    }

    public void setManage_admin(Integer manage_admin) {
        this.manage_admin = manage_admin;
    }
}
