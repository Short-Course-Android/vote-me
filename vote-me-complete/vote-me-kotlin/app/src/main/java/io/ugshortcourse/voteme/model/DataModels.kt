package io.ugshortcourse.voteme.model

/**
 * [Voter] data model
 */
data class Voter(
    val key: String,
    val fullName: String,
    val region: String,
    val org: String,
    val timestamp: Long = System.currentTimeMillis(),
    val dues: Long = 0L,
    val voted: Boolean = false
)

/**
 * [Candidate] data model
 */
data class Candidate(
    val key: String,
    val fullName: String,
    val info: String,
    val timestamp: Long = System.currentTimeMillis(),
    val image: String,
    val category: String
)

/**
 * [Vote] data model
 */
data class Vote(
    val key: String,
    val category: String,
    val candidateKey: String,
    val voterKey: String,
    val timestamp: Long = System.currentTimeMillis()
)

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