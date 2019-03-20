package com.example.demo.pojo;

public class Maintenance {

    private Integer maintenance_id;
    private String maintenance_detail;
    private String maintenance_starttime;
    private String maintenance_endtime;
    private Integer maintenance_status;
    private Integer source_id;

    public Integer getMaintenance_id() {
        return maintenance_id;
    }

    public void setMaintenance_id(Integer maintenance_id) {
        this.maintenance_id = maintenance_id;
    }

    public String getMaintenance_detail() {
        return maintenance_detail;
    }

    public void setMaintenance_detail(String maintenance_detail) {
        this.maintenance_detail = maintenance_detail;
    }

    public String getMaintenance_starttime() {
        return maintenance_starttime;
    }

    public void setMaintenance_starttime(String maintenance_starttime) {
        this.maintenance_starttime = maintenance_starttime;
    }

    public String getMaintenance_endtime() {
        return maintenance_endtime;
    }

    public void setMaintenance_endtime(String maintenance_endtime) {
        this.maintenance_endtime = maintenance_endtime;
    }

    public Integer getMaintenance_status() {
        return maintenance_status;
    }

    public void setMaintenance_status(Integer maintenance_status) {
        this.maintenance_status = maintenance_status;
    }

    public Integer getSource_id() {
        return source_id;
    }

    public void setSource_id(Integer source_id) {
        this.source_id = source_id;
    }
}
