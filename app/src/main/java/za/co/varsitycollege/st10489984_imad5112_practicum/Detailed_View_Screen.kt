package za.co.varsitycollege.st10489984_imad5112_practicum

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Detailed_View_Screen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detailed_view_screen)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //all the buttons and text views being initialised
        val displaySongs = findViewById<TextView>(R.id.displaySongs)
        val songsListButton = findViewById<Button>(R.id.songsListButton)
        val calculateAverageButton = findViewById<Button>(R.id.calculateAverageButton)
        val mainScreenButton = findViewById<Button>(R.id.mainScreenButton)

        //getting the values from the main activity
        val Title = intent.getStringArrayExtra("Title") ?: arrayOf()
        val Artist = intent.getStringArrayExtra("Artist") ?: arrayOf()
        val Rating = intent.getStringArrayExtra("Rating") ?: arrayOf()
        val Comments = intent.getStringArrayExtra("Comments") ?: arrayOf()


        //instruction on what the songsListButton will do
        songsListButton?.setOnClickListener {
            //checking if the edit texts are empty
            if (Title.isEmpty() || Artist.isEmpty() || Rating.isEmpty() || Comments.isEmpty()) {
                Toast.makeText(
                    this,
                    "Please make sure that you've entered all data",
                    Toast.LENGTH_LONG
                ).show()
            }

            val songsOutput = StringBuilder()
            val itemCount = Title.size
            for (i in 0 until itemCount) {

                val title = Title[i]
                val artist = Artist[i]
                val rating = Rating[i]
                val comments = Comments[i]

                //checking if the edit texts are empty
                if (title.isNotEmpty() && artist.isNotEmpty() && rating.isNotEmpty() && comments.isNotEmpty()) {
                    //displaying the songs
                    songsOutput.append("Title: ${title}\n")
                    songsOutput.append("Artist: ${artist}")
                    songsOutput.append("Rating: ${rating}")
                    songsOutput.append("Comments: ${comments}")
                }
                displaySongs.text = songsOutput.toString()

            }
            //instruction on what the calculateAverageButton will do
            calculateAverageButton?.setOnClickListener {
                var totalRating = 0.0
                val itemCount = Title.size
                //looping through the array
                for (i in 0 until itemCount) {
                    val rating = Rating[i]
                    //checking if the edit texts are empty
                    if (rating.isNotEmpty()) {
                        //calculating the average rating
                        totalRating += rating.toDouble()
                        val averageRating = totalRating / itemCount
                        //displaying the average rating
                        displaySongs.text = "Average Rating: $averageRating"

                    } else {
                        displaySongs.text = "No valid ratings available"
                    }

                }
            }

            //instruction on what the mainScreenButton will do
            mainScreenButton?.setOnClickListener {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }
    }
}