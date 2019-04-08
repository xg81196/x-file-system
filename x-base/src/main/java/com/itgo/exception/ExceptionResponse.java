package com.itgo.exception;


import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Create by xb
 * The file is [ ExceptionResponse] on [ x-file-system ] project
 * The file path is com.itgo.exception.ExceptionResponse
 *
 * @versio 1.0.0
 * @Author he ming xi
 * @date 2019/4/8 15:01
 * @description
 *      校验参数异常返回对象
 */
public class ExceptionResponse<T> {


    private static final String PATTERN = "yyyy-MM-dd HH:mm:ss.SSS";

    private int code;
    private String message;
    private String timestamp;
    private T returnData;
    private String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public ExceptionResponse(int code, String message, Date date) {
        this.code = code;
        this.message = message;
        this.timestamp =  new SimpleDateFormat(PATTERN).format(date);
    }

    public ExceptionResponse(int code, String message, Date date,T returnData,String path) {
        this.code = code;
        this.message = message;
        this.timestamp =  new SimpleDateFormat(PATTERN).format(date);
        this.returnData = returnData;
        this.path = path;
    }

    public ExceptionResponse(int code, String message) {
        this.code = code;
        this.message = message;
        this.timestamp =  new SimpleDateFormat(PATTERN).format(new Date());
    }

    public ExceptionResponse() {
    }


    public T getReturnData() {
        return returnData;
    }

    public void setReturnData(T returnData) {
        this.returnData = returnData;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date date) {
        this.timestamp =  new SimpleDateFormat(PATTERN).format(date);
    }
}
