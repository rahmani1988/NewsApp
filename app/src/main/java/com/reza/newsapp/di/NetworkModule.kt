package com.reza.newsapp.di

import com.reza.newsapp.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

private const val TEN_SECONDS = 10L
private const val NEWS_API_KEY = "X-Api-Key"

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideOkHttpLoggingInterceptor() =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    @Provides
    @Singleton
    fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        val builder = OkHttpClient.Builder()
            .connectTimeout(TEN_SECONDS, TimeUnit.SECONDS)
            .readTimeout(TEN_SECONDS, TimeUnit.SECONDS)
            .writeTimeout(TEN_SECONDS, TimeUnit.SECONDS)
            .followRedirects(true)
            .followSslRedirects(true)
            .addInterceptor { chain ->
                val newRequest = chain
                    .request()
                    .newBuilder()
                    .addHeader(NEWS_API_KEY, BuildConfig.NEWS_API_KEY)
                    .build()
                chain.proceed(newRequest)
            }
        return if (BuildConfig.DEBUG) {
            builder
                .addInterceptor(loggingInterceptor)
                .build()
        } else {
            builder.build()
        }
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit
        .Builder()
        .addConverterFactory(MoshiConverterFactory.create())
        .baseUrl(BuildConfig.BASE_URL)
        .client(okHttpClient)
        .build()
}