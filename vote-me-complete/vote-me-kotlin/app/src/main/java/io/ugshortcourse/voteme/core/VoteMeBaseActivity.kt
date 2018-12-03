package io.ugshortcourse.voteme.core

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.StorageReference
import io.ugshortcourse.voteme.core.sharedprefs.VoteMePrefs
import javax.inject.Inject

/**
 * Base class for all [Activity]s
 */
abstract class VoteMeBaseActivity : AppCompatActivity() {

    @Inject
    lateinit var firestore: FirebaseFirestore
    @Inject
    lateinit var storage: StorageReference
    @Inject
    lateinit var auth: FirebaseAuth
    @Inject
    lateinit var database: VoteMePrefs

    //To be overridden by the children classes
    protected abstract val layoutId: Int

    protected abstract fun onViewCreated(instanceState: Bundle?, intent: Intent)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Inject dagger
        (application as VoteMeApplication).component.inject(this)
        setContentView(layoutId)


        //Should be a t the bottom of this function
        onViewCreated(savedInstanceState, intent)
    }


}