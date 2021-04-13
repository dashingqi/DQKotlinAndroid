package com.dashingqi.module.net

import com.dashingqi.dqhttp.call.BaseCallAdapterFactory
import com.dashingqi.dqhttp.service.NetService
import com.dashingqi.dqhttp.service.NetServiceBuilder

/**
 * @author : zhangqi
 * @time : 12/22/20
 * desc :
 */
object Service {

    val netService by lazy {
        createNetService()
    }

    val ZGYDService by lazy{
            createZGYDNetService()
    }

    private fun createNetService(): NetService {
        val netServiceBuilder = NetServiceBuilder()
        netServiceBuilder.setBaseUrl("https://www.wanandroid.com")
            .setIgnoreSSl(true)
            .setOkHttpClientBuilder {
            }
            .setRetrofitBuilder {
                it.addCallAdapterFactory(BaseCallAdapterFactory())
            }

        return netServiceBuilder.builder()
    }

    private fun createZGYDNetService(): NetService {
        val netServiceBuilder = NetServiceBuilder()
        netServiceBuilder.setBaseUrl("https://verify.cmpassport.com")
            .setIgnoreSSl(true)
            .setOkHttpClientBuilder {
            }
            .setRetrofitBuilder {
                it.addCallAdapterFactory(BaseCallAdapterFactory())
            }

        return netServiceBuilder.builder()
    }
}