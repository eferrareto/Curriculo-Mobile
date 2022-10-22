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
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.curriculomobile.model.RecyclerExperience
import java.util.zip.Inflater

class Experiences : AppCompatActivity() {

    private lateinit var recycler : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_experiences)

        val list = mutableListOf<RecyclerExperience>()

        recycler = findViewById(R.id.rv_experience)
        recycler.adapter = ExperienceAdapter(list)
        recycler.layoutManager = LinearLayoutManager(this)

        list.add(
            RecyclerExperience(R.drawable.mast, "Grupo Mast", "1 ano na empresa")
        )
    }
    private inner class ExperienceAdapter(val list: MutableList<RecyclerExperience>): RecyclerView.Adapter<ExperienceViewHolder>(){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExperienceViewHolder {
            val inflate = layoutInflater.inflate(R.layout.rv_experience_main, parent, false)
            return ExperienceViewHolder(inflate)
        }

        override fun onBindViewHolder(holder: ExperienceViewHolder, position: Int) {
            val postion = list[position]
            holder.bind(postion)
        }

        override fun getItemCount(): Int {
            return list.size
        }

    }
    private inner class ExperienceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(view: RecyclerExperience){

            val image = findViewById<ImageView>(R.id.imageExperience)
            val name = findViewById<TextView>(R.id.txtExperience)
            val time = findViewById<TextView>(R.id.timeExperience)

            image.setImageResource(view.image)
            name.text = view.name
            time.text = view.time
        }
    }
}