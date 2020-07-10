package tw.lychee.githubuserlistdemo.repository

import tw.lychee.githubuserlistdemo.model.UserModel
import tw.lychee.githubuserlistdemo.model.UserProfile

interface Repository {
    suspend fun fetchUsers(since: Int, perPage: Int): List<UserModel>
    suspend fun fetchUserProfile(loginId: String): UserProfile
}