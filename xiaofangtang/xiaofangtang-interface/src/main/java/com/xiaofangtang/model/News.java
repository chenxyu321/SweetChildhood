package com.xiaofangtang.model;

import java.io.Serializable;

public class News implements Serializable {
    private Integer id;

    private String text;

    private String people;

    private String title;

    private String picpath;

    private String mintext;

    private String time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text == null ? null : text.trim();
    }

    public String getPeople() {
        return people;
    }

    public void setPeople(String people) {
        this.people = people == null ? null : people.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getPicpath() {
        return picpath;
    }

    public void setPicpath(String picpath) {
        this.picpath = picpath == null ? null : picpath.trim();
    }

    public String getMintext() {
        return mintext;
    }

    public void setMintext(String mintext) {
        this.mintext = mintext == null ? null : mintext.trim();
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
        sb.append(", text=").append(text);
        sb.append(", people=").append(people);
        sb.append(", title=").append(title);
        sb.append(", picpath=").append(picpath);
        sb.append(", mintext=").append(mintext);
        sb.append(", time=").append(time);
        sb.append("]");
        return sb.toString();
    }
}