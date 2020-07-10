package tw.lychee.githubuserlistdemo.ui.users

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import tw.lychee.githubuserlistdemo.R
import tw.lychee.githubuserlistdemo.databinding.UsersFragmentBinding
import tw.lychee.githubuserlistdemo.ui.profile.UserProfileFragment
import tw.lychee.githubuserlistdemo.utils.ViewModelFactory

class UsersFragment : Fragment() {

    companion object {
        fun newInstance() = UsersFragment()
    }

    private lateinit var viewDataBinding: UsersFragmentBinding
    private val viewModel: UsersViewModel get() = viewDataBinding.viewModel!!
    private val adapter: UsersAdapter get() = viewDataBinding.recyclerView.adapter as UsersAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewDataBinding = UsersFragmentBinding.inflate(inflater, container, false)
        return viewDataBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewDataBinding.viewModel = ViewModelFactory.getInstance(requireContext().applicationContext)
            .create(UsersViewModel::class.java)
        viewDataBinding.lifecycleOwner = this.viewLifecycleOwner

        with(viewDataBinding.recyclerView) {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = UsersAdapter(viewModel)
            setHasFixedSize(true)
        }

        setListeners()
    }

    private fun setListeners() {
        viewDataBinding.swipeRefreshLayout.setOnRefreshListener {
            viewDataBinding.swipeRefreshLayout.isRefreshing = false
            viewModel.refresh()
        }

        viewModel.users.observe(this.viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })

        viewModel.selectEvent.observe(this.viewLifecycleOwner, Observer { event ->
            event.getContentIfNotHandled()?.let { value ->
                requireActivity().supportFragmentManager
                    .beginTransaction()
                    .add(R.id.container, UserProfileFragment.newInstance(value))
                    .addToBackStack(UsersFragment::class.java.name)
                    .commitAllowingStateLoss()
            }
        })
    }
}