package com.example.demo.dao;

import com.example.demo.pojo.Administrator;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminMapper {

    public Administrator findByNameAndPassword(@Param("name") String name, @Param("password") String password);

    public Administrator getAdminByName(@Param("name") String name);

    public Integer changePasswordByName(@Param("name") String name, @Param("password") String password, @Param("version") Integer version);

    public List getAllAdmin();

    public Integer changeAdmin(@Param("admin_name")String admin_name, @Param("manage_user")Integer manage_user, @Param("manage_maintenance")Integer manage_maintenance, @Param("manage_admin")Integer manage_admin, @Param("version")Integer version);

    public Integer addAdmin(@Param("adminname")String adminname, @Param("password")String password);
}
