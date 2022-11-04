package com.example.curriculomobile

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.curriculomobile.model.RecyclerData

class MainAdapter(val list : MutableList<RecyclerData>, private var cliked: (Int) -> Unit) : RecyclerView.Adapter<MainViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.categories_main, parent, false)
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

class MainViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
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