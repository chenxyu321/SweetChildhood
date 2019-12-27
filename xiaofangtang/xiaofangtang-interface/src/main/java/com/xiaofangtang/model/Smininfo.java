package com.xiaofangtang.model;

import java.io.Serializable;

public class Smininfo implements Serializable {
    private String id;

    private String sname;

    private String ssex;

    private String sbirth;

    private String sminzu;

    private String snianji;

    private String sjiguan;

    private String stechang;

    private String saihao;

    private String slixiang;

    private String srongyu;

    private String saddress;

    private String sinfo;

    private String sphotopath;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname == null ? null : sname.trim();
    }

    public String getSsex() {
        return ssex;
    }

    public void setSsex(String ssex) {
        this.ssex = ssex == null ? null : ssex.trim();
    }

    public String getSbirth() {
        return sbirth;
    }

    public void setSbirth(String sbirth) {
        this.sbirth = sbirth == null ? null : sbirth.trim();
    }

    public String getSminzu() {
        return sminzu;
    }

    public void setSminzu(String sminzu) {
        this.sminzu = sminzu == null ? null : sminzu.trim();
    }

    public String getSnianji() {
        return snianji;
    }

    public void setSnianji(String snianji) {
        this.snianji = snianji == null ? null : snianji.trim();
    }

    public String getSjiguan() {
        return sjiguan;
    }

    public void setSjiguan(String sjiguan) {
        this.sjiguan = sjiguan == null ? null : sjiguan.trim();
    }

    public String getStechang() {
        return stechang;
    }

    public void setStechang(String stechang) {
        this.stechang = stechang == null ? null : stechang.trim();
    }

    public String getSaihao() {
        return saihao;
    }

    public void setSaihao(String saihao) {
        this.saihao = saihao == null ? null : saihao.trim();
    }

    public String getSlixiang() {
        return slixiang;
    }

    public void setSlixiang(String slixiang) {
        this.slixiang = slixiang == null ? null : slixiang.trim();
    }

    public String getSrongyu() {
        return srongyu;
    }

    public void setSrongyu(String srongyu) {
        this.srongyu = srongyu == null ? null : srongyu.trim();
    }

    public String getSaddress() {
        return saddress;
    }

    public void setSaddress(String saddress) {
        this.saddress = saddress == null ? null : saddress.trim();
    }

    public String getSinfo() {
        return sinfo;
    }

    public void setSinfo(String sinfo) {
        this.sinfo = sinfo == null ? null : sinfo.trim();
    }

    public String getSphotopath() {
        return sphotopath;
    }

    public void setSphotopath(String sphotopath) {
        this.sphotopath = sphotopath == null ? null : sphotopath.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", sname=").append(sname);
        sb.append(", ssex=").append(ssex);
        sb.append(", sbirth=").append(sbirth);
        sb.append(", sminzu=").append(sminzu);
        sb.append(", snianji=").append(snianji);
        sb.append(", sjiguan=").append(sjiguan);
        sb.append(", stechang=").append(stechang);
        sb.append(", saihao=").append(saihao);
        sb.append(", slixiang=").append(slixiang);
        sb.append(", srongyu=").append(srongyu);
        sb.append(", saddress=").append(saddress);
        sb.append(", sinfo=").append(sinfo);
        sb.append(", sphotopath=").append(sphotopath);
        sb.append("]");
        return sb.toString();
    }
}