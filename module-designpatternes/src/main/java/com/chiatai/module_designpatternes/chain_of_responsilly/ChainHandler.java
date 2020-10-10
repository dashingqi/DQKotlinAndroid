package com.chiatai.module_designpatternes.chain_of_responsilly;

/**
 * @author : zhangqi
 * @time : 2020/9/14
 * desc : 责任链处理对象的抽象类
 */
public abstract class ChainHandler {

    ChainHandler nextChainHandler;

    public final HandleResponse handleMessage(HandleRequest handleRequest) {

        HandleResponse handleResponse = null;

        /**
         * 当前请求的等级与自己的等级是相符合的，就进行处理
         * 如果不是自己等级范围内的，就传递给下一个对象来处理
         */
        if (this.getHandleLevel() == handleRequest.getHandleLevel()) {
            handleResponse = handleMethod();
        } else {
            /**
             * 当没有下一个对象来处理这个请求，就返回一个Response
             */
            if (nextChainHandler != null) {
                handleResponse = this.nextChainHandler.handleMessage(handleRequest);

            } else {
                handleResponse = new HandleResponse();
                handleResponse.setResponseMessage("没有对象来处理，拒绝你的请求");
            }
        }

        return handleResponse;

    }

    /**
     * 获取到每个对象能处理的级别
     *
     * @return
     */
    public abstract int getHandleLevel();

    /**
     * 每个处理对象的处理方法
     */
    public abstract HandleResponse handleMethod();

    /**
     * 设置处理下一个处理请求的对象
     *
     * @param handler
     */
    public void setNextChainHandler(ChainHandler handler) {
        nextChainHandler = handler;
    }
}
