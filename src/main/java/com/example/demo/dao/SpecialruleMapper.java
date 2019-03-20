package com.example.demo.dao;

import com.example.demo.pojo.Specialrule;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SpecialruleMapper {

    public List getSpecialruleBySourceid(@Param("sourceid")Integer sourceid);

    public Specialrule getSpecialrule(@Param("sourceid")Integer sourceid, @Param("specialname")String specialname);

    public Integer changeSpecialrule(@Param("sourceid")Integer sourceid, @Param("special_name")String special_name, @Param("start")String start, @Param("end")String end,@Param("recovery")String recovery, @Param("alert_status")Integer alert_status);

    public Integer removeSpecialrule(@Param("sourceid")Integer sourceid, @Param("specialname")String specialname);

    public Integer addSpecialrule(@Param("sourceid")Integer sourceid, @Param("name")String name, @Param("start")String start, @Param("end")String end,@Param("recovery")String recovery, @Param("status")Integer status);
}
