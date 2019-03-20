package com.example.demo.serviceimpl;

import com.example.demo.dao.SourceMapper;
import com.example.demo.dao.UserMapper;
import com.example.demo.pojo.Source;
import com.example.demo.service.ISourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "sourceService")
public class SourceServiceImpl implements ISourceService {

    @Autowired
    private SourceMapper sourceDao;

    @Autowired
    private UserMapper userDao;

    @Override
    public List getAllSourceGroup() {
        return sourceDao.getAllSourceGroup();
    }

    @Override
    public Source getSourceBySourceid(Integer sourceid) {
        return sourceDao.getSourceBySourceid(sourceid);
    }

    @Override
    public Integer changeSourceBySourceid(Integer sourceid, String start, String end, String silent,String recovery) {
        Source s=sourceDao.getSourceBySourceid(sourceid);
        return sourceDao.changeSourceBySourceid(sourceid,start,end,silent,recovery,s.getVersion());
    }

    @Override
    public List getSourceByUserid(Integer userid) {
        return sourceDao.getSourceByUserid(userid);
    }

    @Override
    public List getSourceExceptUserid(Integer userid) {
        return sourceDao.getSourceExceptUserid(userid);
    }

    @Override
    public Integer removeSource(Integer userid, Integer sourceid) {
        return userDao.removeUser(sourceid,userid);
    }

    @Override
    public List getSourceBySourceGroupid(Integer sourcegroupid) {
        return sourceDao.getSourceBySourceGroupid(sourcegroupid);
    }
}
