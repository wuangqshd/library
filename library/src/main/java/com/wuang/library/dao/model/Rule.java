package com.wuang.library.dao.model;

import javax.persistence.*;

@Table(name = "rule")
public class Rule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 规则名称
     */
    @Column(name = "ruleName")
    private String rulename;

    /**
     * 规则简介
     */
    @Column(name = "ruleContext")
    private String rulecontext;

    /**
     * 借阅数
     */
    @Column(name = "ruleNum")
    private String rulenum;

    /**
     * 借阅时长
     */
    @Column(name = "ruleTime")
    private String ruletime;

    /**
     * 超时价格比率
     */
    @Column(name = "ruleOverPrice")
    private String ruleoverprice;

    /**
     * 状态
     */
    @Column(name = "ruleState")
    private String rulestate;

    /**
     * 创建人id
     */
    @Column(name = "createId")
    private String createid;

    /**
     * 开始时间
     */
    @Column(name = "startTime")
    private String starttime;

    /**
     * 停用时间
     */
    @Column(name = "endTime")
    private String endtime;

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
     * 获取规则名称
     *
     * @return ruleName - 规则名称
     */
    public String getRulename() {
        return rulename;
    }

    /**
     * 设置规则名称
     *
     * @param rulename 规则名称
     */
    public void setRulename(String rulename) {
        this.rulename = rulename;
    }

    /**
     * 获取规则简介
     *
     * @return ruleContext - 规则简介
     */
    public String getRulecontext() {
        return rulecontext;
    }

    /**
     * 设置规则简介
     *
     * @param rulecontext 规则简介
     */
    public void setRulecontext(String rulecontext) {
        this.rulecontext = rulecontext;
    }

    /**
     * 获取借阅数
     *
     * @return ruleNum - 借阅数
     */
    public String getRulenum() {
        return rulenum;
    }

    /**
     * 设置借阅数
     *
     * @param rulenum 借阅数
     */
    public void setRulenum(String rulenum) {
        this.rulenum = rulenum;
    }

    /**
     * 获取借阅时长
     *
     * @return ruleTime - 借阅时长
     */
    public String getRuletime() {
        return ruletime;
    }

    /**
     * 设置借阅时长
     *
     * @param ruletime 借阅时长
     */
    public void setRuletime(String ruletime) {
        this.ruletime = ruletime;
    }

    /**
     * 获取超时价格比率
     *
     * @return ruleOverPrice - 超时价格比率
     */
    public String getRuleoverprice() {
        return ruleoverprice;
    }

    /**
     * 设置超时价格比率
     *
     * @param ruleoverprice 超时价格比率
     */
    public void setRuleoverprice(String ruleoverprice) {
        this.ruleoverprice = ruleoverprice;
    }

    /**
     * 获取状态
     *
     * @return ruleState - 状态
     */
    public String getRulestate() {
        return rulestate;
    }

    /**
     * 设置状态
     *
     * @param rulestate 状态
     */
    public void setRulestate(String rulestate) {
        this.rulestate = rulestate;
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
     * 获取开始时间
     *
     * @return startTime - 开始时间
     */
    public String getStarttime() {
        return starttime;
    }

    /**
     * 设置开始时间
     *
     * @param starttime 开始时间
     */
    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    /**
     * 获取停用时间
     *
     * @return endTime - 停用时间
     */
    public String getEndtime() {
        return endtime;
    }

    /**
     * 设置停用时间
     *
     * @param endtime 停用时间
     */
    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }
}