package io.ugshortcourse.voteme.core

import io.ugshortcourse.voteme.model.Voter

//region DATABASE REFERENCES
const val COLLECTION_TOKENS = "registered_tokens"
const val DEFAULT_SHARED_PREFS = "vote-me-prefs"
//endregion DATABASE REFERENCES

/**
 * [Category] of electoral [Candidate]
 */
object Category {
    const val PRESIDENT = "President"
    const val VICE = "Vice President"
    const val SECRETARY = "Secretary"
}

/**
 * Checks for the qualification of a [Voter] based on their dues
 */
val Voter.hasGoodStanding: Boolean get() = dues >= 10000L

/**
 * Creates a [HashMap] for any voter model
 */
val Voter.createHashMap: HashMap<String, Any?>
    get() = hashMapOf(
        "key" to key,
        "fullName" to fullName,
        "region" to region,
        "org" to org,
        "timestamp" to timestamp,
        "dues" to dues,
        "voted" to voted
    )


fun voteMeLogger(msg: Any?) = println("VoteMeLogger: ${msg.toString()}")