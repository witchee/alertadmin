package com.example.demo.serviceimpl;

import com.example.demo.dao.AlertMapper;
import com.example.demo.dao.SourceMapper;
import com.example.demo.pojo.Alert;
import com.example.demo.pojo.Alertshow;
import com.example.demo.service.IAlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(value = "alertService")
public class AlertServiceImpl implements IAlertService {

    @Autowired
    private AlertMapper alertDao;

    @Autowired
    private SourceMapper sourceDao;

    @Override
    public List getAllAlert() {
        List alertlist = alertDao.getAllAlert();
        return package_alert(alertlist);
    }

    @Override
    public List getAlertByDate(String date) {
        List alertlist = alertDao.getAlertByDate(date);
        return package_alert(alertlist);
    }

    public List package_alert(List alertlist){
        List newalertlist=new ArrayList();
        for(int i = 0;i < alertlist.size();i++){
            Alertshow alert = new Alertshow();
            Alert a=(Alert)alertlist.get(i);
            alert.setName(a.getAlert_name());
            alert.setDetail(a.getAlert_detail() + " " + a.getAlert_value());
            alert.setTime(a.getAlert_time());
            alert.setLasttime(a.getLast_alert_time());
            alert.setRecoverytime(a.getRecovery_time());
            alert.setStatus(a.getAlert_status().equals("0") ? "已恢复" : "正在报警");
            String sourcename=sourceDao.getSourceBySourceid(a.getSource_id()).getSource_name();
            alert.setSource(sourcename);
            newalertlist.add(alert);
        }
        return newalertlist;
    }
}
