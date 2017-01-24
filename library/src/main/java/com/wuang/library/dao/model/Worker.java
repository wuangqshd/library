package com.wuang.library.dao.model;

import javax.persistence.*;

@Table(name = "worker")
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 用户编码
     */
    @Column(name = "userCode")
    private String usercode;

    /**
     * 用户名
     */
    @Column(name = "userName")
    private String username;

    /**
     * 用户账号
     */
    @Column(name = "userAccount")
    private String useraccount;

    /**
     * 用户邮箱
     */
    @Column(name = "userMail")
    private String usermail;

    /**
     * 用户电话
     */
    @Column(name = "userPhone")
    private String userphone;

    /**
     * 用户密码
     */
    @Column(name = "userPasswd")
    private String userpasswd;

    /**
     * 年龄
     */
    @Column(name = "userAge")
    private String userage;

    /**
     * 生日
     */
    @Column(name = "userBirthday")
    private String userbirthday;

    /**
     * 状态
     */
    @Column(name = "userState")
    private String userstate;

    /**
     * 权限
     */
    @Column(name = "userPowerId")
    private String userpowerid;

    /**
     * 单位
     */
    @Column(name = "userCompany")
    private String usercompany;

    /**
     * 照片
     */
    @Column(name = "userPic")
    private String userpic;

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
     * 获取用户编码
     *
     * @return userCode - 用户编码
     */
    public String getUsercode() {
        return usercode;
    }

    /**
     * 设置用户编码
     *
     * @param usercode 用户编码
     */
    public void setUsercode(String usercode) {
        this.usercode = usercode;
    }

    /**
     * 获取用户名
     *
     * @return userName - 用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用户名
     *
     * @param username 用户名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取用户账号
     *
     * @return userAccount - 用户账号
     */
    public String getUseraccount() {
        return useraccount;
    }

    /**
     * 设置用户账号
     *
     * @param useraccount 用户账号
     */
    public void setUseraccount(String useraccount) {
        this.useraccount = useraccount;
    }

    /**
     * 获取用户邮箱
     *
     * @return userMail - 用户邮箱
     */
    public String getUsermail() {
        return usermail;
    }

    /**
     * 设置用户邮箱
     *
     * @param usermail 用户邮箱
     */
    public void setUsermail(String usermail) {
        this.usermail = usermail;
    }

    /**
     * 获取用户电话
     *
     * @return userPhone - 用户电话
     */
    public String getUserphone() {
        return userphone;
    }

    /**
     * 设置用户电话
     *
     * @param userphone 用户电话
     */
    public void setUserphone(String userphone) {
        this.userphone = userphone;
    }

    /**
     * 获取用户密码
     *
     * @return userPasswd - 用户密码
     */
    public String getUserpasswd() {
        return userpasswd;
    }

    /**
     * 设置用户密码
     *
     * @param userpasswd 用户密码
     */
    public void setUserpasswd(String userpasswd) {
        this.userpasswd = userpasswd;
    }

    /**
     * 获取年龄
     *
     * @return userAge - 年龄
     */
    public String getUserage() {
        return userage;
    }

    /**
     * 设置年龄
     *
     * @param userage 年龄
     */
    public void setUserage(String userage) {
        this.userage = userage;
    }

    /**
     * 获取生日
     *
     * @return userBirthday - 生日
     */
    public String getUserbirthday() {
        return userbirthday;
    }

    /**
     * 设置生日
     *
     * @param userbirthday 生日
     */
    public void setUserbirthday(String userbirthday) {
        this.userbirthday = userbirthday;
    }

    /**
     * 获取状态
     *
     * @return userState - 状态
     */
    public String getUserstate() {
        return userstate;
    }

    /**
     * 设置状态
     *
     * @param userstate 状态
     */
    public void setUserstate(String userstate) {
        this.userstate = userstate;
    }

    /**
     * 获取权限
     *
     * @return userPowerId - 权限
     */
    public String getUserpowerid() {
        return userpowerid;
    }

    /**
     * 设置权限
     *
     * @param userpowerid 权限
     */
    public void setUserpowerid(String userpowerid) {
        this.userpowerid = userpowerid;
    }

    /**
     * 获取单位
     *
     * @return userCompany - 单位
     */
    public String getUsercompany() {
        return usercompany;
    }

    /**
     * 设置单位
     *
     * @param usercompany 单位
     */
    public void setUsercompany(String usercompany) {
        this.usercompany = usercompany;
    }

    /**
     * 获取照片
     *
     * @return userPic - 照片
     */
    public String getUserpic() {
        return userpic;
    }

    /**
     * 设置照片
     *
     * @param userpic 照片
     */
    public void setUserpic(String userpic) {
        this.userpic = userpic;
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