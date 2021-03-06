package tw.lychee.githubuserlistdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import tw.lychee.githubuserlistdemo.ui.users.UsersFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, UsersFragment.newInstance())
                    .commitNow()
        }
    }
}