package com.chiatai.module_designpatternes.chain_of_responsilly.impl;


import com.chiatai.module_designpatternes.chain_of_responsilly.ChainHandler;
import com.chiatai.module_designpatternes.chain_of_responsilly.ConstantLevel;
import com.chiatai.module_designpatternes.chain_of_responsilly.HandleResponse;

/**
 * @author : zhangqi
 * @time : 2020/9/14
 * desc : 处理对象2
 */
public class ChainHandlerTwo extends ChainHandler {
    @Override
    public int getHandleLevel() {
        return ConstantLevel.LEVEL_TWO;
    }

    @Override
    public HandleResponse handleMethod() {
        HandleResponse handleResponse = new HandleResponse();
        handleResponse.setResponseMessage("同意，同意，必须得同意");
        return handleResponse;
    }
}
