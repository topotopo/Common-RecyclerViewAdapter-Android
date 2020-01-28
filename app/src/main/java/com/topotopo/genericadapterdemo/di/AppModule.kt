package com.topotopo.genericadapterdemo.di

import com.topotopo.genericadapterdemo.feed.FeedViewModel
import com.topotopo.genericadapterdemo.repo.FeedRepository
import com.topotopo.genericadapterdemo.repo.FeedRepositoryImpl
import com.topotopo.genericadapterdemo.service.FeedApi
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {
    single<FeedRepository> { FeedRepositoryImpl(get()) }

    viewModel { FeedViewModel(get()) }
}

val networkModule = module {
    factory { provideOkHttpClient() }
    single { provideRetrofit(get()) }
    factory { provideMoviesApi(get()) }
}

fun provideOkHttpClient(): OkHttpClient {
    return OkHttpClient().newBuilder().build()
}

//TODO: Create global constant for URL
fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder().baseUrl("https://www.google.com/").client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create()).build()
}

fun provideMoviesApi(retrofit: Retrofit): FeedApi {
    return retrofit.create(FeedApi::class.java)
}