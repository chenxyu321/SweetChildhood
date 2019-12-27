package com.xiaofangtang.model;

import java.io.Serializable;

public class Teacher implements Serializable {
    private Integer id;

    private String tname;

    private Integer bumenid;

    private String nickname;

    private String password;

    private Integer quanxian;

    private String ruzhitime;

    private String birth;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname == null ? null : tname.trim();
    }

    public Integer getBumenid() {
        return bumenid;
    }

    public void setBumenid(Integer bumenid) {
        this.bumenid = bumenid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getQuanxian() {
        return quanxian;
    }

    public void setQuanxian(Integer quanxian) {
        this.quanxian = quanxian;
    }

    public String getRuzhitime() {
        return ruzhitime;
    }

    public void setRuzhitime(String ruzhitime) {
        this.ruzhitime = ruzhitime == null ? null : ruzhitime.trim();
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth == null ? null : birth.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", tname=").append(tname);
        sb.append(", bumenid=").append(bumenid);
        sb.append(", nickname=").append(nickname);
        sb.append(", password=").append(password);
        sb.append(", quanxian=").append(quanxian);
        sb.append(", ruzhitime=").append(ruzhitime);
        sb.append(", birth=").append(birth);
        sb.append("]");
        return sb.toString();
    }
}