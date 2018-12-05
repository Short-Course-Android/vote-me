package io.ugshortcourse.voteme.view

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import io.ugshortcourse.voteme.R
import io.ugshortcourse.voteme.controller.CandidateRepository
import io.ugshortcourse.voteme.controller.CandidateViewModel
import io.ugshortcourse.voteme.controller.CandidateViewModelFactory
import io.ugshortcourse.voteme.core.VoteMeBaseActivity
import io.ugshortcourse.voteme.core.voteMeLogger

class CandidateActivity(override val layoutId: Int = R.layout.activity_candidate) : VoteMeBaseActivity() {

    override fun onViewCreated(instanceState: Bundle?, intent: Intent) {

        if (intent.hasExtra(EXTRA_CATEGORY_TYPE)) {
            val category = intent.getStringExtra(EXTRA_CATEGORY_TYPE)

            val repo = CandidateRepository.getInstance(firestore)
            val factory = CandidateViewModelFactory(repo, category)
            val candidates = ViewModelProviders.of(this, factory).get(CandidateViewModel::class.java).candidates
            candidates.observe(this@CandidateActivity, Observer { results ->
                voteMeLogger(results)
            })
        }

    }

    companion object {
        const val EXTRA_CATEGORY_TYPE = "EXTRA_CATEGORY_TYPE"
    }
}