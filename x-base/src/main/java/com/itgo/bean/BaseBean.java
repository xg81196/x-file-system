package com.itgo.bean;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * Create by xb
 * The file is [ BaseBean] on [ s-file-system ] project
 * The file path is com.itgo.bean.BaseBean
 *
 * @versio 1.0.0
 * @Author he ming xi
 * @date 2019/4/5 23:59
 * @description
 */
public class BaseBean implements Serializable {
    /**
     * ID
     */
    public Long id;

    /**
     * 创建用户
     */
    public Long createUser;

    /**
     * 创建用户名称
     */
    public String createName;

    /**
     * 创建日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date createDate;

    /**
     * 创建IP
     */
    public String createIp;

    /**
     * 修改用户
     */
    public Long UpdateUser;

    /**
     * 修改用户名称
     */
    public String UpdateName;

    /**
     * 修改日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date UpdateDate;

    /**
     * 修改IP
     */
    public String UpdateIp;

    /**
     * 页数
     */
    public Integer pageNum;

    /**
     * 页数大小
     */
    public Integer pageSize;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreateIp() {
        return createIp;
    }

    public void setCreateIp(String createIp) {
        this.createIp = createIp;
    }

    public Long getUpdateUser() {
        return UpdateUser;
    }

    public void setUpdateUser(Long updateUser) {
        UpdateUser = updateUser;
    }

    public String getUpdateName() {
        return UpdateName;
    }

    public void setUpdateName(String updateName) {
        UpdateName = updateName;
    }

    public Date getUpdateDate() {
        return UpdateDate;
    }

    public void setUpdateDate(Date updateDate) {
        UpdateDate = updateDate;
    }

    public String getUpdateIp() {
        return UpdateIp;
    }

    public void setUpdateIp(String updateIp) {
        UpdateIp = updateIp;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String check(){
        return "ok";
    }
}
