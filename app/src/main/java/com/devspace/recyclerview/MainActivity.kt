package com.devspace.recyclerview

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val rvList = findViewById<RecyclerView>(R.id.rv_list)
        val ivList = findViewById<ImageView>(R.id.btn_list)
        val ivGrid = findViewById<ImageView>(R.id.btn_grid)
        val adapter = ContactListAdapter()

        rvList.adapter = adapter
        rvList.layoutManager = LinearLayoutManager(this)
        adapter.submitList(contacts)

        ivGrid.setOnClickListener {
            rvList.layoutManager = GridLayoutManager(this, 2)

        }
        ivList.setOnClickListener {
            rvList.layoutManager = LinearLayoutManager(this)
        }

        adapter.setOnCLickListener { contact ->
            val intent = Intent(this,ContactDetailActivity::class.java)
            intent.putExtra("name", contact.name)
            intent.putExtra("phone", contact.phone)
            intent.putExtra("icon", contact.icon)


            startActivity(intent)

        }

    }
}

val contacts = listOf(
    Contact(
        name = "Roque",
        phone = "(55) 11 987456321",
        icon = R.drawable.sample8
    ),
    Contact(
        name = "Bruna",
        phone = "(55)11 92256-7444",
        icon = R.drawable.sample1
    ),
    Contact(
        name = "Brenda",
        phone = "(55)11 92356-7384",
        icon = R.drawable.sample3
    ),
    Contact(
        name = "Julia",
        phone = "(55)11 98326-7464",
        icon = R.drawable.sample4
    ),
    Contact(
        name = "Camila",
        phone = "(55)11 99756-3384",
        icon = R.drawable.sample5
    ),
    Contact(
        name = "Francisco",
        phone = "(55)11 99336-2284",
        icon = R.drawable.sample8
    ),
    Contact(
        name = "Erick",
        phone = "(55)11 99116-1184",
        icon = R.drawable.sample9
    ),
    Contact(
        name = "Joao",
        phone = "(55)11 99236-1135",
        icon = R.drawable.sample10
    ),
    Contact(
        name = "Helena",
        phone = "(55)11 99216-1235",
        icon = R.drawable.sample11
    ),
    Contact(
        name = "Jose",
        phone = "(55)11 92356-1284",
        icon = R.drawable.sample12
    ),
    Contact(
        name = "Maria",
        phone = "(55)11 99226-3384",
        icon = R.drawable.sample13
    ),
    Contact(
        name = "Enzo",
        phone = "(55)11 99336-1974",
        icon = R.drawable.sample14
    ),
    Contact(
        name = "Laura",
        phone = "(55)11 99212-2135",
        icon = R.drawable.sample15
    ),
    Contact(
        name = "Gabi",
        phone = "(55)11 99217-1234",
        icon = R.drawable.sample16
    ),
)