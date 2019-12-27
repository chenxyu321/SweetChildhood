package com.xiaofangtang.model;

import java.io.Serializable;

public class Huodong implements Serializable {
    private Integer id;

    private String sid;

    private String cid;

    private String zid;

    private String time;

    private String teacher;

    private String shixiang;

    private String chengguo;

    private String pingjia;

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

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid == null ? null : cid.trim();
    }

    public String getZid() {
        return zid;
    }

    public void setZid(String zid) {
        this.zid = zid == null ? null : zid.trim();
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher == null ? null : teacher.trim();
    }

    public String getShixiang() {
        return shixiang;
    }

    public void setShixiang(String shixiang) {
        this.shixiang = shixiang == null ? null : shixiang.trim();
    }

    public String getChengguo() {
        return chengguo;
    }

    public void setChengguo(String chengguo) {
        this.chengguo = chengguo == null ? null : chengguo.trim();
    }

    public String getPingjia() {
        return pingjia;
    }

    public void setPingjia(String pingjia) {
        this.pingjia = pingjia == null ? null : pingjia.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", sid=").append(sid);
        sb.append(", cid=").append(cid);
        sb.append(", zid=").append(zid);
        sb.append(", time=").append(time);
        sb.append(", teacher=").append(teacher);
        sb.append(", shixiang=").append(shixiang);
        sb.append(", chengguo=").append(chengguo);
        sb.append(", pingjia=").append(pingjia);
        sb.append("]");
        return sb.toString();
    }
}