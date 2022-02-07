package com.android.lab3task3

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Button
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import android.content.Intent.*

class FourthActivity : AppCompatActivity(), View.OnClickListener {


    lateinit var drawerLayout: DrawerLayout
    lateinit var actionBarDrawerToggle: ActionBarDrawerToggle
    lateinit var toThird: Button
    lateinit var toAbout: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fourth)

        drawerLayout = findViewById(R.id.drawer4)
        actionBarDrawerToggle = ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close)
        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        toThird = findViewById(R.id.button4to3)
        toThird.setOnClickListener(this)
        toAbout = findViewById(R.id.about_button4)
        toAbout.setOnClickListener(this)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) return true
        return super.onOptionsItemSelected(item)
    }

    override fun onClick(p0: View?) {
        if (p0 != null)
            when (p0.id) {
                toThird.id -> {
                    val intent = Intent(this, ThirdActivity::class.java)
                    intent.addFlags(FLAG_ACTIVITY_CLEAR_TOP)
                    intent.addFlags(FLAG_ACTIVITY_SINGLE_TOP)
                    startActivity(intent)
                }
                toAbout.id -> {
                    val intent = Intent(this, AboutActivity::class.java)
                    startActivity(intent)
                }
            }
    }

}