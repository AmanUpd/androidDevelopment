package aman.upd.mathquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_result_summary.*
import kotlinx.android.synthetic.main.result_list.*
import kotlinx.android.synthetic.main.result_list.view.*

class ResultSummary : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_summary)

        val result = intent.getBooleanArrayExtra("RESULT")
        resultlist.layoutManager = LinearLayoutManager(this)

        val res = getres(result!!)
        resultlist.adapter = ResultAdapter(res)
    }

    private fun getres(inte : BooleanArray) : List<Results>{
        val addresults = mutableListOf<Results>()

        val q1 = Results("5 + 7 = 12",inte[0])
        val q2 = Results("1 + 5 = 6",inte[1])
        val q3 = Results("12 - 95 = -82",inte[2])
        val q4 = Results("5 + 6 x 3 = 23",inte[3])
        val q5 = Results("12 + 8 / 4 = 5",inte[4])

        addresults += q1
        addresults += q2
        addresults += q3
        addresults += q4
        addresults += q5

        return addresults
    }
    private inner class ResultHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener{
        val questionName= itemView.Questionid
        val questionResult = itemView.ResultId

        lateinit var result: Results

        init {
            itemView.setOnClickListener(this)
        }
        fun bind(rest: Results){
            this.result = rest
            questionName.text = rest.name.toString()
            questionResult.text = if(rest.answer) "Correct" else "Incorrect"
        }

        override fun onClick(v: View?) {
            TODO("Not yet implemented")
        }
    }
    private inner class ResultAdapter(var result:List<Results>): RecyclerView.Adapter<ResultHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultHolder {
            val view = layoutInflater.inflate(R.layout.result_list,parent, false)
            return ResultHolder(view)
        }

        override fun onBindViewHolder(holder: ResultHolder, position: Int) {
            val results = result[position]
            holder.bind(results)
        }

        override fun getItemCount(): Int {
            return result.size
        }
    }


}
