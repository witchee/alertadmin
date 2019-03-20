package com.example.demo.service;

import com.example.demo.pojo.Specialrule;

import java.util.List;

public interface ISpecialruleService {

    public List getSpecialruleBySourceid(Integer sourceid);

    public Specialrule getSpecialrule(Integer sourceid,String specialname);

    public Integer changeSpecialrule(Integer sourceid,String special_name,String start,String end,String recovery,Integer alert_status);

    public Integer removeSpecialrule(Integer sourceid,String specialname);

    public Integer addSpecialrule(Integer sourceid,String name,String start,String end,String recovery,Integer status);
}
