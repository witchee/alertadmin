package com.example.demo.service;

import com.example.demo.pojo.UserInfo;

import java.util.List;

public interface IUserService {

    public List getAllUser();

    public List getAllSubUser();

    public List getUserByGroup(Integer user_group_id);

    public List getUserBySourceid(Integer sourceid);

    public UserInfo getUserById(Integer user_id);

    public Integer removeUser(Integer sourceid,Integer user_id);

    public List getUserExceptSourceid(Integer sourceid);

    public List getUserExceptGroup(Integer user_group_id);

    public Integer addSourceUser(Integer sourceid,Integer userid);

    public Integer addGroupUser(Integer user_group_id,Integer userid);

    public Integer addUser(String username);

    public Integer addSubUser(String username,String telephone,String createname);

    public Integer changeSubUser(Integer userid,String username,String telephone,Integer version);

    public Integer removeGroupUser(Integer usergroupid,Integer userid);
}
