package com.mapersive.insuranceservice.exceptions;

public class FileNotSupportedException extends Exception{
    private static final long serialVersionUID = 1L;

    private final String msg;

    public FileNotSupportedException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public String getMsg() {
        return this.msg;
    }
}
