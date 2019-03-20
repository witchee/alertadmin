package com.example.demo.serviceimpl;

import com.example.demo.dao.IgnoreMapper;
import com.example.demo.dao.SpecialMapper;
import com.example.demo.service.IIgnoreService;
import com.example.demo.service.ISpecialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "specialService")
public class ISpecialServiceImpl implements ISpecialService {

    @Autowired
    private SpecialMapper specialDao;

    @Override
    public List getSpecialByUserid(Integer userid) {
        return specialDao.getSpecialByUserid(userid);
    }

    @Override
    public Integer addSpecial(Integer userid, String special_name) {
        return specialDao.addSpecial(userid,special_name);
    }

    @Override
    public Integer deleteSpecial(Integer userid, String special_name) {
        return specialDao.deleteSpecial(userid,special_name);
    }
}
