package com.sample.tps.util;

import com.sample.tps.jobs.ESBulkAddDataResultBean;
import lombok.Synchronized;

import java.util.ArrayList;
import java.util.List;

/**
 * @author created by guanchen on 2019/12/4 16:33
 */
public class GlobalValueUtil {
    private static List<ESBulkAddDataResultBean> esBulkResult = new ArrayList<>();

    private static List<Long> tpsList = new ArrayList<>();

    public static List<ESBulkAddDataResultBean> getEsBulkResult() {
        return esBulkResult;
    }

    @Synchronized
    public static void addEsBulkResult(ESBulkAddDataResultBean bean) {
        esBulkResult.add(bean);
    }

    public static List<Long> getTpsList() {
        return tpsList;
    }

    @Synchronized
    public static void addTps(long tps){
        tpsList.add(tps);
    }
}
