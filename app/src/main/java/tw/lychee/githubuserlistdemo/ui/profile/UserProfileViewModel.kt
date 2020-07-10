package tw.lychee.githubuserlistdemo.ui.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import tw.lychee.githubuserlistdemo.model.UserProfile

class UserProfileViewModel : ViewModel() {
    private val _userProfile = MutableLiveData<UserProfile>(
        UserProfile(0, "loginId", "https://cataas.com/cat?id=0", true, "Demo User", "Hello, World!", "Taiwan", "https://google.com")
    )
    val userProfile: LiveData<UserProfile>
        get() = _userProfile

    fun init(loginId: String) {

    }
}