package com.xiaofangtang.model;

import java.io.Serializable;

public class Ruxuetest implements Serializable {
    private Integer id;

    private String sid;

    private String cid;

    private String text1;

    private String text2;

    private String text3;

    private String text4;

    private String text5;

    private String age;

    private String score;

    private String guihua;

    private String beizhu;

    private String teacher;

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

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid == null ? null : cid.trim();
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

    public String getText4() {
        return text4;
    }

    public void setText4(String text4) {
        this.text4 = text4 == null ? null : text4.trim();
    }

    public String getText5() {
        return text5;
    }

    public void setText5(String text5) {
        this.text5 = text5 == null ? null : text5.trim();
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age == null ? null : age.trim();
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score == null ? null : score.trim();
    }

    public String getGuihua() {
        return guihua;
    }

    public void setGuihua(String guihua) {
        this.guihua = guihua == null ? null : guihua.trim();
    }

    public String getBeizhu() {
        return beizhu;
    }

    public void setBeizhu(String beizhu) {
        this.beizhu = beizhu == null ? null : beizhu.trim();
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", sid=").append(sid);
        sb.append(", cid=").append(cid);
        sb.append(", text1=").append(text1);
        sb.append(", text2=").append(text2);
        sb.append(", text3=").append(text3);
        sb.append(", text4=").append(text4);
        sb.append(", text5=").append(text5);
        sb.append(", age=").append(age);
        sb.append(", score=").append(score);
        sb.append(", guihua=").append(guihua);
        sb.append(", beizhu=").append(beizhu);
        sb.append(", teacher=").append(teacher);
        sb.append(", time=").append(time);
        sb.append("]");
        return sb.toString();
    }
}