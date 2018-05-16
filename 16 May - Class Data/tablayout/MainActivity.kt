package com.bmpl.tablayout

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var iconArray = arrayOf(android.R.drawable.ic_menu_camera,
            android.R.drawable.ic_menu_call)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        tabLayout.setupWithViewPager(viewPager)
        setUpPages(viewPager)  //
        setUpIcons()
    }

    fun setUpIcons(){
        tabLayout.getTabAt(0)!!.setIcon(iconArray[0])
        tabLayout.getTabAt(1)!!.setIcon(iconArray[1])
    }

    // attach the fragment data with the view pager
    fun setUpPages(viewPager: ViewPager){
                                    // getSupportFragmentManager()
        var fragmentData = FragmentData(supportFragmentManager) // new object of Fragment Data class is created

        var contactsFragment = ContactsFragment()

        fragmentData.addFragments(contactsFragment, "Contacts") //
        fragmentData.addFragments(CallFragment(), "Calls")

        viewPager.adapter = fragmentData

    }
    // ActivityManager --> Activities
    // FragmentManager --> Communicate --> Fragment
    class FragmentData(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager)
    {

        // FragmentData(FragmentManager fm){  super(fm); }

        // tabs --> title -->
        override fun getPageTitle(position: Int): CharSequence {
            return ""
            //return titleList[position]
        }

        override fun getItem(position: Int): Fragment {
            return fragmentList[position]
        }

        override fun getCount(): Int {
            return fragmentList.size
        }

        var fragmentList = ArrayList<Fragment>()

        var titleList = ArrayList<String>()

        fun addFragments(fragment: Fragment, title : String){

            fragmentList.add(fragment)
            titleList.add(title)
        }

    }


}
