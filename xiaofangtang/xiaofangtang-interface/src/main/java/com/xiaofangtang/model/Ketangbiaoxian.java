package com.xiaofangtang.model;

import java.io.Serializable;

public class Ketangbiaoxian implements Serializable {
    private Integer id;

    private String sid;

    private String cid;

    private String zid;

    private String teacher;

    private String time;

    private String jilv;

    private String zhanxiannum;

    private String biaoxian;

    private String text1;

    private String text2;

    private String text3;

    private String jihua;

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

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher == null ? null : teacher.trim();
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }

    public String getJilv() {
        return jilv;
    }

    public void setJilv(String jilv) {
        this.jilv = jilv == null ? null : jilv.trim();
    }

    public String getZhanxiannum() {
        return zhanxiannum;
    }

    public void setZhanxiannum(String zhanxiannum) {
        this.zhanxiannum = zhanxiannum == null ? null : zhanxiannum.trim();
    }

    public String getBiaoxian() {
        return biaoxian;
    }

    public void setBiaoxian(String biaoxian) {
        this.biaoxian = biaoxian == null ? null : biaoxian.trim();
    }

    public String getText1() {
        return text1;
    }

    public void setText1(String text1) {
        this.text1 = text1 == null ? null : text1.trim();
    }

    public String getText2() {
        return text2;
    }

    public void setText2(String text2) {
        this.text2 = text2 == null ? null : text2.trim();
    }

    public String getText3() {
        return text3;
    }

    public void setText3(String text3) {
        this.text3 = text3 == null ? null : text3.trim();
    }

    public String getJihua() {
        return jihua;
    }

    public void setJihua(String jihua) {
        this.jihua = jihua == null ? null : jihua.trim();
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
        sb.append(", teacher=").append(teacher);
        sb.append(", time=").append(time);
        sb.append(", jilv=").append(jilv);
        sb.append(", zhanxiannum=").append(zhanxiannum);
        sb.append(", biaoxian=").append(biaoxian);
        sb.append(", text1=").append(text1);
        sb.append(", text2=").append(text2);
        sb.append(", text3=").append(text3);
        sb.append(", jihua=").append(jihua);
        sb.append("]");
        return sb.toString();
    }
}