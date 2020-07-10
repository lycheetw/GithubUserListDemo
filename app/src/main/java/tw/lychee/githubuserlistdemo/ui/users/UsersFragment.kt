package tw.lychee.githubuserlistdemo.ui.users

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import tw.lychee.githubuserlistdemo.databinding.UsersFragmentBinding

class UsersFragment : Fragment() {

    companion object {
        fun newInstance() = UsersFragment()
    }

    private lateinit var viewModel: UsersViewModel
    private lateinit var viewDataBinding: UsersFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewDataBinding = UsersFragmentBinding.inflate(inflater, container, false)
        return viewDataBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(UsersViewModel::class.java)
        viewDataBinding.lifecycleOwner = this.viewLifecycleOwner
        viewDataBinding.viewModel = viewModel

    }

}