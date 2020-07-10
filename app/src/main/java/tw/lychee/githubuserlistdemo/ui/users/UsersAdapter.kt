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

class UsersAdapter() : PagedListAdapter<String, UsersAdapter.ViewHolder>(
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


    companion object DiffCallback : DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }
    }
}