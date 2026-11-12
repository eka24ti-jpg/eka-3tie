package com.example.eka_3tie.Home.pertemuan_11

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.eka_3tie.Home.pertemuan_10.TabAFragment
import com.example.eka_3tie.Home.pertemuan_10.TabBFragment

class EleventhTabsAdapter(activity: EleventhActivity) :
    FragmentStateAdapter(activity) {

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> TabAFragment()
            1 -> TabBFragment()
            else -> TabAFragment()
        }
    }
}
