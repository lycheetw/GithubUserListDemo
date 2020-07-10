package tw.lychee.githubuserlistdemo.ui.profile

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import tw.lychee.githubuserlistdemo.R

private const val ARG_LOGIN_ID = "ARG_LOGIN_ID"
class UserProfileFragment : Fragment() {

    companion object {
        fun newInstance(loginId: String) = UserProfileFragment().apply {
            arguments = Bundle().apply {
                putString(ARG_LOGIN_ID, loginId)
            }
        }
    }

    private lateinit var viewModel: UserProfileViewModel

    private val loginId: String by lazy {
        arguments!!.getString(ARG_LOGIN_ID, "")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.user_profile_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(UserProfileViewModel::class.java)
        // TODO: Use the ViewModel
    }

}