package api

import com.google.gson.annotations.SerializedName

data class GradeResponse(
    var code: String = "",
    var credit: Double = 0.0,
    var name: String = "",
    var grade: String = "",
    @SerializedName("faculty") var facultyName: String = ""
)
