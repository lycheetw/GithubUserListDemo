package tw.lychee.githubuserlistdemo.ui.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import tw.lychee.githubuserlistdemo.Event
import tw.lychee.githubuserlistdemo.model.UserProfile
import tw.lychee.githubuserlistdemo.repository.Repository

class UserProfileViewModel(private val repository: Repository) : ViewModel() {
    private val _userProfile = MutableLiveData<UserProfile>()
    val userProfile: LiveData<UserProfile>
        get() = _userProfile

    private val _closeEvent = MutableLiveData<Event<Unit>>()
    val closeEvent: LiveData<Event<Unit>> = _closeEvent

    private val _openLinkEvent = MutableLiveData<Event<String>>()
    val openLinkEvent: LiveData<Event<String>> = _openLinkEvent

    fun init(loginId: String) {
        viewModelScope.launch {
            _userProfile.value =
                withContext(Dispatchers.Default) {
                    try {
                        repository.fetchUserProfile(loginId)
                    } catch (e: Exception) {
                        null
                    }
                }
        }
    }

    fun onClose() {
        _closeEvent.value = Event(Unit)
    }

    fun onOpenLink(url: String) {
        _openLinkEvent.value = Event(url)
    }
}