package com.example.flixsterplus2

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso

class PersonActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_person)
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true);
        //get extra from intent
        var name = intent.getStringExtra("name")
        var poster = intent.getStringExtra("poster")
        var profile = intent.getStringExtra("profile")
        var description = intent.getStringExtra("description")
        var title = intent.getStringExtra("title")

        var titleView = findViewById<TextView>(R.id.movieTitle)
        var descriptionView = findViewById<TextView>(R.id.description)
        var actorTitleView = findViewById<TextView>(R.id.actorTitle)
        var profileView = findViewById<ImageView>(R.id.profileImage)
        var movieView = findViewById<ImageView>(R.id.movieImage)

        titleView.setText(title)
        descriptionView.setText(description)
        actorTitleView.setText(name)
        Picasso.get().load("https://image.tmdb.org/t/p/w500/"+profile).into(profileView)
        Picasso.get().load("https://image.tmdb.org/t/p/w500/"+poster).into(movieView)

    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}