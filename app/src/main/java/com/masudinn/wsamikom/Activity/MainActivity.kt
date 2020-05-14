package com.masudinn.wsamikom.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.masudinn.wsamikom.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var email=" "
    var pass=" "

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       btnlgn.setOnClickListener {

           email = edtmail.text.toString()
           pass = edtpass.text.toString()

           if (pass=="1111"){
               Toast.makeText(this, "berhasil $email",Toast.LENGTH_SHORT).show()
               val Intent = Intent(this@MainActivity, HomeActivity::class.java)
               Intent.putExtra("user",email)
               edtmail.text.clear()
               edtpass.text.clear()
               startActivity(Intent)
           }else{
               Toast.makeText(this,"GAGAL BRO,COBANOneh",Toast.LENGTH_SHORT).show()
           }
       }
    }
}
