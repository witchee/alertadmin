package com.example.demo.service;

import java.util.List;

public interface IIgnoreService {

    public List getIgnoreBySourceid(Integer sourceid);

    public void deleteIgnore(Integer sourceid,String ignore_name);

    public Integer addIgnore(Integer sourceid,String ignore_name);
}
