package com.ksj.Base.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="s_resource")
public class SysResource {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column (name="id",length=10)
    private int id;

    @Column(name="resourceurl",length=1000)
    private String resourcestring;//url

    @Column(name="resourceid",length=50)
    private String resourceid;//资源ID

    @Column(name="remark",length=200)
    private String remark;//备注

    @Column(name="resourcename",length=400)
    private String resourcename;//资源名称

    public String getResourcestring() {
        return resourcestring;
    }

    public void setResourcestring(String resourcestring) {
        this.resourcestring = resourcestring;
    }

    public String getResourcename() {
        return resourcename;
    }

    public void setResourcename(String resourcename) {
        this.resourcename = resourcename;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getResourceid() {
        return resourceid;
    }

    public void setResourceid(String resourceid) {
        this.resourceid = resourceid;
    }

    @Override
    public String toString() {
        return "SysResource{" +
                "id=" + id +
                ", resourcestring='" + resourcestring + '\'' +
                ", resourceid='" + resourceid + '\'' +
                ", remark='" + remark + '\'' +
                ", resourcename='" + resourcename + '\'' +
                '}';
    }
}

