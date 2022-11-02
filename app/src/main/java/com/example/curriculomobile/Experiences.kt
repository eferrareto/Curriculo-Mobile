package com.example.curriculomobile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.system.Os.bind
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.curriculomobile.model.RecyclerData

class Experiences : AppCompatActivity() {

    private lateinit var recycler_experience : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_experiences)

        val experienceList = mutableListOf<RecyclerData>()

        recycler_experience = findViewById(R.id.rc_experience)
        recycler_experience.adapter = ExperienceAdapter(experienceList)
        recycler_experience.layoutManager = LinearLayoutManager(this)

        experienceList.add(RecyclerData(1, R.drawable.mast, "Grupo Mast  - Saúde Ocupacional"))

    }

    inner class ExperienceAdapter(val experienceList : MutableList<RecyclerData>) : RecyclerView.Adapter<ExperienceViewHolder>(){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExperienceViewHolder {
            val inflate = layoutInflater.inflate(R.layout.experience_rv, parent, false)
            return ExperienceViewHolder(inflate)
        }

        override fun onBindViewHolder(holder: ExperienceViewHolder, position: Int) {
            val current = experienceList[position]
            holder.bind(current)
        }

        override fun getItemCount(): Int {
            return experienceList.size
        }

    }

    inner class ExperienceViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        fun bind(view : RecyclerData){

            val nameEx = findViewById<TextView>(R.id.nameexperience)
            nameEx.text = view.text
        }
    }



}