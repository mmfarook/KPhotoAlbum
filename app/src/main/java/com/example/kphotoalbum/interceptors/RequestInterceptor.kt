package com.example.kphotoalbum.interceptors

import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

public class RequestInterceptor : Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        // Request customization: add request headers
        return chain.proceed(original)
    }
}
