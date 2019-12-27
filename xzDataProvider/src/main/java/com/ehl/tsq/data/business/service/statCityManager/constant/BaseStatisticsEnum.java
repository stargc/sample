package com.ehl.tsq.data.business.service.statCityManager.constant;

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
    CSGFAJTJ1("CSGL-AJ-CSGFAJTJ1","城市高发案件top5","件"),
    CSGFAJTJ2("CSGL-AJ-CSGFAJTJ2","城市高发案件top5","件"),
    CSGFAJTJ3("CSGL-AJ-CSGFAJTJ3","城市高发案件top5","件"),
    CSGFAJTJ4("CSGL-AJ-CSGFAJTJ4","城市高发案件top5","件"),
    CSGFAJTJ5("CSGL-AJ-CSGFAJTJ5","城市高发案件top5","件"),
    AJSBFL("CSGL-AJSBFL","案件上报分类",""),
    RJCSL("CSGL-RJCSL","人均厕所量","个"),
    HWCLFB("CSGL-JDZYFB-HWCLFB","环卫车辆","个"),
    LJTFB("CSGL-JDZYFB-LJTFB","垃圾桶","个"),
    ZZZFB("CSGL-JDZYFB-ZZZFB","中转站","个"),
    CSSSSHGFD("CSGL-CSSSSHGFD","城市设施损坏高发地","件"),
    CSAJGFD("CSGL-CSAJGFD","城市案件高发地","件"),
    RAJSBSSDT("CSGL-RAJSBSSDT","案件上报实时动态","件"),//当月按日
    YAJSBSSDT("CSGL-YAJSBSSDT","案件上报实时动态","件"),//当年按月
    SXT("CSGL-CSSSSH-SXT","摄像头","个"),
    LD("CSGL-CSSSSH-LD","路灯","个"),
    JRSLL("CSGL-AJCLQK-JRSLL","今日受理量","件"),
    DCL("CSGL-AJCLQK-DCL","待处理","件"),
    BLZ("CSGL-AJCLQK-BLZ","办理中","件"),
    YBJ("CSGL-AJCLQK-YBJ","已办结","件"),
    CSSSSHLD("CSGL-CSSSSH-LD","路灯损坏数","个"),
    CSSSSHLJT("CSGL-CSSSSH-LJT","垃圾桶损坏数","个"),
    CSSSSHSXT("CSGL-CSSSSH-SXT","摄像头损坏数","个"),
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
