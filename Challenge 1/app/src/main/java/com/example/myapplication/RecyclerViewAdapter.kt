package com.example.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter(context: Context, list: ArrayList<Student>): RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    companion object {
        const val VIEW_TYPE_ONE = 1
        const val VIEW_TYPE_TWO = 2
        const val VIEW_TYPE_THREE = 3
    }

    private val context : Context = context
    var list: ArrayList<Student> = list

    private inner class View1Holder(itemView: View):
    RecyclerView.ViewHolder(itemView){
        var name: TextView = itemView.findViewById(R.id.textNormal)
        var gpa: TextView = itemView.findViewById(R.id.GPANormal)
        var credit: TextView = itemView.findViewById(R.id.creditsNormal)
        fun bind(position: Int){
            val recyclerViewModel = list[position]
            name.setText(recyclerViewModel.name)
            gpa.setText(recyclerViewModel.gpa)
            credit.setText(recyclerViewModel.credit)
        }
    }

    private inner class View2Holder(itemView: View):
        RecyclerView.ViewHolder(itemView){
        var name: TextView = itemView.findViewById(R.id.textProbation)
        var gpa: TextView = itemView.findViewById(R.id.GPAProbation)
        var credit: TextView = itemView.findViewById(R.id.creditsProbation)
        fun bind(position: Int){
            val recyclerViewModel = list[position]
            name.setText(recyclerViewModel.name)
            gpa.setText(recyclerViewModel.gpa)
            credit.setText(recyclerViewModel.credit)
        }
    }

    private inner class View3Holder(itemView: View):
        RecyclerView.ViewHolder(itemView){
        var name: TextView = itemView.findViewById(R.id.textHonor)
        var gpa: TextView = itemView.findViewById(R.id.GPAHonor)
        var credit: TextView = itemView.findViewById(R.id.creditsHonor)
        fun bind(position: Int){
            val recyclerViewModel = list[position]
            name.setText(recyclerViewModel.name)
            gpa.setText(recyclerViewModel.gpa)
            credit.setText(recyclerViewModel.credit)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if(viewType == VIEW_TYPE_ONE){
            return View1Holder(
                LayoutInflater.from(context).inflate(R.layout.item_container_normal, parent, false)
            )
        } else if(viewType == VIEW_TYPE_TWO) {
            return View2Holder(
                LayoutInflater.from(context).inflate(R.layout.item_container_probation, parent, false)
            )
        }
        return View3Holder(
            LayoutInflater.from(context).inflate(R.layout.item_container_honor, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(list[position].viewType == VIEW_TYPE_ONE){
            (holder as View1Holder).bind(position)
        }else if (list[position].viewType == VIEW_TYPE_TWO){
            (holder as View2Holder).bind(position)
        }else if (list[position].viewType == VIEW_TYPE_THREE){
            (holder as View3Holder).bind(position)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun getItemViewType(position: Int): Int {
        return list[position].viewType
    }


}