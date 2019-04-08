package com.itgo.service.base.realize.bean.base;

import com.itgo.bean.BaseBean;

/**
 * Create by xb
 * The file is [ Dictionary] on [ book-system ] project
 * The file path is com.example.booksystem.domain.Dictionary
 *
 * @versio 1.0.o
 * @Author he ming xi
 * @date 2019/4/6 13:22
 * @description
 */
public class Dictionary extends BaseBean {

    /**
     * 值集类型
     */
    private String codeType;

    /**
     * 类型名称
     */
    private String codeName;

    /**
     * 排序
     */
    private Integer sort;

    public String getCodeType() {
        return codeType;
    }

    public void setCodeType(String codeType) {
        this.codeType = codeType;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
