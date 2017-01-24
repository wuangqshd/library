package com.wuang.library.dao.model;

import javax.persistence.*;

@Table(name = "otherset")
public class Otherset {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "setName")
    private String setname;

    @Column(name = "setValue")
    private String setvalue;

    @Column(name = "setSate")
    private String setsate;

    @Column(name = "createTime")
    private String createtime;

    @Column(name = "createId")
    private String createid;

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return setName
     */
    public String getSetname() {
        return setname;
    }

    /**
     * @param setname
     */
    public void setSetname(String setname) {
        this.setname = setname;
    }

    /**
     * @return setValue
     */
    public String getSetvalue() {
        return setvalue;
    }

    /**
     * @param setvalue
     */
    public void setSetvalue(String setvalue) {
        this.setvalue = setvalue;
    }

    /**
     * @return setSate
     */
    public String getSetsate() {
        return setsate;
    }

    /**
     * @param setsate
     */
    public void setSetsate(String setsate) {
        this.setsate = setsate;
    }

    /**
     * @return createTime
     */
    public String getCreatetime() {
        return createtime;
    }

    /**
     * @param createtime
     */
    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    /**
     * @return createId
     */
    public String getCreateid() {
        return createid;
    }

    /**
     * @param createid
     */
    public void setCreateid(String createid) {
        this.createid = createid;
    }
}