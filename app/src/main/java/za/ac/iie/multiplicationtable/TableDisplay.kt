package za.ac.iie.multiplicationtable

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class TableDisplay : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_table_display)

        val bundle: Bundle? = intent.extras
        val tableString: String? = bundle?.getString("tableNumber")

        //convert the table number to an integer
        val tableNumber = tableString!!.toInt()
        var timesDisplay: String = "$tableNumber x table\n\n"
        //creating counter for while loop
        var count = 1
        //display the heading so we can see the value in action
        val multiplicationTable = findViewById<TextView>(R.id.numTextInput)
        multiplicationTable.text = "$tableNumber x table\n\n"

        while (count <= 10){
            //example: user enters 5 and count is
            val answer = tableNumber * count
            timesDisplay += "$tableNumber x $count x ${answer}\n"
            //increasing the count
            count++
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}