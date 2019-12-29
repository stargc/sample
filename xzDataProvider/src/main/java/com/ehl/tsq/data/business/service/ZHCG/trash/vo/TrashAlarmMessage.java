package com.ehl.tsq.data.business.service.ZHCG.trash.vo;

import com.ehl.tsq.data.infrastructure.persistence.po.ZHCGTrashWarning;
import lombok.Data;

/**
 * @author created by guanchen on 2019/12/29 13:32
 */
@Data
public class TrashAlarmMessage {
    private String id;
    private String cmd;
    private String deviceID; //设备编号
    private String version;
    private String time;//时间
    private TrashStateData data;//状态数据

    public ZHCGTrashWarning alarm2Bean(){
        ZHCGTrashWarning warning = new ZHCGTrashWarning();
        warning.setBattary(this.getData().getBattary());
        warning.setCmd(this.cmd);
        warning.setDistance(this.getData().getDistance());
        warning.setFull(this.data.getFull());
        warning.setPassTime(this.data.getPassTime());
        warning.setRssi(this.data.getRssi());
        warning.setSequence(this.data.getSequence());
        warning.setTemperature(this.data.getTemperature());
        warning.setTrashSensorId(this.deviceID);
        return warning;
    }
}
