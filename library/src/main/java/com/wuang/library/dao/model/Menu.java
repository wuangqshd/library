package com.wuang.library.dao.model;

import javax.persistence.*;

@Table(name = "menu")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 菜单级数
     */
    @Column(name = "menuRoot")
    private String menuroot;

    /**
     * 菜单名称
     */
    @Column(name = "menuName")
    private String menuname;

    /**
     * 父级菜单
     */
    @Column(name = "menuFatherId")
    private String menufatherid;

    /**
     * 对应页面do
     */
    @Column(name = "menuPageDo")
    private String menupagedo;

    /**
     * 页面呈现方式
     */
    @Column(name = "menuTarget")
    private String menutarget;

    /**
     * 创建人
     */
    @Column(name = "createId")
    private String createid;

    /**
     * 创建时间
     */
    @Column(name = "createTime")
    private String createtime;

    /**
     * 排序
     */
    private String sort;

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
     * 获取菜单级数
     *
     * @return menuRoot - 菜单级数
     */
    public String getMenuroot() {
        return menuroot;
    }

    /**
     * 设置菜单级数
     *
     * @param menuroot 菜单级数
     */
    public void setMenuroot(String menuroot) {
        this.menuroot = menuroot;
    }

    /**
     * 获取菜单名称
     *
     * @return menuName - 菜单名称
     */
    public String getMenuname() {
        return menuname;
    }

    /**
     * 设置菜单名称
     *
     * @param menuname 菜单名称
     */
    public void setMenuname(String menuname) {
        this.menuname = menuname;
    }

    /**
     * 获取父级菜单
     *
     * @return menuFatherId - 父级菜单
     */
    public String getMenufatherid() {
        return menufatherid;
    }

    /**
     * 设置父级菜单
     *
     * @param menufatherid 父级菜单
     */
    public void setMenufatherid(String menufatherid) {
        this.menufatherid = menufatherid;
    }

    /**
     * 获取对应页面do
     *
     * @return menuPageDo - 对应页面do
     */
    public String getMenupagedo() {
        return menupagedo;
    }

    /**
     * 设置对应页面do
     *
     * @param menupagedo 对应页面do
     */
    public void setMenupagedo(String menupagedo) {
        this.menupagedo = menupagedo;
    }

    /**
     * 获取页面呈现方式
     *
     * @return menuTarget - 页面呈现方式
     */
    public String getMenutarget() {
        return menutarget;
    }

    /**
     * 设置页面呈现方式
     *
     * @param menutarget 页面呈现方式
     */
    public void setMenutarget(String menutarget) {
        this.menutarget = menutarget;
    }

    /**
     * 获取创建人
     *
     * @return createId - 创建人
     */
    public String getCreateid() {
        return createid;
    }

    /**
     * 设置创建人
     *
     * @param createid 创建人
     */
    public void setCreateid(String createid) {
        this.createid = createid;
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
     * 获取排序
     *
     * @return sort - 排序
     */
    public String getSort() {
        return sort;
    }

    /**
     * 设置排序
     *
     * @param sort 排序
     */
    public void setSort(String sort) {
        this.sort = sort;
    }
}