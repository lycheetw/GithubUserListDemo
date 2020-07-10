package tw.lychee.githubuserlistdemo.ui.users

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.main_activity.view.*
import tw.lychee.githubuserlistdemo.R
import tw.lychee.githubuserlistdemo.databinding.UsersFragmentBinding
import tw.lychee.githubuserlistdemo.ui.profile.UserProfileFragment
import tw.lychee.githubuserlistdemo.utils.ViewModelFactory

class UsersFragment : Fragment() {

    companion object {
        fun newInstance() = UsersFragment()
    }

    private lateinit var viewDataBinding: UsersFragmentBinding
    private lateinit var viewModel: UsersViewModel
    private lateinit var adapter: UsersAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewDataBinding = UsersFragmentBinding.inflate(inflater, container, false)
        return viewDataBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelFactory.getInstance(requireContext().applicationContext)
            .create(UsersViewModel::class.java)
        viewDataBinding.viewModel = viewModel
        viewDataBinding.lifecycleOwner = this.viewLifecycleOwner

        adapter = UsersAdapter(viewModel)
        viewDataBinding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        viewDataBinding.recyclerView.adapter = adapter

        viewModel.users.observe(this.viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })

        viewModel.selectEvent.observe(this.viewLifecycleOwner, Observer { event ->
            event.getContentIfNotHandled()?.let { value ->
                requireActivity().supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.container, UserProfileFragment.newInstance(value))
                    .commitAllowingStateLoss()
            }
        })
    }

}