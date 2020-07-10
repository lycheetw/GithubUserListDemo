package tw.lychee.githubuserlistdemo.ui.users

import android.util.Log
import androidx.paging.PositionalDataSource
import tw.lychee.githubuserlistdemo.model.UserModel

val TAG = "UsersDataSource"

class UsersDataSource : PositionalDataSource<UserModel>() {
    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<UserModel>) {
        val begin = params.startPosition
        val end = params.startPosition + params.loadSize
        Log.d(TAG, "load $begin ~ $end")

        val list = (begin until end).map { UserModel(it, "User $it", "", true) }
        callback.onResult(list)
    }

    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<UserModel>) {
        val begin = 0
        val end = params.pageSize
        Log.d(TAG, "load $begin ~ $end")

        val list = (begin until end).map { UserModel(it, "User $it", "", true) }
        callback.onResult(list, 0, 100)
    }

}