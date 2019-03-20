package com.example.demo.dao;

import com.example.demo.pojo.Source;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SourceMapper {

    public List getAllSourceGroup();

    public Source getSourceBySourceid(@Param("sourceid")Integer sourceid);

    public Integer changeSourceBySourceid(@Param("sourceid")Integer sourceid, @Param("start")String start, @Param("end")String end, @Param("silent")String silent,@Param("recovery")String recovery,@Param("version")Integer version);

    public List getSourceByUserid(@Param("userid")Integer userid);

    public List getSourceExceptUserid(@Param("userid")Integer userid);

    public List getSourceBySourceGroupid(@Param("sourcegroupid")Integer sourcegroupid);
}
