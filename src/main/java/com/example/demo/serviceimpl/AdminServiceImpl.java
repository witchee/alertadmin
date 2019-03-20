package com.example.demo.serviceimpl;

import com.example.demo.dao.AdminMapper;
import com.example.demo.pojo.Administrator;
import com.example.demo.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "adminService")
public class AdminServiceImpl implements IAdminService {

    @Autowired
    private AdminMapper adminDao;

    @Override
    public Administrator findByNameAndPassword(String name, String password) {
        return adminDao.findByNameAndPassword(name,password);
    }

    @Override
    public Integer getVersionByName(String name) {
        return adminDao.getAdminByName(name).getVersion();
    }

    @Override
    public Integer changePasswordByName(String name, String password, Integer version) {
        return adminDao.changePasswordByName(name,password,version);
    }

    @Override
    public List getAllAdmin() {
        return adminDao.getAllAdmin();
    }

    @Override
    public Administrator getAdminByName(String name) {
        return adminDao.getAdminByName(name);
    }

    @Override
    public Integer changeAdmin(String admin_name, Integer manage_user, Integer manage_maintenance, Integer manage_admin, Integer version) {
        return adminDao.changeAdmin(admin_name,manage_user,manage_maintenance,manage_admin,version);
    }

    @Override
    public Integer addAdmin(String adminname, String password) {
        return adminDao.addAdmin(adminname,password);
    }
}
