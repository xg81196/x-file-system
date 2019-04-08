package com.itgo.service.base.realize.bean.base;

import com.itgo.bean.BaseBean;

import java.sql.Date;

public class BookInfo extends BaseBean {
    private String bookCode;
    private String bookName;
    private Integer bookType;
    private String bookAuthor;
    private String publishPress;
    private Date publishDate;
    private Integer isBorrow;
    private String createdBy;
    private Date creationTime;
    private Date lastUpdatetime;

    public BookInfo() {
    }


    @Override
    public String toString() {
        return "BookInfo{" +
                "bookCode='" + bookCode + '\'' +
                ", bookName='" + bookName + '\'' +
                ", bookType=" + bookType +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", publishPress='" + publishPress + '\'' +
                ", publishDate=" + publishDate +
                ", isBorrow=" + isBorrow +
                ", createdBy='" + createdBy + '\'' +
                ", creationTime=" + creationTime +
                ", lastUpdatetime=" + lastUpdatetime +
                ", id=" + id +
                ", createUser=" + createUser +
                ", createName='" + createName + '\'' +
                ", createDate=" + createDate +
                ", createIp='" + createIp + '\'' +
                ", UpdateUser=" + UpdateUser +
                ", UpdateName='" + UpdateName + '\'' +
                ", UpdateDate=" + UpdateDate +
                ", UpdateIp='" + UpdateIp + '\'' +
                ", pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                '}';
    }

    public String getBookCode() {
        return bookCode;
    }

    public void setBookCode(String bookCode) {
        this.bookCode = bookCode;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Integer getBookType() {
        return bookType;
    }

    public void setBookType(Integer bookType) {
        this.bookType = bookType;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getPublishPress() {
        return publishPress;
    }

    public void setPublishPress(String publishPress) {
        this.publishPress = publishPress;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public Integer getIsBorrow() {
        return isBorrow;
    }

    public void setIsBorrow(Integer isBorrow) {
        this.isBorrow = isBorrow;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public Date getLastUpdatetime() {
        return lastUpdatetime;
    }

    public void setLastUpdatetime(Date lastUpdatetime) {
        this.lastUpdatetime = lastUpdatetime;
    }



    public String check(){
        String preifx = "书籍";
        String suffix = "不能为空！";
        if(bookCode==null && "".trim().equals(bookCode)){
            return  preifx+"代码"+suffix;
        }
        if(bookName==null && "".trim().equals(bookName)){
            return  preifx+"代码"+suffix;
        }
        if(bookCode==null && "".trim().equals(bookCode)){
            return  preifx+"代码"+suffix;
        }
        return "ok";
    }

}
