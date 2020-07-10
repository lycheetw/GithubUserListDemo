package tw.lychee.githubuserlistdemo.ui.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import tw.lychee.githubuserlistdemo.databinding.UserProfileFragmentBinding
import tw.lychee.githubuserlistdemo.utils.ViewModelFactory

private const val ARG_LOGIN_ID = "ARG_LOGIN_ID"
class UserProfileFragment : Fragment() {

    companion object {
        fun newInstance(loginId: String) = UserProfileFragment().apply {
            arguments = Bundle().apply {
                putString(ARG_LOGIN_ID, loginId)
            }
        }
    }

    private lateinit var viewDataBinding: UserProfileFragmentBinding
    private lateinit var viewModel: UserProfileViewModel

    private val loginId: String by lazy {
        arguments!!.getString(ARG_LOGIN_ID, "")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewDataBinding = UserProfileFragmentBinding.inflate(inflater, container, false)
        return viewDataBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelFactory.getInstance(requireContext().applicationContext)
            .create(UserProfileViewModel::class.java)
        viewDataBinding.viewModel = viewModel
        viewDataBinding.lifecycleOwner = this.viewLifecycleOwner

        viewModel.init(loginId)
    }

}