package tw.lychee.githubuserlistdemo.repository.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import tw.lychee.githubuserlistdemo.Constants

object RetrofitManager {
    val apiService:ApiInterface = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addConverterFactory(ScalarsConverterFactory.create())
        .build()
        .create(ApiInterface::class.java)
}