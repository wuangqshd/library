package com.wuang.library.dao.model;

import javax.persistence.*;

@Table(name = "power")
public class Power {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 角色名称
     */
    @Column(name = "powerName")
    private String powername;

    /**
     * 权限页面
     */
    @Column(name = "pageIds")
    private String pageids;

    /**
     * 创建id
     */
    @Column(name = "createId")
    private String createid;

    /**
     * 创建时间
     */
    @Column(name = "createTime")
    private String createtime;

    /**
     * 状态
     */
    private String state;

    /**
     * 初始化菜单id
     */
    @Column(name = "startMod")
    private String startmod;

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
     * 获取角色名称
     *
     * @return powerName - 角色名称
     */
    public String getPowername() {
        return powername;
    }

    /**
     * 设置角色名称
     *
     * @param powername 角色名称
     */
    public void setPowername(String powername) {
        this.powername = powername;
    }

    /**
     * 获取权限页面
     *
     * @return pageIds - 权限页面
     */
    public String getPageids() {
        return pageids;
    }

    /**
     * 设置权限页面
     *
     * @param pageids 权限页面
     */
    public void setPageids(String pageids) {
        this.pageids = pageids;
    }

    /**
     * 获取创建id
     *
     * @return createId - 创建id
     */
    public String getCreateid() {
        return createid;
    }

    /**
     * 设置创建id
     *
     * @param createid 创建id
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
     * 获取状态
     *
     * @return state - 状态
     */
    public String getState() {
        return state;
    }

    /**
     * 设置状态
     *
     * @param state 状态
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * 获取初始化菜单id
     *
     * @return startMod - 初始化菜单id
     */
    public String getStartmod() {
        return startmod;
    }

    /**
     * 设置初始化菜单id
     *
     * @param startmod 初始化菜单id
     */
    public void setStartmod(String startmod) {
        this.startmod = startmod;
    }
}