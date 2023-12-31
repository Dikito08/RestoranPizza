package com.example.restoranpizza

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RemoteViews
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class pagemenu : AppCompatActivity() {
    companion object {
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    val EXTRA_MESSAGE = "com.example.android.twoactivities.extra.MESSAGE"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pagemenu)

        val intent = intent
        val message = intent.getStringExtra(EXTRA_MESSAGE)
        val textView = findViewById<TextView>(R.id.menu_person)
        textView.text = message

        val menuList = listOf<Menus>(
            Menus(
                R.drawable.pizza,
                namaMenu = "Pepperoni Pizza",
                detailMenu = "Cocok bagi anda yang ingin merasakan pizza dengan taburan keju dan daging asap yang lezat",
                imgDesc = R.drawable.pizza_detail,
                descNama = "Pepperoni Pizza",
                descDetail = "Pepperoni pizza adalah pizza yang memiliki  topping daging pepperoni sapi asli. Di Italia, pepperoni disebut salame piccante (salami panas). Biasa menjadi bahan baku pizza di Amerika Serikat, yang sering mewakili 30% pelengkap. Pizza ini cocok untuk santap siang ataupun malam anda",
                descHarga = "Price: Rp 66.000,00"

            ),
            Menus(
                R.drawable.spaghetti,
                namaMenu = "Spaghetti",
                detailMenu = "Cocok bagi anda yang ingin merasakan spaghetti original dengan bumbu yang oriental",
                imgDesc = R.drawable.spaghetti_detail,
                descNama = "Spaghetti",
                descDetail = "Spaghetti yang kami hadirkan ialah spaghetti Spaghetti aglio e olio yang merupakan salah satu hidangan pasta yang paling sederhana dan populer dalam masakan Italia. Terjemahan harfiah dari aglio e olio adalah bawang putih dan minyak zaitun. Hidangan ini terdiri dari bahan-bahan dasar yang sederhana, termasuk pasta spaghetti, bawang putih cincang, cabai merah, minyak zaitun, dan parsley.",
                descHarga = "Price: Rp 54.000,00",
            ),
            Menus(
                R.drawable.burger,
                namaMenu = "Burger",
                detailMenu = "Cocok bagi anda yang ingin merasakan kelembutan burger berlapisan keju, sayuran dan daging yang tebal",
                imgDesc = R.drawable.burger_detail,
                descNama = "Burger",
                descDetail = "Burger yang kami hidangkan ialah burger beef, dimana daging sapi pilihan wagyu A 5 langsung dari jepang ditabur dengan seasoning garam dan black pepper dan ada ssayuran dan juga keju",
                descHarga = "Price: Rp 60.000,00"
            ),
            Menus(
                R.drawable.steak,
                namaMenu = "Steak",
                detailMenu = "Cocok bagi anda yang ingin merasakan lezatnya daging steak dipadukan dengan kentang yang lezat",
                imgDesc = R.drawable.steak_detail,
                descNama = "Steak",
                descDetail = "Steak dengan daging Wagyu A 5 langsung dari jepang okinawa dengan marbling 10 dan seasoning yang pas membuat liadh anda bergoyang dan merasa nikmat disetiap gigitannya",
                descHarga = "Price: Rp 79.000,00"
            )
        )

        val recyclerView = findViewById<RecyclerView>(R.id.rv_menu)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = MenuAdapter(this, menuList) { menu ->
            Toast.makeText(this, "Anda memilih ${menu.namaMenu}", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, DetailMenu::class.java)
            intent.putExtra(INTENT_PARCELABLE, menu)
            startActivity(intent)

        }
    }
}