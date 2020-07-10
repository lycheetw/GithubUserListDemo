package tw.lychee.githubuserlistdemo.ui.users

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import tw.lychee.githubuserlistdemo.model.UserModel

class UserModelFactory : DataSource.Factory<Int, UserModel>() {

    private val sourceLiveData = MutableLiveData<UsersDataSource>()

    override fun create(): DataSource<Int, UserModel> {
        val source = UsersDataSource()
        sourceLiveData.postValue(source)
        return source
    }
}