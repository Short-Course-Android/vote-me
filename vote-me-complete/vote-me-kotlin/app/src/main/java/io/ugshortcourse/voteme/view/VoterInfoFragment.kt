package io.ugshortcourse.voteme.view

import android.os.Bundle
import android.view.View
import io.ugshortcourse.voteme.R
import io.ugshortcourse.voteme.core.VoteMeBaseActivity
import io.ugshortcourse.voteme.core.VoteMeBaseFragment

class VoterInfoFragment constructor() : VoteMeBaseFragment() {
    override fun getLayoutId(): Int = R.layout.fragment_voter_info

    override fun onViewCreated(instanceState: Bundle?, v: View, parent: VoteMeBaseActivity) {

    }

}