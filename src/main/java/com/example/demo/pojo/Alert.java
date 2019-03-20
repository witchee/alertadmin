package com.example.demo.pojo;

public class Alert {

    private Integer alert_id;
    private String alert_name;
    private String alert_detail;
    private String alert_time;
    private String last_alert_time;
    private String alert_status;
    private String recovery_time;
    private Integer source_id;
    private String alert_value;

    public String getAlert_name() {
        return alert_name;
    }

    public void setAlert_name(String alert_name) {
        this.alert_name = alert_name;
    }

    public String getAlert_time() {
        return alert_time;
    }

    public void setAlert_time(String alert_time) {
        this.alert_time = alert_time;
    }

    public String getAlert_status() {
        return alert_status;
    }

    public void setAlert_status(String alert_status) {
        this.alert_status = alert_status;
    }

    public String getRecovery_time() {
        return recovery_time;
    }

    public void setRecovery_time(String recovery_time) {
        this.recovery_time = recovery_time;
    }

    public Integer getAlert_id() {
        return alert_id;
    }

    public void setAlert_id(Integer alert_id) {
        this.alert_id = alert_id;
    }

    public String getAlert_detail() {
        return alert_detail;
    }

    public void setAlert_detail(String alert_detail) {
        this.alert_detail = alert_detail;
    }

    public String getLast_alert_time() {
        return last_alert_time;
    }

    public void setLast_alert_time(String last_alert_time) {
        this.last_alert_time = last_alert_time;
    }

    public Integer getSource_id() {
        return source_id;
    }

    public void setSource_id(Integer source_id) {
        this.source_id = source_id;
    }

    public String getAlert_value() {
        return alert_value;
    }

    public void setAlert_value(String alert_value) {
        this.alert_value = alert_value;
    }
}
