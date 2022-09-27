package com.example.flixsterplus2

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
//RecyclerAdapter which takes in List of Movie class
class RecyclerAdapter(private val people: ArrayList<Person>) : RecyclerView.Adapter<RecyclerAdapter.PersonHolder>() {
    // Creates references to the views in row_item.xml
    class PersonHolder(v: View) : RecyclerView.ViewHolder(v) {
        var ItemImage: ImageView
        var ItemTitle: TextView

        init {
            ItemImage = v.findViewById(R.id.backdrop)
            ItemTitle = v.findViewById(R.id.title)
        }
    }

    // creates a row_item.xml for each row
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerAdapter.PersonHolder {
        val v =
            LayoutInflater.from(parent.context).inflate(R.layout.row_item, parent, false)

        return PersonHolder(v)
    }

    // When view is created. Load the image using picasso and set the title
    override fun onBindViewHolder(holder: RecyclerAdapter.PersonHolder, position: Int) {
        val person = people[position]
        Picasso.get().load("https://image.tmdb.org/t/p/w500/"+person.profile_path).into(holder.ItemImage)
        holder.ItemTitle.setText(person.name)
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, PersonActivity::class.java)
            // To pass any data to next activity
            intent.putExtra("name", people[position].name)
            intent.putExtra("profile", people[position].profile_path)
            intent.putExtra("poster", people[position].known_for[0].poster_path)
            intent.putExtra("title", people[position].known_for[0].original_title)
            intent.putExtra("description", people[position].known_for[0].overview)
            // start your next activity
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return people.size
    }
}