package tw.lychee.githubuserlistdemo.ui.users

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList

class UsersViewModel : ViewModel() {
    private val _users = MutableLiveData<List<String>>(listOf())
    val users: LiveData<List<String>> = _users

    val empty: LiveData<Boolean> = Transformations.map(users) {
        it.isEmpty()
    }
}