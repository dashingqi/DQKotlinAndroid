package com.chiatai.module_designpatternes.chain_of_responsilly.impl;

import com.chiatai.module_designpatternes.chain_of_responsilly.ChainHandler;
import com.chiatai.module_designpatternes.chain_of_responsilly.ConstantLevel;
import com.chiatai.module_designpatternes.chain_of_responsilly.HandleResponse;

/**
 * @author : zhangqi
 * @time : 2020/9/14
 * desc : 处理对象1
 */
public class ChainHandlerOne extends ChainHandler {
    @Override
    public int getHandleLevel() {
        return ConstantLevel.LEVEL_ONE;
    }

    @Override
    public HandleResponse handleMethod() {
        HandleResponse handleResponse = new HandleResponse();
        handleResponse.setResponseMessage("身为大总管，我的考虑一下......,没问题，同意吧！");
        return handleResponse;
    }
}
