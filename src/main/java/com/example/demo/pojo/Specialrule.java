package com.example.demo.pojo;

public class Specialrule {


    private Integer source_id;
    private String special_name;
    private String monitor_starttime;
    private String monitor_endtime;
    private Integer alert_status;
    private String recovery_time;

    public Integer getSource_id() {
        return source_id;
    }

    public void setSource_id(Integer source_id) {
        this.source_id = source_id;
    }

    public String getSpecial_name() {
        return special_name;
    }

    public void setSpecial_name(String special_name) {
        this.special_name = special_name;
    }

    public String getMonitor_starttime() {
        return monitor_starttime;
    }

    public void setMonitor_starttime(String monitor_starttime) {
        this.monitor_starttime = monitor_starttime;
    }

    public String getMonitor_endtime() {
        return monitor_endtime;
    }

    public void setMonitor_endtime(String monitor_endtime) {
        this.monitor_endtime = monitor_endtime;
    }

    public Integer getAlert_status() {
        return alert_status;
    }

    public void setAlert_status(Integer alert_status) {
        this.alert_status = alert_status;
    }

    public String getRecovery_time() {
        return recovery_time;
    }

    public void setRecovery_time(String recovery_time) {
        this.recovery_time = recovery_time;
    }
}
