package com.chiatai.module_designpatternes.chain_of_responsilly.impl;

import com.chiatai.module_designpatternes.chain_of_responsilly.ChainHandler;
import com.chiatai.module_designpatternes.chain_of_responsilly.ConstantLevel;
import com.chiatai.module_designpatternes.chain_of_responsilly.HandleResponse;

/**
 * @author : zhangqi
 * @time : 2020/9/14
 * desc :处理对象3
 */
public class ChainHandlerThree extends ChainHandler {
    @Override
    public int getHandleLevel() {
        return ConstantLevel.LEVEL_THREE;
    }

    @Override
    public HandleResponse handleMethod() {
        HandleResponse handleResponse  = new HandleResponse();
        handleResponse.setResponseMessage("既然大家都不处理请求，到我这肯定得同意啊！");
        return handleResponse;
    }
}
