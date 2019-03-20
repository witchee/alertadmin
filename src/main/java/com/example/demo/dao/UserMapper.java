package com.example.demo.dao;

import com.example.demo.pojo.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    public List getAllUser();

    public List getAllSubUser();

    public List getUserByGroup(@Param("user_group_id")Integer user_group_id);

    public List getUserBySourceid(@Param("sourceid")Integer sourceid);

    public UserInfo getUserById(@Param("user_id")Integer user_id);

    public Integer removeUser(@Param("sourceid")Integer sourceid, @Param("userid")Integer user_id);

    public List getUserExceptSourceid(@Param("sourceid")Integer sourceid);

    public List getUserExceptGroup(@Param("user_group_id")Integer user_group_id);

    public Integer addSourceUser(@Param("sourceid")Integer sourceid, @Param("userid")Integer userid);

    public Integer addUser(@Param("username")String username);

    public Integer addSubUser(@Param("username")String username, @Param("telephone")String telephone, @Param("createname")String createname);

    public Integer changeSubUser(@Param("userid")Integer userid, @Param("username")String username, @Param("telephone")String telephone,@Param("version")Integer version);

    public Integer addGroupUser(@Param("user_group_id")Integer user_group_id, @Param("userid")Integer userid);

    public Integer removeGroupUser(@Param("usergroupid")Integer usergroupid, @Param("userid")Integer userid);
}
