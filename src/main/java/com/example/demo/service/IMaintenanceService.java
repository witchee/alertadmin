package com.example.demo.service;

import java.util.List;

public interface IMaintenanceService {

    public List getMaintenanceBySourceid(Integer sourceid);

    public Integer addMaintenanceBySourceid(Integer sourceid,String detail,String start,String end);
}
