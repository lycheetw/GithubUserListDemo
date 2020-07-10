package tw.lychee.githubuserlistdemo.repository

import tw.lychee.githubuserlistdemo.model.UserModel

interface Repository {
    suspend fun fetchUsers(since: Int, perPage: Int): List<UserModel>
}