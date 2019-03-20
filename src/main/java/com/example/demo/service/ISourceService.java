package com.example.demo.service;

import com.example.demo.pojo.Source;

import java.util.List;

public interface ISourceService {

    public List getAllSourceGroup();

    public Source getSourceBySourceid(Integer sourceid);

    public Integer changeSourceBySourceid(Integer sourceid,String start,String end,String silent,String recovery);

    public List getSourceByUserid(Integer userid);

    public List getSourceExceptUserid(Integer userid);

    public Integer removeSource(Integer userid,Integer sourceid);

    public List getSourceBySourceGroupid(Integer sourcegroupid);
}
