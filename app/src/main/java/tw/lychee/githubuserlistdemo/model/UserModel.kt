package tw.lychee.githubuserlistdemo.model

import com.google.gson.annotations.SerializedName

data class UserModel(
    @SerializedName("id")
    val id: Int,
    @SerializedName("login")
    val login: String,
    @SerializedName("avatar_url")
    val avatarUrl: String,
    @SerializedName("site_admin")
    val siteAdmin: Boolean
)