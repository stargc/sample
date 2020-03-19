package com.ehualu.data.business.svn.model;

public enum FilePermission {
    NONE("none","none"),
    READ("r","read"),
    WRITE("rw","readAndWrite");

    private String code;
    private String msg;

    FilePermission(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
