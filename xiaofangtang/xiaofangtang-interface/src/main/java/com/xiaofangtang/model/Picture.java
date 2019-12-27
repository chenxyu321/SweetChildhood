package com.xiaofangtang.model;

import java.io.Serializable;

public class Picture implements Serializable {
    private Integer picid;

    private String pictext;

    private String picpath;

    public Integer getPicid() {
        return picid;
    }

    public void setPicid(Integer picid) {
        this.picid = picid;
    }

    public String getPictext() {
        return pictext;
    }

    public void setPictext(String pictext) {
        this.pictext = pictext == null ? null : pictext.trim();
    }

    public String getPicpath() {
        return picpath;
    }

    public void setPicpath(String picpath) {
        this.picpath = picpath == null ? null : picpath.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", picid=").append(picid);
        sb.append(", pictext=").append(pictext);
        sb.append(", picpath=").append(picpath);
        sb.append("]");
        return sb.toString();
    }
}