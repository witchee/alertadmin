package com.example.demo.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IgnoreMapper {

    public List getIgnoreBySourceid(@Param("sourceid")Integer sourceid);

    public void deleteIgnore(@Param("sourceid")Integer sourceid,@Param("ignore_name")String ignore_name);

    public Integer addIgnore(@Param("sourceid")Integer sourceid, @Param("ignore_name")String ignore_name);
}
