package com.wuang.library.dao.model;

import javax.persistence.*;

@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 书名
     */
    @Column(name = "bookName")
    private String bookname;

    /**
     * 出版社
     */
    @Column(name = "bookPress")
    private String bookpress;

    /**
     * 简介
     */
    @Column(name = "bookIntroduction")
    private String bookintroduction;

    /**
     * 书类id
     */
    @Column(name = "bookClass")
    private String bookclass;

    /**
     * 价格
     */
    @Column(name = "bookPice")
    private String bookpice;

    /**
     * 作者
     */
    @Column(name = "bookWriter")
    private String bookwriter;

    /**
     * 0表示可借阅，1表示已被借阅，2表示不可借阅
     */
    @Column(name = "bookState")
    private String bookstate;

    /**
     * 借阅次数
     */
    @Column(name = "borrowNum")
    private String borrownum;

    @Column(name = "createTime")
    private String createtime;

    @Column(name = "createId")
    private String createid;

    /**
     * 书籍编号
     */
    @Column(name = "bookCode")
    private String bookcode;

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
     * 获取书名
     *
     * @return bookName - 书名
     */
    public String getBookname() {
        return bookname;
    }

    /**
     * 设置书名
     *
     * @param bookname 书名
     */
    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    /**
     * 获取出版社
     *
     * @return bookPress - 出版社
     */
    public String getBookpress() {
        return bookpress;
    }

    /**
     * 设置出版社
     *
     * @param bookpress 出版社
     */
    public void setBookpress(String bookpress) {
        this.bookpress = bookpress;
    }

    /**
     * 获取简介
     *
     * @return bookIntroduction - 简介
     */
    public String getBookintroduction() {
        return bookintroduction;
    }

    /**
     * 设置简介
     *
     * @param bookintroduction 简介
     */
    public void setBookintroduction(String bookintroduction) {
        this.bookintroduction = bookintroduction;
    }

    /**
     * 获取书类id
     *
     * @return bookClass - 书类id
     */
    public String getBookclass() {
        return bookclass;
    }

    /**
     * 设置书类id
     *
     * @param bookclass 书类id
     */
    public void setBookclass(String bookclass) {
        this.bookclass = bookclass;
    }

    /**
     * 获取价格
     *
     * @return bookPice - 价格
     */
    public String getBookpice() {
        return bookpice;
    }

    /**
     * 设置价格
     *
     * @param bookpice 价格
     */
    public void setBookpice(String bookpice) {
        this.bookpice = bookpice;
    }

    /**
     * 获取作者
     *
     * @return bookWriter - 作者
     */
    public String getBookwriter() {
        return bookwriter;
    }

    /**
     * 设置作者
     *
     * @param bookwriter 作者
     */
    public void setBookwriter(String bookwriter) {
        this.bookwriter = bookwriter;
    }

    /**
     * 获取0表示可借阅，1表示已被借阅，2表示不可借阅
     *
     * @return bookState - 0表示可借阅，1表示已被借阅，2表示不可借阅
     */
    public String getBookstate() {
        return bookstate;
    }

    /**
     * 设置0表示可借阅，1表示已被借阅，2表示不可借阅
     *
     * @param bookstate 0表示可借阅，1表示已被借阅，2表示不可借阅
     */
    public void setBookstate(String bookstate) {
        this.bookstate = bookstate;
    }

    /**
     * 获取借阅次数
     *
     * @return borrowNum - 借阅次数
     */
    public String getBorrownum() {
        return borrownum;
    }

    /**
     * 设置借阅次数
     *
     * @param borrownum 借阅次数
     */
    public void setBorrownum(String borrownum) {
        this.borrownum = borrownum;
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

    /**
     * 获取书籍编号
     *
     * @return bookCode - 书籍编号
     */
    public String getBookcode() {
        return bookcode;
    }

    /**
     * 设置书籍编号
     *
     * @param bookcode 书籍编号
     */
    public void setBookcode(String bookcode) {
        this.bookcode = bookcode;
    }
}