package tw.lychee.githubuserlistdemo.repository

import retrofit2.await
import tw.lychee.githubuserlistdemo.model.UserModel
import tw.lychee.githubuserlistdemo.model.UserProfile
import tw.lychee.githubuserlistdemo.repository.remote.RetrofitManager

class GithubRepository : Repository {
    override suspend fun fetchUsers(since: Int, perPage: Int): List<UserModel> {
        return RetrofitManager.apiService.fetchUserList(since, perPage).await()
    }

    override suspend fun fetchUserProfile(loginId: String): UserProfile {
        return RetrofitManager.apiService.fetchUserProfile(loginId).await()
    }
}