package tw.lychee.githubuserlistdemo.repository.remote

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import tw.lychee.githubuserlistdemo.Constants

object RetrofitManager {

    private val okHttpClient = OkHttpClient.Builder().apply {
        addInterceptor { chain ->
            val requestBuilder = chain.request().newBuilder()
            if (Constants.TOKEN.isNotEmpty()) {
                requestBuilder.addHeader("Accept", Constants.RECOMMENDED_ACCEPT_HEADER)
                requestBuilder.addHeader("Authorization", "token ${Constants.TOKEN}")
            }
            chain.proceed(requestBuilder.build())
        }
    }.build()

    val apiService: ApiInterface = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addConverterFactory(ScalarsConverterFactory.create())
        .client(okHttpClient)
        .build()
        .create(ApiInterface::class.java)
}