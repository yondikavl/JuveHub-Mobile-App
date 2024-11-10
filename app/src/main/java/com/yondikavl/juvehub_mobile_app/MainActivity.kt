package com.yondikavl.juvehub_mobile_app

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvPlayer: RecyclerView
    private val list = ArrayList<Player>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvPlayer = findViewById(R.id.rv_players)
        rvPlayer.setHasFixedSize(true)

        list.addAll(getListPlayers())
        showRecyclerList()
    }

    private fun getListPlayers(): ArrayList<Player> {
        val dataName = resources.getStringArray(R.array.data_nama)
        val dataDesc = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listPlayer = ArrayList<Player>()
        for (i in dataName.indices) {
            val player = Player(dataName[i], dataDesc[i], dataPhoto.getResourceId(i, -1))
            listPlayer.add(player)
        }
        return listPlayer
    }

    private fun showRecyclerList() {
        rvPlayer.layoutManager = LinearLayoutManager(this)
        val listPlayerAdapter = ListPlayerAdapter(list)
        rvPlayer.adapter = listPlayerAdapter

        listPlayerAdapter.setOnItemClickCallback(object : ListPlayerAdapter.OnItemclickCallback {
            override fun onItemClicked(data: Player) {
                showSelectedPlayer(data)
            }
        })
    }

    private fun showSelectedPlayer(player: Player) {
        Toast.makeText(this, "Kamu memilih " + player.name, Toast.LENGTH_SHORT).show()
    }
}