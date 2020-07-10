package tw.lychee.githubuserlistdemo.utils

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import tw.lychee.githubuserlistdemo.repository.DummyRepository
import tw.lychee.githubuserlistdemo.repository.Repository
import tw.lychee.githubuserlistdemo.ui.users.UserModelFactory
import tw.lychee.githubuserlistdemo.ui.users.UsersViewModel

class ViewModelFactory private constructor(private val repository: Repository) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val viewModel = with(modelClass) {
            when {
                isAssignableFrom(UsersViewModel::class.java) ->
                    UsersViewModel(UserModelFactory(repository))


                else -> throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
            }
        }
        return viewModel as T
    }

    companion object {
        private var INSTANCE: ViewModelFactory? = null

        @JvmStatic
        fun getInstance(context: Context): ViewModelFactory {
            if (INSTANCE == null) {
                synchronized(ViewModelFactory::javaClass) {
                    val repository = DummyRepository()
                    INSTANCE = ViewModelFactory(repository)
                }
            }
            return INSTANCE!!
        }
    }
}
