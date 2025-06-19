package za.co.varsitycollege.st10489984_imad5112_practicum

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.setPadding

class MainActivity : AppCompatActivity() {
    // array that stores the title of the songs
    val title = arrayOf<String>("","","","")
    //array that stores all the names of artists
    val artists = arrayOf<String>("","","","")
    //array that stores the ratings of the song from the user
    val rating = arrayOf<String>("","","","")
    //array that stores the comments from the user about the song
    val comments = arrayOf<String>("","","","")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // all the edit texts (Plain text) being initialised
        val titleEditText = findViewById<EditText>(R.id.titleEditText)
        val artistNameEditText = findViewById<EditText>(R.id.artistNameEditText)
        val ratingEditText = findViewById<EditText>(R.id.ratingEditText)
        val commentEditText = findViewById<EditText>(R.id.commentEditText)
        // all the buttons being initialised
        val addPlaylistButton = findViewById<Button>(R.id.addPlaylistButton)
        val nextPageButton = findViewById<Button>(R.id.nextPageButton)
        val exitAppButton = findViewById<Button>(R.id.exitAppButton)

        val title=titleEditText.text.toString()
        val artist=artistNameEditText.text.toString()
        val rating=ratingEditText.text.toString()
        val comments=commentEditText.text.toString()

        //instruction on what the addPlaylist Button will do
        addPlaylistButton?.setOnClickListener {
            if ((title.isEmpty()) && (artist.isEmpty()) && (rating.isEmpty()) && (comments.isEmpty())) {
                val builder=AlertDialog.Builder(this)
                builder.setTitle("Missing Input")
                builder.setMessage("Please double check and make sure all data have been entered.")
                builder.setPositiveButton("Checked!") {
                    dialog, _ ->dialog.dismiss()
                }
                builder.show()
                return@setOnClickListener
            }
        }
    }
}