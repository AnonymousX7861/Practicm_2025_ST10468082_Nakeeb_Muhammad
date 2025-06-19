package vcmsa.nakeeb.practicm_2025_st10468082_nakeeb_muhammad

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        } // code starts here
          // main logic
          // link to backend
          val btnEnter = findViewById<Button>(R.id.btnEnter)
          val edtUsername = findViewById<EditText>(R.id.edtUsername)
          val edtPassword = findViewById<EditText>(R.id.edtPassword)
          val tvWelcome = findViewById<TextView>(R.id.tvWelcome)

          btnEnter.setOnClickListener {
              val username = edtUsername.text.toString()
              val password = edtPassword.text.toString()
              tvWelcome.text = "Welcome $username"
              edtUsername.text.clear()
              edtPassword.text.clear()
              if (username == "admin" && password == "admin") {
                  tvWelcome.text = "Welcome Admin"
              }
              if (username == "user" && password == "user") {
                  tvWelcome.text = "Welcome User"
              }
              if (username.isEmpty() || password.isEmpty()) {
                  Toast.makeText(this, "Please enter username and password", Toast.LENGTH_LONG)
                      .show()
              }

              val intent = Intent(this, Main_Screen::class.java)
              startActivity(intent)
              finish()


          }

    }
}


