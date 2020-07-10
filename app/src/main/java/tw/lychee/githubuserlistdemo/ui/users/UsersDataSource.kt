package tw.lychee.githubuserlistdemo.ui.users

import android.util.Log
import androidx.paging.PositionalDataSource
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import tw.lychee.githubuserlistdemo.model.UserModel
import tw.lychee.githubuserlistdemo.repository.Repository

private val TAG = "UsersDataSource"

class UsersDataSource(private val repository: Repository) : PositionalDataSource<UserModel>() {
    private val mutex = Mutex()
    private var nextIndex = 0

    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<UserModel>) {

        runBlocking {
            try {
                mutex.withLock {
                    val begin = nextIndex
                    val size = params.loadSize
                    val list = repository.fetchUsers(begin, size)
                    callback.onResult(list)

                    nextIndex = list.last().id
                    Log.d(TAG, "${list.first().id} ~ ${list.last().id}, size: ${list.size}")
                }

            } catch (e: Exception) {

            }
        }
    }

    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<UserModel>) {

        runBlocking {
            try {
                mutex.withLock {
                    val begin = 0
                    val size = params.pageSize
                    val list = repository.fetchUsers(begin, size)
                    callback.onResult(list, nextIndex, 100)

                    nextIndex = list.last().id
                    Log.d(TAG, "${list.first().id} ~ ${list.last().id}, size: ${list.size}")
                }
            } catch (e: Exception) {

            }
        }
    }

}