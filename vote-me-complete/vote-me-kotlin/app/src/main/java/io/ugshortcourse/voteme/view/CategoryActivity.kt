package io.ugshortcourse.voteme.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import io.ugshortcourse.voteme.R
import io.ugshortcourse.voteme.controller.CandidateRepository
import io.ugshortcourse.voteme.controller.CandidateViewModel
import io.ugshortcourse.voteme.controller.CandidateViewModelFactory
import io.ugshortcourse.voteme.core.Category
import io.ugshortcourse.voteme.core.VoteMeBaseActivity
import io.ugshortcourse.voteme.core.voteMeLogger

class CategoryActivity(override val layoutId: Int = R.layout.activity_category) : VoteMeBaseActivity() {

    private val listItems = arrayOf<CharSequence>(Category.PRESIDENT, Category.SECRETARY, Category.VICE)

    override fun onViewCreated(instanceState: Bundle?, intent: Intent) {

        val repo = CandidateRepository.getInstance(firestore)
        val factory = CandidateViewModelFactory(repo, Category.PRESIDENT)
        val candidates = ViewModelProviders.of(this, factory).get(CandidateViewModel::class.java).candidates
        candidates.observe(this@CategoryActivity, Observer { results ->
            voteMeLogger(results)
        })
    }


    //Dialog showing options for selecting a category
    private val dialog: AlertDialog = AlertDialog.Builder(this)
        .setTitle("Select a category")
        .setPositiveButton("") { dialog, _ -> dialog.dismiss() }
        .setItems(listItems) { dialog, which ->
            dialog.dismiss()

            when (which) {
                0 -> {

                }

                1 -> {


                }

                2 -> {


                }
            }

        }
        .create()
}