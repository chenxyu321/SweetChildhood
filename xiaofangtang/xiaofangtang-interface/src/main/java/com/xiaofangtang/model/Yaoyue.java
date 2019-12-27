package com.xiaofangtang.model;

import java.io.Serializable;

public class Yaoyue implements Serializable {
    private Integer id;

    private String sname;

    private String sage;

    private String tel;

    private String classes;

    private String ssex;

    private String iswx;

    private String time;

    private String info;

    private String daofang;

    private String tname;

    private String othername;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname == null ? null : sname.trim();
    }

    public String getSage() {
        return sage;
    }

    public void setSage(String sage) {
        this.sage = sage == null ? null : sage.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes == null ? null : classes.trim();
    }

    public String getSsex() {
        return ssex;
    }

    public void setSsex(String ssex) {
        this.ssex = ssex == null ? null : ssex.trim();
    }

    public String getIswx() {
        return iswx;
    }

    public void setIswx(String iswx) {
        this.iswx = iswx == null ? null : iswx.trim();
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info == null ? null : info.trim();
    }

    public String getDaofang() {
        return daofang;
    }

    public void setDaofang(String daofang) {
        this.daofang = daofang == null ? null : daofang.trim();
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname == null ? null : tname.trim();
    }

    public String getOthername() {
        return othername;
    }

    public void setOthername(String othername) {
        this.othername = othername == null ? null : othername.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", sname=").append(sname);
        sb.append(", sage=").append(sage);
        sb.append(", tel=").append(tel);
        sb.append(", classes=").append(classes);
        sb.append(", ssex=").append(ssex);
        sb.append(", iswx=").append(iswx);
        sb.append(", time=").append(time);
        sb.append(", info=").append(info);
        sb.append(", daofang=").append(daofang);
        sb.append(", tname=").append(tname);
        sb.append(", othername=").append(othername);
        sb.append("]");
        return sb.toString();
    }
}