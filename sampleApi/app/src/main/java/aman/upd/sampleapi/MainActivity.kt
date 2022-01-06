package aman.upd.sampleapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import api.BothResponse
import api.GradeResponse
import api.ProfileResponse
import api.SparkApi
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://dl.dropboxusercontent.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val sparkApi: SparkApi = retrofit.create(SparkApi::class.java)

       //get profile
        val getProfileRequest: Call<ProfileResponse> = sparkApi.getProfile()

        getProfileRequest.enqueue(object: Callback<ProfileResponse> {
            override fun onResponse(call: Call<ProfileResponse>, response: Response<ProfileResponse>) {
                val profileresponse = response.body()
                if (profileresponse != null) {
                    Log.d("SPARK-API", profileresponse.facultyName)
                }
            }
            override fun onFailure(call: Call<ProfileResponse>, t: Throwable) {
                Log.e("SPARK-API","FAILED TO REQUEST!")
            }

        })

        // get grade
        val getGradeRequest: Call<List<GradeResponse>> = sparkApi.getGrade()
        getGradeRequest.enqueue(object: Callback<List<GradeResponse>> {
            override fun onResponse(call: Call<List<GradeResponse>>, response: Response<List<GradeResponse>>) {
                var gradeResponse = response.body()
                if (gradeResponse != null) {
                    Log.d("SPARK-API", gradeResponse[0].toString())
                }
            }
            override fun onFailure(call: Call<List<GradeResponse>>, t: Throwable) {
                Log.d("SPARK-API", "Failed to request!")
            }
        })

        //get both
        val getBothRequest: Call<BothResponse> = sparkApi.getBoth()
        getBothRequest.enqueue(object: Callback<BothResponse> {
            override fun onResponse(call: Call<BothResponse>, response: Response<BothResponse>) {
                var bothResponse = response.body()
                if (bothResponse != null) {
                    id.text =  "id: " + bothResponse.id.toString()
                    name.text = "name: " + bothResponse.name
                    gpa.text = "gpa: " + bothResponse.gpa.toString()
                    credit.text = "credit: " + bothResponse.credit.toString()
                }
            }
            override fun onFailure(call: Call<BothResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
}