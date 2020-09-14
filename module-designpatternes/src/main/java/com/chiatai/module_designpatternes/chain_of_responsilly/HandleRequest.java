package com.chiatai.module_designpatternes.chain_of_responsilly;

/**
 * @author : zhangqi
 * @time : 2020/9/14
 * desc : 请求
 */
public class HandleRequest {

    /**
     * 处理的请求
     */
    private int handleLevel;


    public int getHandleLevel() {
        return handleLevel;
    }

    public void setHandleLevel(int handleLevel) {
        this.handleLevel = handleLevel;
    }
}
