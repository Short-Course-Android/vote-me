package io.ugshortcourse.voteme.view

import android.content.Intent
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import io.ugshortcourse.voteme.R
import io.ugshortcourse.voteme.core.VoteMeBaseActivity
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity(override val layoutId: Int = R.layout.activity_home) : VoteMeBaseActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                message.setText(R.string.title_home)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_profile -> {
                message.setText(R.string.title_profile)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_feeds -> {
                message.setText(R.string.title_feeds)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_elections -> {
                message.setText(R.string.title_elections)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onViewCreated(instanceState: Bundle?, intent: Intent) {
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

}
