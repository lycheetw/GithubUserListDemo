package tw.lychee.githubuserlistdemo

import android.widget.ImageView
import androidx.databinding.BindingAdapter

object DataBindings {
    @JvmStatic
    @BindingAdapter("avatarUrl")
    fun loadAvatar(view: ImageView, avatarUrl: String) {
        //TODO: Load image
    }
}