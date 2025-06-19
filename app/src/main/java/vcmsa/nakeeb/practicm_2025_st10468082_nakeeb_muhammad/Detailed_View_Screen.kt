package vcmsa.nakeeb.practicm_2025_st10468082_nakeeb_muhammad

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Detailed_View_Screen : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detailed_view_screen)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        } // code starts here
        // main logic
        val songName = arrayListOf<String>("Foot Loose", "Fast Lane", "Stereo Hearts", "The Nights")

        val artistName =
            arrayListOf<String>("Kenny Loggins", "Lil Durk", "Gym Class Heroes", "Avicii")

        val songRating = arrayListOf<String>("7/10", "9/10", "8/10", "6/10")

        var i = 0

        val mledtSongDetails = findViewById<EditText>(R.id.mledtSongDetails)
        val btnSongList = findViewById<Button>(R.id.btnSongList)
        val btnReturnMenu = findViewById<Button>(R.id.btnReturnMenu)
        val btnRatings = findViewById<Button>(R.id.btnRatings)

        btnSongList.setOnClickListener {
            // when user clicks song list button song information is displayed on mledtSongDetails

            for (i in songName.indices) {
                mledtSongDetails.setText(songName.toString() + "" + artistName.toString() + "")
                if (songName.isEmpty() || artistName.isEmpty()) {
                    mledtSongDetails.setText("No songs available")
                } else {
                    mledtSongDetails.setText(songName.toString() + "" + artistName.toString() + "")
                    }

            }
        }

        btnRatings.setOnClickListener {
            // when user clicks ratings button song ratings are displayed on mledtSongDetails
            for (i in songName.indices) {
                mledtSongDetails.setText(songName.toString() + "" + songRating.toString() + "")
                if (songName.isEmpty() || artistName.isEmpty()) {
                    mledtSongDetails.setText("No songs available")
                } else {
                    mledtSongDetails.setText(songName.toString() + "" + songRating.toString() + "")
                }

            }

            btnReturnMenu.setOnClickListener {
                // when user clicks return to menu button go back to main screen
                val intent = Intent(this, Main_Screen::class.java)
                startActivity(intent)
                finish()
            }


        }
    }
}

