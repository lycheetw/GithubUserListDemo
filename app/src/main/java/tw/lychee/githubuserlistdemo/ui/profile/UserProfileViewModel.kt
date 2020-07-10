package tw.lychee.githubuserlistdemo.ui.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import tw.lychee.githubuserlistdemo.model.UserProfile
import tw.lychee.githubuserlistdemo.repository.Repository

class UserProfileViewModel(private val repository: Repository) : ViewModel() {
    private val _userProfile = MutableLiveData<UserProfile>()
    val userProfile: LiveData<UserProfile>
        get() = _userProfile

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
}