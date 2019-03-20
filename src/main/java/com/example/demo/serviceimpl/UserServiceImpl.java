package com.example.demo.serviceimpl;

import com.example.demo.dao.UserMapper;
import com.example.demo.pojo.UserInfo;
import com.example.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "userService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userDao;

    @Override
    public List getAllUser() {
        return userDao.getAllUser();
    }

    @Override
    public List getAllSubUser() {
        return userDao.getAllSubUser();
    }

    @Override
    public List getUserByGroup(Integer user_group_id) {
        return userDao.getUserByGroup(user_group_id);
    }

    @Override
    public List getUserBySourceid(Integer sourceid) {
        return userDao.getUserBySourceid(sourceid);
    }

    @Override
    public UserInfo getUserById(Integer user_id) {
        return userDao.getUserById(user_id);
    }

    @Override
    public Integer removeUser(Integer sourceid, Integer user_id) {
        return userDao.removeUser(sourceid,user_id);
    }

    @Override
    public List getUserExceptSourceid(Integer sourceid) {
        return userDao.getUserExceptSourceid(sourceid);
    }

    @Override
    public List getUserExceptGroup(Integer user_group_id) {
        return userDao.getUserExceptGroup(user_group_id);
    }

    @Override
    public Integer addSourceUser(Integer sourceid, Integer userid) {
        return userDao.addSourceUser(sourceid,userid);
    }

    @Override
    public Integer addGroupUser(Integer user_group_id, Integer userid) {
        return userDao.addGroupUser(user_group_id,userid);
    }

    @Override
    public Integer addUser(String username) {
        return userDao.addUser(username);
    }

    @Override
    public Integer addSubUser(String username, String telephone, String createname) {
        return userDao.addSubUser(username,telephone,createname);
    }

    @Override
    public Integer changeSubUser(Integer userid, String username, String telephone,Integer version) {
        return userDao.changeSubUser(userid,username,telephone,version);
    }

    @Override
    public Integer removeGroupUser(Integer usergroupid, Integer userid) {
        return userDao.removeGroupUser(usergroupid,userid);
    }
}
