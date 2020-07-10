package tw.lychee.githubuserlistdemo.ui.users

import android.util.Log
import androidx.paging.PositionalDataSource
import kotlinx.coroutines.runBlocking
import tw.lychee.githubuserlistdemo.model.UserModel
import tw.lychee.githubuserlistdemo.repository.Repository

val TAG = "UsersDataSource"

class UsersDataSource(private val repository: Repository) : PositionalDataSource<UserModel>() {
    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<UserModel>) {
        val begin = params.startPosition
        val end = params.startPosition + params.loadSize
        Log.d(TAG, "load $begin ~ $end")

        runBlocking {
            val list = repository.fetchUsers(begin, params.loadSize)
            callback.onResult(list)
        }
    }

    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<UserModel>) {
        val begin = 0
        val end = params.pageSize
        Log.d(TAG, "load $begin ~ $end")

        runBlocking {
            val list = repository.fetchUsers(begin, params.pageSize)
            callback.onResult(list, 0, 100)
        }
    }

}