package com.ehl.tsq.data.business.strategy.cityManager;

public enum BaseStatisticsEnum {
    SY("SY-SCJG-SPAQ-CCPC","食品抽查批次",""),
    HBCL("CSGL-CSJCSSSL-HBCL","环保车辆","辆"),
    WRJ("CSGL-CSJCSSSL-WRJ","无人机","个"),
    ZHLD("CSGL-CSJCSSSL-ZHLD","智慧路灯","个"),
    GC("CSGL-CSJCSSSL-GC","公厕","个"),
    LJT("CSGL-CSJCSSSL-LJT","垃圾桶","个"),
    LJZZZ("CSGL-CSJCSSSL-LJZZZ","垃圾中转站","个"),
    CSJCSSZS("CSGL-CSJCSSZS","全区设施总数","个"),
    AQJASL("CSGL-NAJCLQK-AQJASL","按期结案数量","件"),
    LASL("CSGL-NAJCLQK-LASL","立案数量","件"),
    YJASL("CSGL-NAJCLQK-YJASL","应结案数量","件"),
    JASL("CSGL-NAJCLQK-JASL","结案数量","件"),
    NAJSBZS("CSGL-NAJSBZS","案件上报总数","件"),
    LDWDL("CSGL-AJ-SJLAJ-LDWDL","乱堆物堆料","件"),
    ZDTD("CSGL-AJ-SJLAJ-ZDTD","占道摊点","个"),
    DWJY("CSGL-AJ-SJLAJ-DWJY","店外经营","个"),
    TXJG("CSGL-AJ-BJLAJ-TXJG","通讯敬爱","个"),
    HSSS("CSGL-AJ-BJLAJ-HSSS","护树设施","个"),
    XCL("CSGL-AJ-BJLAJ-XCL","宣传栏","个"),
    SR("CSGL-AJSBFL-SR","市容","件"),
    SZ("CSGL-AJSBFL-SZ","市政","件"),
    GG("CSGL-AJSBFL-GG","广告","件"),
    TXC("CSGL-AJSBFL-TXC","停洗车","件"),
    RJCSL("CSGL-RJCSL","人均厕所量","个"),
    HWCLFB("CSGL-JDZYFB-HWCLFB","环卫车辆","个"),
    LJTFB("CSGL-JDZYFB-LJTFB","垃圾桶","个"),
    ZZZFB("CSGL-JDZYFB-ZZZFB","中转站","个"),
    CSSSSHGFD("CSGL-CSSSSHGFD","城市设施损坏高发地","件"),
    CSAJGFD("CSGL-CSAJGFD","城市案件高发地","件"),
    RAJSBSSDT("CSGL-RAJSBSSDT","案件上报实时动态","件"),
    SXT("CSGL-CSSSSH-SXT","摄像头","个"),
    LD("CSGL-CSSSSH-LD","路灯","个"),
    JRSLL("CSGL-AJCLQK-JRSLL","今日受理量","件"),
    DCL("CSGL-AJCLQK-DCL","待处理","件"),
    BLZ("CSGL-AJCLQK-BLZ","办理中","件"),
    YBJ("CSGL-AJCLQK-YBJ","已办结","件"),
    ;
    private String name;
    private String msg;
    private String unit;

    BaseStatisticsEnum(String name, String msg,String unit) {
        this.name = name;
        this.msg = msg;
        this.unit = unit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
