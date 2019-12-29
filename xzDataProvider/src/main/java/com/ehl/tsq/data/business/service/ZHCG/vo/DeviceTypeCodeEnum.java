package com.ehl.tsq.data.business.service.ZHCG.vo;

public enum DeviceTypeCodeEnum {
    HWCL("HWCL","环保车辆"),
    GC("GC","公共厕所"),
    ZZZ("ZZZ","中转站"),
    LJT("LJT","垃圾桶"),
    ZTC("ZTC","渣土车辆")
    ;

    private String code;
    private String name;



    DeviceTypeCodeEnum(String code, String msg) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
