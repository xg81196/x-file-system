package com.itgo.exception;

/**
 * @versio 1.0.0
 * @Author he ming xi
 * @date 2019/4/5 17:53
 * @description
 */
public class ObjectNotNullException extends Exception {

    public ObjectNotNullException(String message){
        super(message);
    }

    public ObjectNotNullException(){
        super("Object is null");
    }


}
