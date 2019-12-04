package com.sample.tps.workbench;

public interface TpsJob {
    public boolean init();
    public void execute(String resultFlag) throws Exception;
    public boolean destory();

    public boolean isRuning();

}
