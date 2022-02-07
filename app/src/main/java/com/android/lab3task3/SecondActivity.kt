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

class SecondActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var drawerLayout: DrawerLayout
    lateinit var actionBarDrawerToggle: ActionBarDrawerToggle
    lateinit var toFirst: Button
    lateinit var toThird: Button
    lateinit var toAbout: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        drawerLayout = findViewById(R.id.drawer2)
        actionBarDrawerToggle = ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close)
        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        toFirst = findViewById(R.id.button2to1)
        toFirst.setOnClickListener(this)
        toThird = findViewById(R.id.button2to3)
        toThird.setOnClickListener(this)
        toAbout = findViewById(R.id.about_button2)
        toAbout.setOnClickListener(this)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) return true
        return super.onOptionsItemSelected(item)
    }

    override fun onClick(p0: View?) {
        if (p0 != null)
            when (p0.id) {
                toFirst.id -> {
                    val intent = Intent(this, MainActivity::class.java)
                    intent.addFlags(FLAG_ACTIVITY_CLEAR_TOP)
                    intent.addFlags(FLAG_ACTIVITY_SINGLE_TOP)
                    startActivity(intent)
                }
                toThird.id -> {
                    val intent = Intent(this, ThirdActivity::class.java)
                    startActivity(intent)
                }
                toAbout.id -> {
                    val intent = Intent(this, AboutActivity::class.java)
                    startActivity(intent)
                }
            }
    }
}