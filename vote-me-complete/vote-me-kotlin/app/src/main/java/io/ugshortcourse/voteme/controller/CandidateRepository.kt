package io.ugshortcourse.voteme.controller

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.firestore.FirebaseFirestore
import io.ugshortcourse.voteme.core.COLLECTION_CANDIDATES
import io.ugshortcourse.voteme.core.voteMeLogger
import io.ugshortcourse.voteme.model.Candidate

/**
 * A repository of [Candidate]s
 */
class CandidateRepository constructor(private val firestore: FirebaseFirestore) : VoteMeRepository() {

    /**
     * Get all [Candidate]s belonging to a certain category
     */
    fun getCandidates(vararg categories: String): LiveData<MutableList<Candidate>> {
        val results = MutableLiveData<MutableList<Candidate>>()
        for (category in categories) {
            firestore.collection(COLLECTION_CANDIDATES).whereEqualTo("category", category)
                .get().addOnCompleteListener {
                    if (it.isSuccessful) {
                        val list = it.result?.toObjects(Candidate::class.java)
                        results.postValue(list)
                    }
                }.addOnFailureListener {
                    voteMeLogger(it.localizedMessage)
                }
        }
        return results
    }


    companion object {
        private val LOCK = Any()
        private var instance: CandidateRepository? = null

        fun getInstance(firestore: FirebaseFirestore): CandidateRepository {
            if (instance == null) {
                synchronized(LOCK) {
                    instance = CandidateRepository(firestore)
                }
            }

            return instance!!
        }
    }

}