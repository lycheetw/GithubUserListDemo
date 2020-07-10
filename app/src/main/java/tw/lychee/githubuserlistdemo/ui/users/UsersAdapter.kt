package tw.lychee.githubuserlistdemo.ui.users

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import tw.lychee.githubuserlistdemo.BR
import tw.lychee.githubuserlistdemo.R
import tw.lychee.githubuserlistdemo.model.UserModel

class UsersAdapter(private val viewModel: UsersViewModel) : PagedListAdapter<UserModel, UsersAdapter.ViewHolder>(
    DiffCallback
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context), R.layout.users_fragment_list_cell, parent, false
        )
        return ViewHolder(
            binding
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bindVariable(BR.userModel, item)
        holder.bindVariable(BR.viewModel, viewModel)

        holder.executePendingBindings()
    }

    class ViewHolder(private val mBinding: ViewDataBinding) :
        RecyclerView.ViewHolder(mBinding.root) {
        fun bindVariable(id: Int, obj: Any?) {
            mBinding.setVariable(id, obj)
        }

        fun executePendingBindings() {
            mBinding.executePendingBindings()
        }
    }


    companion object DiffCallback : DiffUtil.ItemCallback<UserModel>() {
        override fun areItemsTheSame(oldItem: UserModel, newItem: UserModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: UserModel, newItem: UserModel): Boolean {
            return oldItem.id == newItem.id &&
                    oldItem.login == newItem.login &&
                    oldItem.siteAdmin == newItem.siteAdmin &&
                    oldItem.avatarUrl == newItem.avatarUrl
        }
    }
}