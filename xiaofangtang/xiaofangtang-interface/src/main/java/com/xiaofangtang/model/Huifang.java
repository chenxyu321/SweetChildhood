package com.xiaofangtang.model;

import java.io.Serializable;

public class Huifang implements Serializable {
    private Integer id;

    private String yid;

    private String huifanginfo;

    private String huifangteacher;

    private String huifangtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getYid() {
        return yid;
    }

    public void setYid(String yid) {
        this.yid = yid == null ? null : yid.trim();
    }

    public String getHuifanginfo() {
        return huifanginfo;
    }

    public void setHuifanginfo(String huifanginfo) {
        this.huifanginfo = huifanginfo == null ? null : huifanginfo.trim();
    }

    public String getHuifangteacher() {
        return huifangteacher;
    }

    public void setHuifangteacher(String huifangteacher) {
        this.huifangteacher = huifangteacher == null ? null : huifangteacher.trim();
    }

    public String getHuifangtime() {
        return huifangtime;
    }

    public void setHuifangtime(String huifangtime) {
        this.huifangtime = huifangtime == null ? null : huifangtime.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", yid=").append(yid);
        sb.append(", huifanginfo=").append(huifanginfo);
        sb.append(", huifangteacher=").append(huifangteacher);
        sb.append(", huifangtime=").append(huifangtime);
        sb.append("]");
        return sb.toString();
    }
}