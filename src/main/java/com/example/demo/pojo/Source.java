package com.example.demo.pojo;

public class Source {

    private Integer source_id;
    private String source_name;
    private String monitor_starttime;
    private String monitor_endtime;
    private String silent_time;
    private String last_update_time;
    private Integer version;
    private String recovery_time;

    public Integer getSource_id() {
        return source_id;
    }

    public void setSource_id(Integer source_id) {
        this.source_id = source_id;
    }

    public String getSource_name() {
        return source_name;
    }

    public void setSource_name(String source_name) {
        this.source_name = source_name;
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

    public String getSilent_time() {
        return silent_time;
    }

    public void setSilent_time(String silent_time) {
        this.silent_time = silent_time;
    }

    public String getLast_update_time() {
        return last_update_time;
    }

    public void setLast_update_time(String last_update_time) {
        this.last_update_time = last_update_time;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getRecovery_time() {
        return recovery_time;
    }

    public void setRecovery_time(String recovery_time) {
        this.recovery_time = recovery_time;
    }
}
