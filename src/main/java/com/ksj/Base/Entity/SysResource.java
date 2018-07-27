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

    @Column(name="resource_url",length=1000)
    private String resource_url;//url

    @Column(name="resource_id",length=50)
    private String resource_id;//资源ID

    @Column(name="remark",length=200)
    private String remark;//备注

    @Column(name="resource_name",length=400)
    private String resource_name;//资源名称

    @Override
    public String toString() {
        return "SysResource{" +
                "id=" + id +
                ", resource_url='" + resource_url + '\'' +
                ", resource_id='" + resource_id + '\'' +
                ", remark='" + remark + '\'' +
                ", resource_name='" + resource_name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getResource_url() {
        return resource_url;
    }

    public void setResource_url(String resource_url) {
        this.resource_url = resource_url;
    }

    public String getResource_id() {
        return resource_id;
    }

    public void setResource_id(String resource_id) {
        this.resource_id = resource_id;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getResource_name() {
        return resource_name;
    }

    public void setResource_name(String resource_name) {
        this.resource_name = resource_name;
    }
}

