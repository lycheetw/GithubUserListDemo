package tw.lychee.githubuserlistdemo.ui.users

import android.util.Log
import androidx.paging.PositionalDataSource

val TAG = "UsersDataSource"

class UsersDataSource : PositionalDataSource<String>() {
    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<String>) {
        val begin = params.startPosition
        val end = params.startPosition + params.loadSize
        Log.d(TAG, "load $begin ~ $end")

        val list = (begin until end).map { "User $it" }
        callback.onResult(list)
    }

    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<String>) {
        val begin = 0
        val end = params.pageSize
        Log.d(TAG, "load $begin ~ $end")

        val list = (begin until end).map { "User $it" }
        callback.onResult(list, 0, 100)
    }

}