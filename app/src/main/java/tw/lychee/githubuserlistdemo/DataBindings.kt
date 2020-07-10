package tw.lychee.githubuserlistdemo

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

object DataBindings {
    @JvmStatic
    @BindingAdapter("avatarUrl")
    fun loadAvatar(view: ImageView, avatarUrl: String?) {
        Glide.with(view)
            .load(avatarUrl)
            .circleCrop()
            .into(view)
    }
}