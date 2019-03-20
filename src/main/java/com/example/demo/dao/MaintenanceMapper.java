package com.example.demo.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MaintenanceMapper {

    public List getMaintenanceBySourceid(@Param("sourceid")Integer sourceid);

    public Integer addMaintenanceBySourceid(@Param("sourceid")Integer sourceid, @Param("detail")String detail, @Param("start")String start, @Param("end")String end);
}
