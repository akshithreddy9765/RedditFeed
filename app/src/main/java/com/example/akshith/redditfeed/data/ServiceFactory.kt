package com.example.akshith.redditfeed.data

import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class ServiceFactory @Inject constructor(private val gson: Gson, private val logLevel: HttpLoggingInterceptor.Level) {

    companion object {
        const val BASE_URL = "https://www.reddit.com/"
    }

    fun <T> createService(clazz: Class<T>): T = getRetrofitAdapter().create(clazz)

    private fun getRetrofitAdapter(): Retrofit = Retrofit.Builder()
            .client(getOkHttpClient()).addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl(BASE_URL)
            .build()

    private fun getOkHttpClient(): OkHttpClient = OkHttpClient().newBuilder().addInterceptor(HttpLoggingInterceptor().setLevel(logLevel)).build()
}
