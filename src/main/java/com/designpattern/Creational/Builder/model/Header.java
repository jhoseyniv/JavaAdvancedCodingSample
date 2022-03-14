package com.designpattern.Creational.Builder.model;

import java.time.ZonedDateTime;

public class Header {
    private String title;
    private String serialNo;
    private ZonedDateTime dateTime;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public ZonedDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(ZonedDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Header() {
    }

    public Header(String title, String serialNo, ZonedDateTime dateTime) {
        this.title = title;
        this.serialNo = serialNo;
        this.dateTime = dateTime;
    }
}
