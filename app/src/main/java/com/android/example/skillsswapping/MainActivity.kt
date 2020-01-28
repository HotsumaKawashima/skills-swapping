package com.android.example.skillsswapping

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity(),
    BottomNavigationView.OnNavigationItemSelectedListener {

    private val viewModel by viewModels<MainViewModel> {
        MainViewModel.Factory(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val className = intent.getStringExtra("className")

        if(viewModel.isLogin.value == false && className != LoginActivity::class.java.simpleName) {
            startLoginActivity()
        } else {
            viewModel.isLogin.value = true
        }

        viewModel.isLogin.observe(this, Observer { isLogin ->
            if(!isLogin) {
                startLoginActivity()
            }
        })

        val navController = findNavController(R.id.nav_host_fragment)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_nav)
        bottomNavigationView.setupWithNavController(navController)
        bottomNavigationView.setOnNavigationItemSelectedListener(this)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        toolbar.setupWithNavController(navController)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        navController.popBackStack(R.id.topFragment, false)

        if(item.itemId != R.id.topFragment) {
            navController.navigate(item.itemId)
        }
        return true
    }

    private fun startLoginActivity() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }
}
