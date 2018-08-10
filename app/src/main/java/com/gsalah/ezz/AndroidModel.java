package com.gsalah.ezz;

import android.content.ContentValues;

public class AndroidModel {
    private Long id;
    private String name;
    private Double version;
    private Double api;

    public AndroidModel(Long id, String name, Double version, Double api) {
        this.id = id;
        this.name = name;
        this.version = version;
        this.api = api;
    }

    public AndroidModel(String name, Double version, Double api) {
        this.name = name;
        this.version = version;
        this.api = api;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getVersion() {
        return version;
    }

    public Double getApi() {
        return api;
    }

    public ContentValues toContentValues(){
        ContentValues contentValues=new ContentValues();
        contentValues.put("id",getId());
        contentValues.put("name",getName());
        contentValues.put("version",getVersion());
        contentValues.put("api",getApi());

        return contentValues;
    }

    @Override
    public String toString() {
        return "AndroidModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", version=" + version +
                ", api=" + api +
                '}';
    }
}
