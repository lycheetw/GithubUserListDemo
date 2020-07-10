package tw.lychee.githubuserlistdemo.model

import com.google.gson.annotations.SerializedName

data class UserProfile(
    @SerializedName("id")
    val id: Int,
    @SerializedName("login")
    val login: String,
    @SerializedName("avatar_url")
    val avatarUrl: String,
    @SerializedName("site_admin")
    val siteAdmin: Boolean,
    @SerializedName("name")
    val name: String,
    @SerializedName("bio")
    val bio: String,
    @SerializedName("location")
    val location: String,
    @SerializedName("blog")
    val blog: String
)