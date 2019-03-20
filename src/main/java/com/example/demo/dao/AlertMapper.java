package com.example.demo.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AlertMapper {

    public List getAllAlert();

    public List getAlertByDate(@Param("date")String date);
}
