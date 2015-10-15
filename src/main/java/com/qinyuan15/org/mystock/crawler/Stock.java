package com.qinyuan15.org.mystock.crawler;

public class Stock {
    private String name;
    private String code;
    private String queryName;

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public String getQueryName() {
        return queryName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setQueryName(String queryName) {
        this.queryName = queryName;
    }

    @Override
    public String toString() {
        return queryName + " " + code + " " + name;
    }
}
