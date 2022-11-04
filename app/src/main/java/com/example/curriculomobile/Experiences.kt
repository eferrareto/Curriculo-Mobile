package com.example.curriculomobile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.system.Os.bind
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
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
        recycler_experience.adapter = MainAdapter(experienceList){
            callAlertDialog(it)
        }
        recycler_experience.layoutManager = LinearLayoutManager(this)

        experienceList.add(RecyclerData(0, R.drawable.flash, "Analista de Qualidade"))
        experienceList.add(RecyclerData(1, R.drawable.mast, "Assistente Administrativo - Nível 1 e 2"))
        experienceList.add(RecyclerData(2, R.drawable.mantris, "Assistente Administrativo"))
        experienceList.add(RecyclerData(3, R.drawable.mongeacai, "Atendente de Restaurante"))

    }

    fun callAlertDialog(id : Int){
        when(id){
            0 -> flash()
            1 -> mast()
            2 -> mantris()
            3 -> mongeacai()
        }
    }

    fun flash(){
        AlertDialog.Builder(this)
            .setMessage("- Acompanho e analiso os indicadores das franquias.\n\n" +
                    "- Realizo apresentações de performance, com auditorias e análises feitas em sistemas.\n\n" +
                    "- Analise de dados na leitura de Power B.I\n\n" +
                    "- Boas práticas em EXCEL (tabelas dinâmicas e " +
                    "códigos)")
            .setTitle("Nov 2021 · 1 ano")
            .show()
    }
    fun mast(){
        AlertDialog.Builder(this)
            .setMessage("Minha colocação era na área operacional," +
                    " sempre focado em resolver as dificuldades que nossos clientes passavam.")
            .setTitle("Nov 2020 - Set 2021 · 11 meses")
            .show()
    }
    fun mantris(){
        AlertDialog.Builder(this)
            .setMessage("Ajudava e colaborava com os agendamentos, " +
                    " também nas subidas de ASOs dentro do sistema operacional, " +
                    " e em todo o setor que necessitava de auxílio.")
            .setTitle("Ago 2019 - Ago 2020 · 1 Ano")
            .show()
    }
    fun mongeacai(){
        AlertDialog.Builder(this)
            .setMessage("Preparava e embalava os pedidos, realizava a limpeza do restaurante e" +
                    "  finalizava com o fechamento do caixa.")
            .setTitle("Fev 2019 - Ago 2019 · 7 meses")
            .show()
    }
}