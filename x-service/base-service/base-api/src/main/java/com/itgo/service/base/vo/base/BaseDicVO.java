package com.itgo.service.base.vo.base;

import com.itgo.vo.BaseBeanVO;

/**
 * Create by xb
 * The file is [ BaseDicVO] on [ x-file-system ] project
 * The file path is BaseDicVO
 *
 * @versio 1.0.o
 * @Author he ming xi
 * @date 2019/4/6 22:40
 * @description
 */
public class BaseDicVO extends BaseBeanVO {
    /**
     * 序列化ID
     */
    private static final long serialVersionUID = 5910274096989323850L;

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
