package io.ugshortcourse.voteme.view

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import io.ugshortcourse.voteme.R
import io.ugshortcourse.voteme.core.VoteMeBaseActivity
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity(override val layoutId: Int = R.layout.activity_home) : VoteMeBaseActivity() {
    private lateinit var fm: FragmentManager

    //Listener for change in click events for the bottom navigation view
    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {

                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_profile -> {

                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_feeds -> {

                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_elections -> {

                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onViewCreated(instanceState: Bundle?, intent: Intent) {
        // Init fragment manager
        fm = supportFragmentManager

        //Add bottom navigation click listener
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)


    }

}
