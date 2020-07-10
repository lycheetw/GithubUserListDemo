package tw.lychee.githubuserlistdemo.ui.users

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import tw.lychee.githubuserlistdemo.model.UserModel
import tw.lychee.githubuserlistdemo.repository.Repository

class UserModelFactory(private val repository: Repository) : DataSource.Factory<Int, UserModel>() {

    private val sourceLiveData = MutableLiveData<UsersDataSource>()

    override fun create(): DataSource<Int, UserModel> {
        val source = UsersDataSource(repository)
        sourceLiveData.postValue(source)
        return source
    }
}