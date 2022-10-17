package com.ba.bahfsecurityapi.Data.Network

import com.ba.bahfgetlocation.Utils.Constants
import com.ba.bahfsecurityapi.Data.Core.BAHFSecurityApiClient
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object BAHFRetrofitHelper {
    fun getRetrofit(): BAHFSecurityApiClient {

        val requestInterceptor = Interceptor { chain ->
            val url = chain.request()
                .url()
                .newBuilder()
                .build()

            val request = chain.request()
                .newBuilder()
                .url(url)
                .build()

            return@Interceptor chain.proceed(request)
        }
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(requestInterceptor)
            .connectTimeout(60, TimeUnit.SECONDS)
            .build()

        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(Constants.BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(BAHFSecurityApiClient::class.java)
    }
    fun getClient():Retrofit{
        return Retrofit.Builder()
            .baseUrl("http://dev-api.bancoazteca.com.mx:8080/payments/payments-hub/security/v0.0.6")
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient())
            .build()
    }

}