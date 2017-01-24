package com.wuang.library.dao.model;

import javax.persistence.*;

@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 用户编码
     */
    @Column(name = "userCode")
    private String usercode;

    /**
     * 借阅证号
     */
    @Column(name = "userBorrowCode")
    private String userborrowcode;

    /**
     * 身份证号
     */
    @Column(name = "userIdentityId")
    private String useridentityid;

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
     * 单位
     */
    @Column(name = "userCompany")
    private String usercompany;

    /**
     * 用户借阅权限
     */
    @Column(name = "ruleId")
    private String ruleid;

    /**
     * 用户组
     */
    @Column(name = "userClass")
    private String userclass;

    /**
     * 用户图片
     */
    @Column(name = "userPic")
    private String userpic;

    /**
     * 用户角色
     */
    @Column(name = "userRole")
    private String userrole;

    /**
     * 个人借阅本数（默认为0）
     */
    @Column(name = "userNum")
    private String usernum;

    /**
     * 个人借阅时长（默认为0）
     */
    @Column(name = "userTime")
    private String usertime;

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
     * 获取借阅证号
     *
     * @return userBorrowCode - 借阅证号
     */
    public String getUserborrowcode() {
        return userborrowcode;
    }

    /**
     * 设置借阅证号
     *
     * @param userborrowcode 借阅证号
     */
    public void setUserborrowcode(String userborrowcode) {
        this.userborrowcode = userborrowcode;
    }

    /**
     * 获取身份证号
     *
     * @return userIdentityId - 身份证号
     */
    public String getUseridentityid() {
        return useridentityid;
    }

    /**
     * 设置身份证号
     *
     * @param useridentityid 身份证号
     */
    public void setUseridentityid(String useridentityid) {
        this.useridentityid = useridentityid;
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
     * 获取用户借阅权限
     *
     * @return ruleId - 用户借阅权限
     */
    public String getRuleid() {
        return ruleid;
    }

    /**
     * 设置用户借阅权限
     *
     * @param ruleid 用户借阅权限
     */
    public void setRuleid(String ruleid) {
        this.ruleid = ruleid;
    }

    /**
     * 获取用户组
     *
     * @return userClass - 用户组
     */
    public String getUserclass() {
        return userclass;
    }

    /**
     * 设置用户组
     *
     * @param userclass 用户组
     */
    public void setUserclass(String userclass) {
        this.userclass = userclass;
    }

    /**
     * 获取用户图片
     *
     * @return userPic - 用户图片
     */
    public String getUserpic() {
        return userpic;
    }

    /**
     * 设置用户图片
     *
     * @param userpic 用户图片
     */
    public void setUserpic(String userpic) {
        this.userpic = userpic;
    }

    /**
     * 获取用户角色
     *
     * @return userRole - 用户角色
     */
    public String getUserrole() {
        return userrole;
    }

    /**
     * 设置用户角色
     *
     * @param userrole 用户角色
     */
    public void setUserrole(String userrole) {
        this.userrole = userrole;
    }

    /**
     * 获取个人借阅本数（默认为0）
     *
     * @return userNum - 个人借阅本数（默认为0）
     */
    public String getUsernum() {
        return usernum;
    }

    /**
     * 设置个人借阅本数（默认为0）
     *
     * @param usernum 个人借阅本数（默认为0）
     */
    public void setUsernum(String usernum) {
        this.usernum = usernum;
    }

    /**
     * 获取个人借阅时长（默认为0）
     *
     * @return userTime - 个人借阅时长（默认为0）
     */
    public String getUsertime() {
        return usertime;
    }

    /**
     * 设置个人借阅时长（默认为0）
     *
     * @param usertime 个人借阅时长（默认为0）
     */
    public void setUsertime(String usertime) {
        this.usertime = usertime;
    }
}