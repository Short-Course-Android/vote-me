package io.ugshortcourse.voteme.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.ugshortcourse.voteme.R

/**
 * [android.app.Application] main entrance
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
