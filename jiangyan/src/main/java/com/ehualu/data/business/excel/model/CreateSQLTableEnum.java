package com.ehualu.data.business.excel.model;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum CreateSQLTableEnum {
//    a1("1","常住人口信息表","std_initial_person_info_hv","泰州市人口信息管理系统常住人口信息表"),
//    a2("2","重点人员数据信息表","std_initial_key_person_info_hv","泰州市市级情报平台重点人员数据信息表"),
//    a3("3","全国在逃人员信息表","std_initial_fugitive_person_info_hv","全国在逃人员信息表"),
//    a4("4","戒毒所人员信息","std_initial_treatment_addict_info_hv","泰州市监管专业系统戒毒所人员信息"),
//    a5("5","吸毒人员信息表","std_initial_addict_person_info_hv","泰州市警务基础平台吸毒人员信息表"),
//    a6("6","重点上访人员信息表","std_initial_petitioner_info_hv","江苏省泰州市政法委重点上访人员信息表"),
//    a7("7","涉疆关注人员信息表","std_initial_jiang_person_info_hv","泰州市警务基础平台涉疆关注人员信息表"),
//    a8("8","看守所人员信息表","std_inial_detention_house_person_info_hv","泰州市监管专业系统看守所人员信息表"),
//    a9("9","全国违法犯罪人员信息表","std_inial_crime_person_info_hv","泰州市省厅大平台全国违法犯罪人员信息表"),
//    a10("10","刑满释放人员花名册","std_inial_release_crime_person_info_hv","姜堰刑满释放人员花名册"),
//    a11("11","全国“两会”期间需关注的重点群体和重点人员","std_initial_key_meeting_person_info_hv","全国“两会”期间需关注的重点群体和重点人员"),
//    a12("12","侵财前科人员","std_initial_crime_record_person_info_hv","海陵区侵财前科人员"),
//    a13("13","贩毒前科人员","std_initial_addict_record_person_info_hv","海陵区贩毒前科人员"),
//    a14("14","居住证信息（16周岁以上流动人员）信息表","std_inial_transient_person_info_hv","泰州市居住证系统居住证信息（16周岁以上流动人员）信息表"),
//    a15("15","寄住人口信息表","std_inial_boarding_person_info_hv","泰州市居住证系统寄住人口信息表"),
//    a16("16","学生家长信息表","std_inial_parent_student_info_hv","姜堰学生家长信息表"),
//    a17("17","常住人口人像照片信息表","std_initial_person_image_info_hv","泰州市人口信息管理系统常住人口人像照片信息表"),
//    a18("18","体貌特征信息表","std_initial_person_feature_info_hv","泰州市警务基础平台体貌特征信息表"),
//    a19("19","婚姻登记信息","std_initial_marriafe_record_hv","姜堰婚姻登记信息"),
//    a20("20","劳动就业信息","std_initial_job_record_hv","姜堰劳动就业信息"),
//    a21("21","灵活就业人员信息","std_inial_flexible_job_record_hv","姜堰灵活就业人员信息"),
//    a22("22","个人纳税信息","std_initial_tax_record_hv","姜堰个人纳税信息"),
//    a23("23","社会参保人员信息","std_initial_insurance_record_hv","姜堰社会参保人员信息"),
//    a24("24","交通违法处罚信息表","std_initial_offence_record_hv","泰州市交管系统交通违法处罚信息表"),
//    a25("25","机动车驾驶人信息表","std_initial_dirver_info_hv","泰州市交管系统机动车驾驶人信息表"),
//    a26("26","机动车基本信息表","std_initial_asset_car_info_hv","泰州市交管系统机动车基本信息表"),
//    a27("27","铁路旅客订购票信息表","std_initial_train_record_hv","泰州市铁路部门铁路旅客订购票信息表"),
//    a28("28","民航进港信息表","std_initial_flight_record_hv","泰州市民航部门民航进港信息表"),
//    a29("29","民航进出港信息表","std_initial_civil_flight_record_hv","泰州市省厅社会资源民航进出港信息表"),
//    a30("30","出入境证件办理信息表","std_initial_exit_entry_record_hv","泰州市警务基础平台出入境证件办理信息表"),
//    a31("31","旅馆住宿人员信息表","std_initial_hotel_record_hv","泰州市治安旅馆业系统旅馆住宿人员信息表"),
//    a32("32","旅馆业系统单位基本信息表","std_initial_hotel_info_hv","泰州市治安旅馆业系统新旅馆业系统单位基本信息表"),
//    a33("33","网吧上网人员记录表","std_initial_internet_bar_record_hv","泰州市网吧系统上网人员信息表"),
//    a34("34","网吧机构信息表","std_inial_internet_bar_info_hv","泰州市网吧系统网吧机构信息表"),
//    a35("35","涉案银行卡银行卡一级账号表","std_initial_bank_card_info_hv","泰州市反诈骗系统涉案银行卡(银行卡一级账号表)"),
//    a36("36","支付宝银行卡信息表","std_inial_alipay_bank_card_info_hv","泰州市蛛网采集系统支付宝银行卡信息表"),
//    a37("37","三方账户主体查询银行卡结果","std_inial_third_party_bank_card_info_hv","泰州市反诈骗系统三方账户主体查询银行卡结果"),
//    a38("38","公安部银行卡申请结果表","std_inial_public_result_bank_card_info_hv","泰州市反诈骗系统公安部银行卡申请结果表"),
//    a39("39","公安部银行卡申请表","std_inial_public_bank_card_info_hv","泰州市反诈骗系统公安部银行卡申请表"),
//    a40("40","公安部银行卡申请明细查询结果表","std_inial_public_detail_result_bank_card_info_hv","泰州市反诈骗系统公安部银行卡申请明细查询结果表"),
//    a41("41","手机(含SIM)信息表","std_initial_telephone_record_hv","泰州市蛛网采集系统手机(含SIM)信息表"),
//    a42("42","入所人员手机卡信息表","std_inial_phone_card_info_hv","泰州市警务基础平台入所人员手机卡信息表"),
//    a43("43","通话记录信息表","std_inial_call_record_hv","泰州市蛛网采集系统通话记录信息表"),
//    a44("44","案件基本信息表","std_initial_case_info_hv","泰州市警务基础平台案件基本信息表"),
//    a45("45","案件嫌疑人信息表","std_initial_case_person_info_hv","泰州市警务基础平台案件嫌疑人信息表"),
//    a46("46","案件受害人信息表","std_initial_case_victim_person_info_hv","泰州市警务基础平台案件受害人信息表"),
//    a47("47","涉案物品信息表","std_initial_case_resource_info_hv","泰州市警务基础平台涉案物品信息表"),
//    a48("48","案件作案特点表","std_initial_case_feature_info_hv","泰州市警务基础平台案件作案特点"),
//    a49("49","处警信息表","std_initial_case_situation_info_hv","泰州市警务基础平台处警信息表"),
//    a50("50","现场手印痕迹信息表","std_initial_finger_print_info_hv","泰州市警务基础平台现场手印痕迹信息表"),
//    a51("51","现场足迹信息表","std_initial_foot_print_info_hv","泰州市警务基础平台现场足迹信息表"),
//    a52("52","现场生物痕迹信息表","std_initial_case_print_info_hv","泰州市警务基础平台现场生物痕迹信息表"),
//    a53("53","法律文书解剖尸体通知书信息表","std_initial_corpse_notification_info_hv","泰州市警务基础平台法律文书解剖尸体通知书信息表"),
//    a54("54","尸体检验信息表","std_initial_corpse_info_hv","泰州市警务基础平台尸体检验信息表"),
//    a55("55","人过留影报警信息","std_initial_face_alarm_info_hv","人过留影报警信息"),
    a57("57","手机通讯簿信息表","std_initial_phone_list_info_hv","泰州市蛛网采集系统手机通讯簿信息表")
    ;

    CreateSQLTableEnum(String index,String tableName, String name, String resourceName) {
        this.index = index;
        this.tableName = tableName;
        this.name = name;
        this.resourceName = resourceName;
    }

    private String index;
    private String tableName;
    private String name;
    private String resourceName;

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public static String getNameByResource(String resourceName){
        return Arrays.stream(CreateSQLTableEnum.values())
                .filter(table -> resourceName.equals(table.getResourceName()))
                .map(CreateSQLTableEnum::getName)
                .collect(Collectors.toList())
                .get(0);
    }
    public static String getTableNameByResource(String resourceName){
        return Arrays.stream(CreateSQLTableEnum.values())
                .filter(table -> resourceName.equals(table.getResourceName()))
                .map(CreateSQLTableEnum::getTableName)
                .collect(Collectors.toList())
                .get(0);
    }
    public static String getIndexByResource(String resourceName){
        return Arrays.stream(CreateSQLTableEnum.values())
                .filter(table -> resourceName.equals(table.getResourceName()))
                .map(CreateSQLTableEnum::getIndex)
                .collect(Collectors.toList())
                .get(0);
    }
}


