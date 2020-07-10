package tw.lychee.githubuserlistdemo.repository

import tw.lychee.githubuserlistdemo.model.UserModel
import tw.lychee.githubuserlistdemo.model.UserProfile

class DummyRepository : Repository {
    override suspend fun fetchUsers(since: Int, perPage: Int): List<UserModel> {
        return (since until since + perPage).map { UserModel(it, "User $it", "https://cataas.com/cat?id=$it", true) }
    }

    override suspend fun fetchUserProfile(loginId: String): UserProfile {
        return UserProfile(0, "loginId", "https://cataas.com/cat?id=0", true, "Demo User", "Hello, World!", "Taiwan", "https://google.com")
    }
}