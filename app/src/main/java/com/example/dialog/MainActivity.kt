package com.example.dialog

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dialogBtn = findViewById<Button>(R.id.dialogBtn)
        val goToSecondActivityBtn = findViewById<Button>(R.id.goTo2nd)

        val names = arrayOf("Bernhards Bergholds", "Roberts Bišs", "Kristaps Kārlis Cīrulis")
        val checkedItems = booleanArrayOf(false, false, false)

        dialogBtn.setOnClickListener{
            val builder = AlertDialog.Builder(this)
            builder.setTitle("4. Group's Dialog")
            builder.setMultiChoiceItems(names, checkedItems) { dialog, which, isChecked ->
                if (isChecked)
                {
                    Toast.makeText(this, "${names[which]} checked", Toast.LENGTH_SHORT).show()
                }
                else
                {
                    Toast.makeText(this, "${names[which]} unchecked", Toast.LENGTH_SHORT).show()
                }
            }

            builder.setPositiveButton("Ok") { dialog, which ->
                Toast.makeText(this, "You clicked OK", Toast.LENGTH_SHORT).show()
            }

            builder.setNegativeButton("Close") { dialog, which ->
                Toast.makeText(this, "You closed dialog", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }

            goToSecondActivityBtn.setOnClickListener {
                val intent = Intent(this, SecondActivity::class.java)
                startActivity(intent)
            }

            val dialog = builder.create()
            dialog.show()
        }
    }
}