package com.xiaofangtang.model;

import java.io.Serializable;

public class Chengguophoto implements Serializable {
    private Integer id;

    private String photopath;

    private String chengguoid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhotopath() {
        return photopath;
    }

    public void setPhotopath(String photopath) {
        this.photopath = photopath == null ? null : photopath.trim();
    }

    public String getChengguoid() {
        return chengguoid;
    }

    public void setChengguoid(String chengguoid) {
        this.chengguoid = chengguoid == null ? null : chengguoid.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", photopath=").append(photopath);
        sb.append(", chengguoid=").append(chengguoid);
        sb.append("]");
        return sb.toString();
    }
}