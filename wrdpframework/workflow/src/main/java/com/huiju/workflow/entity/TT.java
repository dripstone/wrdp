package com.huiju.workflow.entity;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class TT {
    private String detail;

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
