package com.topotopo.demo.di

import android.content.Context
import com.topotopo.demo.BuildConfig
import com.topotopo.demo.feed.presentation.FeedViewModel
import com.topotopo.demo.feed.domain.repository.FeedRepository
import com.topotopo.demo.feed.data.repository.FeedRepositoryImpl
import com.topotopo.demo.feed.data.network.FeedApi
import com.topotopo.demo.feed.data.network.FakeFeedApi
import com.topotopo.demo.feed.domain.usecase.GetFeedHolderUseCase
import com.topotopo.demo.feed.domain.usecase.GetFeedHolderUseCaseImpl
import com.topotopo.demo.feed.domain.usecase.GetFeedUseCase
import com.topotopo.demo.feed.domain.usecase.GetFeedUseCaseImpl
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.mock.BehaviorDelegate
import retrofit2.mock.MockRetrofit
import retrofit2.mock.NetworkBehavior

val appModule = module {
    single<FeedRepository> {
        FeedRepositoryImpl(
            get()
        )
    }

    viewModel { FeedViewModel(get()) }
}

val networkModule = module {
    factory { provideOkHttpClient() }
    single { provideRetrofit(get()) }
    factory { provideMoviesApi(get(), get()) }
}

val useCaseModule = module {
    factory<GetFeedUseCase> { GetFeedUseCaseImpl(get()) }
    factory<GetFeedHolderUseCase> { GetFeedHolderUseCaseImpl(get()) }
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