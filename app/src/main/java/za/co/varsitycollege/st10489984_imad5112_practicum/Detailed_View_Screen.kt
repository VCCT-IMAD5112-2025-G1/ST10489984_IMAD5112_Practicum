package za.co.varsitycollege.st10489984_imad5112_practicum

import android.content.Intent
import android.icu.text.CaseMap.Title
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

        //val displaySongs = findViewById<TextView>(R.id.displaySongs)
        val songsListButton = findViewById<Button>(R.id.songsListButton)
        val calculateAverageButton = findViewById<Button>(R.id.calculateAverageButton)
        val mainScreenButton = findViewById<Button>(R.id.mainScreenButton)

        val Title = intent.getStringArrayExtra("Title") ?: arrayOf()
        val Artist = intent.getStringArrayExtra("Artist") ?: arrayOf()
        val Rating = intent.getStringArrayExtra("Rating") ?: arrayOf()
        val Comments = intent.getStringArrayExtra("Comments") ?: arrayOf()




        songsListButton?.setOnClickListener {
            if (Title.isEmpty() || Artist.isEmpty() || Rating.isEmpty() || Comments.isEmpty()) {
                Toast.makeText(this, "Please make sure that you've entered all data", Toast.LENGTH_LONG).show()

            }

            var displaySongs = ""
            var counter = 0

//            for ((Title in Title) && (Artist in Artist) && (Rating in Rating) && (Comments in Comments)) {
//                displaySongs += "${Title[counter]}"
//                displaySongs += "${Artist[counter]}""
//                displaySongs += "${Rating[counter]}"
//                displaySongs += "${Comments[counter]}"
//            }



        }

        calculateAverageButton?.setOnClickListener {

        }

        mainScreenButton?.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}