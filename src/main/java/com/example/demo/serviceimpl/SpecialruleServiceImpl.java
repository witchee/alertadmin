package com.example.demo.serviceimpl;

import com.example.demo.dao.IgnoreMapper;
import com.example.demo.dao.SpecialruleMapper;
import com.example.demo.pojo.Specialrule;
import com.example.demo.service.IIgnoreService;
import com.example.demo.service.ISpecialruleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "specialruleService")
public class SpecialruleServiceImpl implements ISpecialruleService {

    @Autowired
    private SpecialruleMapper specialruleDao;

    @Override
    public List getSpecialruleBySourceid(Integer sourceid) {
        return specialruleDao.getSpecialruleBySourceid(sourceid);
    }

    @Override
    public Specialrule getSpecialrule(Integer sourceid, String specialname) {
        return specialruleDao.getSpecialrule(sourceid,specialname);
    }

    @Override
    public Integer changeSpecialrule(Integer sourceid, String special_name, String start, String end, String recovery,Integer alert_status) {
        return specialruleDao.changeSpecialrule(sourceid,special_name,start,end,recovery,alert_status);
    }

    @Override
    public Integer removeSpecialrule(Integer sourceid, String specialname) {
        return specialruleDao.removeSpecialrule(sourceid,specialname);
    }

    @Override
    public Integer addSpecialrule(Integer sourceid, String name, String start, String end, String recovery,Integer status) {
        return specialruleDao.addSpecialrule(sourceid,name,start,end,recovery,status);
    }
}
