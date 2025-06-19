package vcmsa.nakeeb.practicm_2025_st10468082_nakeeb_muhammad

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputLayout

class Main_Screen : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_screen)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        } // code starts here
          // main logic
        // link to backend of UI
           val songName = arrayListOf<String>("Foot Loose", "Fast Lane","Stereo Hearts","The Nights")

           val artistName = arrayListOf<String>("Kenny Loggins", "Lil Durk", "Gym Class Heroes", "Avicii")

           val songRating = arrayListOf<String>("7/10", "9/10", "8/10", "6/10")

        val btnAddToPlaylist = findViewById<Button>(R.id.btnAddToPlaylist)
        val btnSongInfo = findViewById<Button>(R.id.btnSongDetails)
        val btnExit = findViewById<Button>(R.id.btnExit)
        val tiedtSongInfo = findViewById<TextInputLayout>(R.id.tiedtSongInfo)

         var i = 0

          btnAddToPlaylist.setOnClickListener {
              // when user enters information of song and clicks add to playlist button
              if (tiedtSongInfo.editText?.text.toString().isEmpty()) {
                  tiedtSongInfo.error = "Please enter song information"
                  Toast.makeText(this, "Please enter song information", Toast.LENGTH_LONG).show()

              } else {
                  tiedtSongInfo.error = null
              }
              for (i in songName.indices) {
                  songName.add(tiedtSongInfo.editText?.text.toString())
                  artistName.add(tiedtSongInfo.editText?.text.toString())
                  songRating.add(tiedtSongInfo.editText?.text.toString())
                  Toast.makeText(this, "Song added to playlist", Toast.LENGTH_LONG).show()
              }

          }
          btnSongInfo.setOnClickListener {
              val intent = Intent(this, Detailed_View_Screen::class.java)
              startActivity(intent)
              finish()

          }

          btnExit.setOnClickListener {
              // when user clicks exit button go back to login screen
              val intent = Intent(this, MainActivity::class.java)
              startActivity(intent)
              finish()

          }


    }
}