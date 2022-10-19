package com.example.curriculomobile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.curriculomobile.model.RecyclerData
import java.util.zip.Inflater

class MainActivity : AppCompatActivity() {

    private lateinit var recycler : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list_mutable = mutableListOf<RecyclerData>()

        recycler = findViewById(R.id.rc_main)
        recycler.adapter = MainAdapter(list_mutable){ id ->
            changeActivity(id)
        }
        recycler.layoutManager = GridLayoutManager(this, 2)


        list_mutable.add(
            RecyclerData(1, R.drawable.sobre, "Sobre mim")
        )
        list_mutable.add(
            RecyclerData(2, R.drawable.experiences, "Experiências")
        )
        list_mutable.add(
            RecyclerData(3, R.drawable.school, "Formação")
        )
        list_mutable.add(
            RecyclerData(4, R.drawable.projects, "Projetos")
        )
        list_mutable.add(
            RecyclerData(5, R.drawable.contact, "Contato")
        )
        list_mutable.add(
            RecyclerData(6, R.drawable.certification, "Certificados")
        )
    }

    private fun changeActivity(id : Int){
        when(id){
            1 -> intent = Intent(this, About::class.java)
            2 -> intent = Intent(this, Experiences::class.java)
            3 -> intent = Intent(this, School::class.java)
            4 -> intent = Intent(this, Projects::class.java)
            5 -> intent = Intent(this, Contact::class.java)
            6 -> intent = Intent(this, Certification::class.java)
        }
        startActivity(intent)
    }

    inner class MainAdapter(val list : MutableList<RecyclerData>, private var cliked: (Int) -> Unit) : RecyclerView.Adapter<MainViewHolder>(){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
            val view = layoutInflater.inflate(R.layout.categories_main, parent, false)
            return MainViewHolder(view)
        }

        override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
            val posi = list[position]
            holder.bind(posi, cliked)
        }

        override fun getItemCount(): Int {
            return list.size
        }
    }

    inner class MainViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        fun bind(view : RecyclerData, cliked: (Int) -> Unit){
            val text = itemView.findViewById<TextView>(R.id.text)
            val image = itemView.findViewById<ImageView>(R.id.image)


            text.text = view.text
            image.setImageResource(view.image)

            itemView.setOnClickListener{
                cliked(view.id)
            }

        }
    }
}