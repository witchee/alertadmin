package com.example.demo.serviceimpl;

import com.example.demo.dao.MaintenanceMapper;
import com.example.demo.service.IMaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "maintenanceService")
public class MaintenanceServiceImpl implements IMaintenanceService {

    @Autowired
    private MaintenanceMapper maintenanceDao;

    @Override
    public List getMaintenanceBySourceid(Integer sourceid) {
        return maintenanceDao.getMaintenanceBySourceid(sourceid);
    }

    @Override
    public Integer addMaintenanceBySourceid(Integer sourceid, String detail, String start, String end) {
        start=start.replace("T", " ");
        end=end.replace("T", " ");
        return maintenanceDao.addMaintenanceBySourceid(sourceid,detail,start,end);
    }
}
