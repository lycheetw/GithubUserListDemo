package tw.lychee.githubuserlistdemo.repository.remote

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import tw.lychee.githubuserlistdemo.model.UserModel
import tw.lychee.githubuserlistdemo.model.UserProfile

interface ApiInterface {
    @GET("users")
    fun fetchUserList(@Query("since") since: Int, @Query("per_page") perPage: Int): Call<List<UserModel>>

    @GET("users/{loginId}")
    fun fetchUserProfile(@Path("loginId") loginId: String): Call<UserProfile>
}