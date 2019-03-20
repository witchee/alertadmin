package com.example.demo.service;

import com.example.demo.pojo.Administrator;

import java.util.List;

public interface IAdminService {

    public Administrator findByNameAndPassword(String name, String password);

    public Integer getVersionByName(String name);

    public Integer changePasswordByName(String name,String password,Integer version);

    public List getAllAdmin();

    public Administrator getAdminByName(String name);

    public Integer changeAdmin(String admin_name,Integer manage_user,Integer manage_maintenance,Integer manage_admin,Integer version);

    public Integer addAdmin(String adminname,String password);
}
