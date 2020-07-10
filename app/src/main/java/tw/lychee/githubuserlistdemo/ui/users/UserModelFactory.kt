package tw.lychee.githubuserlistdemo.ui.users

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource

class UserModelFactory : DataSource.Factory<Int, String>() {

    private val sourceLiveData = MutableLiveData<UsersDataSource>()

    override fun create(): DataSource<Int, String> {
        val source = UsersDataSource()
        sourceLiveData.postValue(source)
        return source
    }
}