package com.ehl.tsq.data.business.strategy.statCityManager.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * @author created by guanchen on 2019/12/21 16:40
 */
public class BaseStatisticsEnumTool {

    /** 今日进度 数量 **/
    public static final String CSGL_AJCLQK_DONE = "DONE";//已办结
    public static final String CSGL_AJCLQK_DOING = "DOING";//办理中
    public static final String CSGL_AJCLQK_ACCEPT = "ACCEPT";//待处理
    public static Map<String,BaseStatisticsEnum> CSGLAJCLQKMap = new HashMap<>();
    static {
        CSGLAJCLQKMap.put(CSGL_AJCLQK_DONE,BaseStatisticsEnum.YBJ);
        CSGLAJCLQKMap.put(CSGL_AJCLQK_DOING,BaseStatisticsEnum.BLZ);
        CSGLAJCLQKMap.put(CSGL_AJCLQK_ACCEPT,BaseStatisticsEnum.DCL);
    }

    /** 城市高发案件top5 **/
    public static Map<Integer,BaseStatisticsEnum> CSGFAJTJByMap = new HashMap<>();
    static {
        CSGFAJTJByMap.put(0,BaseStatisticsEnum.CSGFAJTJ1);
        CSGFAJTJByMap.put(1,BaseStatisticsEnum.CSGFAJTJ2);
        CSGFAJTJByMap.put(2,BaseStatisticsEnum.CSGFAJTJ3);
        CSGFAJTJByMap.put(3,BaseStatisticsEnum.CSGFAJTJ4);
        CSGFAJTJByMap.put(4,BaseStatisticsEnum.CSGFAJTJ5);
    }

}
