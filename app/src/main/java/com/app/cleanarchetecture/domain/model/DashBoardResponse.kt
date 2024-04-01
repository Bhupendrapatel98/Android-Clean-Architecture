package com.app.cleanarchetecture.domain.model


data class DashBoardResponse(
    val message: String,
    val results: Results,
    val status: Boolean,
    var totalEarning:String,
    var commision:String,
)

data class Results(
    val APPROVED: APPROVED,
    val ASSIGNED: ASSIGNED,
    val DISBURSED: DISBURSED,
    val INCOMPLETE: INCOMPLETE,
    val PENDING: PENDING,
    val REJECTED: REJECTED,
    val SHORTCLOSE: SHORTCLOSE,
    val TOTAL: TOTAL,
    val TOTAL_BUSINESSVOLUME: TOTALBUSINESSVOLUME,
    val LOGGED: LOGGED
)

data class LOGGED(
    val status: String,
    val value: Int
)

data class APPROVED(
    val status: String,
    val value: Int
)

data class ASSIGNED(
    val status: String,
    val value: Int
)

data class DISBURSED(
    val status: String,
    val value: Int
)

data class INCOMPLETE(
    val status: String,
    val value: Int
)
data class PENDING(
    val status: String,
    val value: Int
)
data class REJECTED(
    val status: String,
    val value: Int
)
data class SHORTCLOSE(
    val status: String,
    val value: Int
)
data class TOTAL(
    val status: String,
    val value: Int
)
data class TOTALBUSINESSVOLUME(
    val status: String,
    val value: Int
)