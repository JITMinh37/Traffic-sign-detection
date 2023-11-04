package com.example.navigationbottom.model;

import java.io.Serializable;

public class BienBao implements Serializable {
    private int id;
    private String maBienBao;
    private String noiDung;
    private String url;


    public BienBao(int id, String maBienBao, String noiDung, String url) {
        this.id = id;
        this.maBienBao = maBienBao;
        this.noiDung = noiDung;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaBienBao() {
        return maBienBao;
    }

    public void setMaBienBao(String maBienBao) {
        this.maBienBao = maBienBao;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
