package com.example.demo.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SpecialMapper {

    public List getSpecialByUserid(@Param("userid") Integer userid);

    public Integer addSpecial(@Param("userid")Integer userid, @Param("special_name")String special_name);

    public Integer deleteSpecial(@Param("userid")Integer userid, @Param("special_name")String special_name);
}
