package com.kdu.smartHome.exception;

public class ErrorWhileExecutingQuery extends RuntimeException{
    public ErrorWhileExecutingQuery(String msg){
        super(msg);
    }
}
