package com.novel.common.pojo;

import java.util.Date;

public class TbType {
    private Long id;

    private Long netid;

    private String typename;

    private Date addtime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNetid() {
        return netid;
    }

    public void setNetid(Long netid) {
        this.netid = netid;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename == null ? null : typename.trim();
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }
}