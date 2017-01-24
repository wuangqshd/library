package com.wuang.library.dao.model;

import javax.persistence.*;

@Table(name = "pager")
public class Pager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 菜单名称
     */
    @Column(name = "menuName")
    private String menuname;

    /**
     * 菜单描述
     */
    @Column(name = "menuAbout")
    private String menuabout;

    /**
     * 创建人id 
     */
    @Column(name = "createId")
    private String createid;

    /**
     * 菜单路径
     */
    @Column(name = "menuUrl")
    private String menuurl;

    /**
     * 呈现方式
     */
    @Column(name = "pageTarget")
    private String pagetarget;

    /**
     * 创建时间
     */
    @Column(name = "createTime")
    private String createtime;

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
     * 获取菜单描述
     *
     * @return menuAbout - 菜单描述
     */
    public String getMenuabout() {
        return menuabout;
    }

    /**
     * 设置菜单描述
     *
     * @param menuabout 菜单描述
     */
    public void setMenuabout(String menuabout) {
        this.menuabout = menuabout;
    }

    /**
     * 获取创建人id 
     *
     * @return createId - 创建人id 
     */
    public String getCreateid() {
        return createid;
    }

    /**
     * 设置创建人id 
     *
     * @param createid 创建人id 
     */
    public void setCreateid(String createid) {
        this.createid = createid;
    }

    /**
     * 获取菜单路径
     *
     * @return menuUrl - 菜单路径
     */
    public String getMenuurl() {
        return menuurl;
    }

    /**
     * 设置菜单路径
     *
     * @param menuurl 菜单路径
     */
    public void setMenuurl(String menuurl) {
        this.menuurl = menuurl;
    }

    /**
     * 获取呈现方式
     *
     * @return pageTarget - 呈现方式
     */
    public String getPagetarget() {
        return pagetarget;
    }

    /**
     * 设置呈现方式
     *
     * @param pagetarget 呈现方式
     */
    public void setPagetarget(String pagetarget) {
        this.pagetarget = pagetarget;
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
}