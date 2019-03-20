package com.example.demo.serviceimpl;

import com.example.demo.dao.IgnoreMapper;
import com.example.demo.service.IIgnoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "ignoreService")
public class IgnoreServiceImpl implements IIgnoreService {

    @Autowired
    private IgnoreMapper ignoreDao;

    @Override
    public List getIgnoreBySourceid(Integer sourceid) {
        return ignoreDao.getIgnoreBySourceid(sourceid);
    }

    @Override
    public void deleteIgnore(Integer sourceid, String ignore_name) {
        ignoreDao.deleteIgnore(sourceid,ignore_name);
    }

    @Override
    public Integer addIgnore(Integer sourceid, String ignore_name) {
        return ignoreDao.addIgnore(sourceid,ignore_name);
    }
}
