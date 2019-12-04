package com.sample.tps.jobs;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author created by guanchen on 2019/12/4 16:33
 */
@Data
@AllArgsConstructor
public class ESBulkAddDataResultBean {
    private long threadID;
    private int responseCode;
    private long responseTime;

}
