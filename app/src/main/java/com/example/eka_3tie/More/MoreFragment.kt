package com.example.eka_3tie.More

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.SimpleAdapter
import android.widget.Toast
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.eka_3tie.R
import com.example.eka_3tie.Home.pertemuan_10.TenthActivity

class MoreFragment : Fragment() {

    private val dataListWithDesc = listOf(
        mapOf(
            "title" to "Kotlin",
            "desc" to "Bahasa untuk Android modern"
        ),
        mapOf(
            "title" to "Java",
            "desc" to "Bahasa OOP yang populer"
        ),
        mapOf(
            "title" to "Python",
            "desc" to "Bahasa yang mudah dipahami"
        )
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view = inflater.inflate(
            R.layout.fragment_more,
            container,
            false
        )

        val listView: ListView = view.findViewById(R.id.listView)
        val btnTenth: Button = view.findViewById(R.id.btnTenth)

        val adapter = SimpleAdapter(
            requireContext(),
            dataListWithDesc,
            android.R.layout.simple_list_item_2,
            arrayOf("title", "desc"),
            intArrayOf(
                android.R.id.text1,
                android.R.id.text2
            )
        )

        listView.adapter = adapter

        listView.setOnItemClickListener { _, _, position, _ ->
            val selectedItem = dataListWithDesc[position]
            val title = selectedItem["title"]
            val desc = selectedItem["desc"]

            Toast.makeText(
                requireContext(),
                "Kamu memilih: $title ($desc)",
                Toast.LENGTH_SHORT
            ).show()
        }

        // Membuka TenthActivity
        btnTenth.setOnClickListener {
            val intent = Intent(requireContext(), TenthActivity::class.java)
            startActivity(intent)
        }

        return view
    }
}
