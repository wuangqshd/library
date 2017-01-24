package com.wuang.library.dao.model;

import javax.persistence.*;

@Table(name = "borrow")
public class Borrow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 书id
     */
    @Column(name = "bookId")
    private String bookid;

    /**
     * 借阅者id
     */
    @Column(name = "userId")
    private String userid;

    /**
     * 借阅开始时间
     */
    @Column(name = "borrowTime")
    private String borrowtime;

    /**
     * 管理员id
     */
    @Column(name = "mangerId")
    private String mangerid;

    /**
     * 还书时间
     */
    @Column(name = "stillTime")
    private String stilltime;

    /**
     * 借阅状态
     */
    @Column(name = "borrowState")
    private String borrowstate;

    /**
     * 超市金额
     */
    @Column(name = "borrowOverPrice")
    private String borrowoverprice;

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
     * 获取书id
     *
     * @return bookId - 书id
     */
    public String getBookid() {
        return bookid;
    }

    /**
     * 设置书id
     *
     * @param bookid 书id
     */
    public void setBookid(String bookid) {
        this.bookid = bookid;
    }

    /**
     * 获取借阅者id
     *
     * @return userId - 借阅者id
     */
    public String getUserid() {
        return userid;
    }

    /**
     * 设置借阅者id
     *
     * @param userid 借阅者id
     */
    public void setUserid(String userid) {
        this.userid = userid;
    }

    /**
     * 获取借阅开始时间
     *
     * @return borrowTime - 借阅开始时间
     */
    public String getBorrowtime() {
        return borrowtime;
    }

    /**
     * 设置借阅开始时间
     *
     * @param borrowtime 借阅开始时间
     */
    public void setBorrowtime(String borrowtime) {
        this.borrowtime = borrowtime;
    }

    /**
     * 获取管理员id
     *
     * @return mangerId - 管理员id
     */
    public String getMangerid() {
        return mangerid;
    }

    /**
     * 设置管理员id
     *
     * @param mangerid 管理员id
     */
    public void setMangerid(String mangerid) {
        this.mangerid = mangerid;
    }

    /**
     * 获取还书时间
     *
     * @return stillTime - 还书时间
     */
    public String getStilltime() {
        return stilltime;
    }

    /**
     * 设置还书时间
     *
     * @param stilltime 还书时间
     */
    public void setStilltime(String stilltime) {
        this.stilltime = stilltime;
    }

    /**
     * 获取借阅状态
     *
     * @return borrowState - 借阅状态
     */
    public String getBorrowstate() {
        return borrowstate;
    }

    /**
     * 设置借阅状态
     *
     * @param borrowstate 借阅状态
     */
    public void setBorrowstate(String borrowstate) {
        this.borrowstate = borrowstate;
    }

    /**
     * 获取超市金额
     *
     * @return borrowOverPrice - 超市金额
     */
    public String getBorrowoverprice() {
        return borrowoverprice;
    }

    /**
     * 设置超市金额
     *
     * @param borrowoverprice 超市金额
     */
    public void setBorrowoverprice(String borrowoverprice) {
        this.borrowoverprice = borrowoverprice;
    }
}