package com.xiaofangtang.model;

import java.io.Serializable;

public class Huojiang implements Serializable {
    private Integer id;

    private String sid;

    private String matchname;

    private String jiangxiang;

    private String classes;

    private String time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid == null ? null : sid.trim();
    }

    public String getMatchname() {
        return matchname;
    }

    public void setMatchname(String matchname) {
        this.matchname = matchname == null ? null : matchname.trim();
    }

    public String getJiangxiang() {
        return jiangxiang;
    }

    public void setJiangxiang(String jiangxiang) {
        this.jiangxiang = jiangxiang == null ? null : jiangxiang.trim();
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes == null ? null : classes.trim();
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", sid=").append(sid);
        sb.append(", matchname=").append(matchname);
        sb.append(", jiangxiang=").append(jiangxiang);
        sb.append(", classes=").append(classes);
        sb.append(", time=").append(time);
        sb.append("]");
        return sb.toString();
    }
}