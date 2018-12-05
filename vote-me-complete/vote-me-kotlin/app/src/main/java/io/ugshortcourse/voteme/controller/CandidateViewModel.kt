package io.ugshortcourse.voteme.controller

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.ugshortcourse.voteme.model.Candidate

class CandidateViewModel constructor() : ViewModel() {

    private var _candidates: LiveData<MutableList<Candidate>> = MutableLiveData()

    constructor(repository: CandidateRepository, vararg categories: String) : this() {
        _candidates = repository.getCandidates(*categories)
    }

    val candidates: LiveData<MutableList<Candidate>> = _candidates

}