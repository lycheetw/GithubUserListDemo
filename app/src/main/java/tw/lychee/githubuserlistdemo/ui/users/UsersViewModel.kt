package tw.lychee.githubuserlistdemo.ui.users

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import androidx.paging.toLiveData
import tw.lychee.githubuserlistdemo.Event
import tw.lychee.githubuserlistdemo.model.UserModel

class UsersViewModel(private val userModelFactory: UserModelFactory) : ViewModel() {
    val users: LiveData<PagedList<UserModel>> by lazy {
        userModelFactory.toLiveData(20, null)
    }

    val empty: LiveData<Boolean> = Transformations.map(users) {
        it.isEmpty()
    }

    private val _selectEvent = MutableLiveData<Event<String>>()
    val selectEvent: LiveData<Event<String>> = _selectEvent

    fun onSelect(user: UserModel) {
        _selectEvent.value = Event(user.login)
    }

    fun refresh() {
        users.value?.dataSource?.invalidate()
    }
}