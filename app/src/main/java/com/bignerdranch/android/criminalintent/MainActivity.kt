package com.bignerdranch.android.criminalintent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import java.util.*


//USED IN LOG
private const val TAG = "MainActivity"


/**
 * To Maintain the independence of Fragments MainActivity will define callback interface
 * to Swap between the Fragments When Clicked
 * */

/**
 * MAINACTIVITY HANDLES THIS LOGIC
 * MainActivity Implements CrimeListFragment.Callbacks To handle the Swapping of Fragments
 * When a User Clicks on a CrimeListFragment list
 * It will then swap it to the CrimeFragment which would have the details of that list
 * */

class MainActivity : AppCompatActivity(), CrimeListFragment.Callbacks{


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Defining a Fragment Manger to
        val currentFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_container)
        if(currentFragment == null) {
            val fragment = CrimeListFragment.newInstance()
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container, fragment)
                .commit()
            }
        }

    /**
     * This method will replace a Fragment when the User clicks on the list in the CrimeListFragment
     * It will Swap the CrimeListFragment To CrimeFragment
     * Where it will display the details of that specific crime
     * */
    override fun onCrimeSelected(crimeId: UUID) {


        //We get the crimeId From the MainActivity it gets it from
        //CrimeListFragment onClick Method in Holder Class which will call
        //This Method When Clicked and pass the Current crimeId

        val fragment = CrimeFragment.newInstance(crimeId)

        //FragmentTransaction.replace(Int, Fragment) replaces
        //The Fragment hosted in the activity with the new fragment provided
        //Adding a Transaction to the Back Stack
        //This means that when the user presses the Back Button the transaction will be
        //Reversed So in this case CrimeFragment will be replaced With CrimeListFragment
        //.addToBackStack(String "Name the back stack state you are adding")
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment)
            .addToBackStack(null).commit()
    }
}












