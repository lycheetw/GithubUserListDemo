package tw.lychee.githubuserlistdemo.ui.users

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import androidx.paging.toLiveData

class UsersViewModel : ViewModel() {
    private val userModelFactory = UserModelFactory()
    val users: LiveData<PagedList<String>> by lazy {
        userModelFactory.toLiveData(20, null)
    }

    val empty: LiveData<Boolean> = Transformations.map(users) {
        it.isEmpty()
    }
}