package com.topotopo.genericadapterdemo.di

import android.content.Context
import com.topotopo.genericadapterdemo.BuildConfig
import com.topotopo.genericadapterdemo.feed.FeedViewModel
import com.topotopo.genericadapterdemo.repo.FeedRepository
import com.topotopo.genericadapterdemo.repo.FeedRepositoryImpl
import com.topotopo.genericadapterdemo.service.FeedApi
import com.topotopo.genericadapterdemo.service.mock.FakeFeedApi
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.mock.BehaviorDelegate
import retrofit2.mock.MockRetrofit
import retrofit2.mock.NetworkBehavior

val appModule = module {
    single<FeedRepository> { FeedRepositoryImpl(get()) }

    viewModel { FeedViewModel(get()) }
}

val networkModule = module {
    factory { provideOkHttpClient() }
    single { provideRetrofit(get()) }
    factory { provideMoviesApi(get(), get()) }
}

fun provideOkHttpClient(): OkHttpClient {
    return OkHttpClient().newBuilder().build()
}

//TODO: Create global constant for URL
fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder().baseUrl("https://www.google.com/").client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create()).build()
}

fun provideMoviesApi(retrofit: Retrofit, context: Context): FeedApi {
    return if (BuildConfig.IS_MOCK) {
        val behavior = NetworkBehavior.create()
        val mockRetrofit = MockRetrofit.Builder(retrofit).networkBehavior(behavior).build()
        val delegate: BehaviorDelegate<FeedApi> =
            mockRetrofit.create(FeedApi::class.java)
        FakeFeedApi(delegate, context)
    } else {
        retrofit.create(FeedApi::class.java)
    }

}