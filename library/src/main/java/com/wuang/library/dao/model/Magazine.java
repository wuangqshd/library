package com.wuang.library.dao.model;

import javax.persistence.*;

@Table(name = "magazine")
public class Magazine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 名称
     */
    @Column(name = "magazineName")
    private String magazinename;

    /**
     * 种类
     */
    @Column(name = "magazineClass")
    private String magazineclass;

    /**
     * 价格
     */
    @Column(name = "magazinePrice")
    private String magazineprice;

    /**
     * 杂志出版社
     */
    @Column(name = "magazinePress")
    private String magazinepress;

    /**
     * 杂志简介
     */
    @Column(name = "magazineIntroduction")
    private String magazineintroduction;

    /**
     * 杂志编码
     */
    @Column(name = "magazineCode")
    private String magazinecode;

    /**
     * 创建时间
     */
    @Column(name = "createTime")
    private String createtime;

    /**
     * 创建人ID
     */
    @Column(name = "createId")
    private String createid;

    /**
     * 状态
     */
    @Column(name = "magazineState")
    private String magazinestate;

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
     * 获取名称
     *
     * @return magazineName - 名称
     */
    public String getMagazinename() {
        return magazinename;
    }

    /**
     * 设置名称
     *
     * @param magazinename 名称
     */
    public void setMagazinename(String magazinename) {
        this.magazinename = magazinename;
    }

    /**
     * 获取种类
     *
     * @return magazineClass - 种类
     */
    public String getMagazineclass() {
        return magazineclass;
    }

    /**
     * 设置种类
     *
     * @param magazineclass 种类
     */
    public void setMagazineclass(String magazineclass) {
        this.magazineclass = magazineclass;
    }

    /**
     * 获取价格
     *
     * @return magazinePrice - 价格
     */
    public String getMagazineprice() {
        return magazineprice;
    }

    /**
     * 设置价格
     *
     * @param magazineprice 价格
     */
    public void setMagazineprice(String magazineprice) {
        this.magazineprice = magazineprice;
    }

    /**
     * 获取杂志出版社
     *
     * @return magazinePress - 杂志出版社
     */
    public String getMagazinepress() {
        return magazinepress;
    }

    /**
     * 设置杂志出版社
     *
     * @param magazinepress 杂志出版社
     */
    public void setMagazinepress(String magazinepress) {
        this.magazinepress = magazinepress;
    }

    /**
     * 获取杂志简介
     *
     * @return magazineIntroduction - 杂志简介
     */
    public String getMagazineintroduction() {
        return magazineintroduction;
    }

    /**
     * 设置杂志简介
     *
     * @param magazineintroduction 杂志简介
     */
    public void setMagazineintroduction(String magazineintroduction) {
        this.magazineintroduction = magazineintroduction;
    }

    /**
     * 获取杂志编码
     *
     * @return magazineCode - 杂志编码
     */
    public String getMagazinecode() {
        return magazinecode;
    }

    /**
     * 设置杂志编码
     *
     * @param magazinecode 杂志编码
     */
    public void setMagazinecode(String magazinecode) {
        this.magazinecode = magazinecode;
    }

    /**
     * 获取创建时间
     *
     * @return createTime - 创建时间
     */
    public String getCreatetime() {
        return createtime;
    }

    /**
     * 设置创建时间
     *
     * @param createtime 创建时间
     */
    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    /**
     * 获取创建人ID
     *
     * @return createId - 创建人ID
     */
    public String getCreateid() {
        return createid;
    }

    /**
     * 设置创建人ID
     *
     * @param createid 创建人ID
     */
    public void setCreateid(String createid) {
        this.createid = createid;
    }

    /**
     * 获取状态
     *
     * @return magazineState - 状态
     */
    public String getMagazinestate() {
        return magazinestate;
    }

    /**
     * 设置状态
     *
     * @param magazinestate 状态
     */
    public void setMagazinestate(String magazinestate) {
        this.magazinestate = magazinestate;
    }
}