package tw.lychee.githubuserlistdemo.repository

import tw.lychee.githubuserlistdemo.model.UserModel

class DummyRepository : Repository {
    override suspend fun fetchUsers(since: Int, perPage: Int): List<UserModel> {
        return (since until since + perPage).map { UserModel(it, "User $it", "https://cataas.com/cat?id=$it", true) }
    }
}