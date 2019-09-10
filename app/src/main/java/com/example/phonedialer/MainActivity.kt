package com.example.phonedialer
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView
    private lateinit var loadingContainer: View
    private var handler: Handler = Handler()
    private var counter: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)

        val button1 = findViewById<Button>(R.id.button1)
        button1.setOnClickListener {
            append("1")
        }

        val button2 = findViewById<Button>(R.id.button2)
        button2.setOnClickListener {
            append("2")
        }

        val button3 = findViewById<Button>(R.id.button3)
        button3.setOnClickListener {
            append("3")
        }

        val button4 = findViewById<Button>(R.id.button4)
        button4.setOnClickListener {
            append("4")
        }

        val button5 = findViewById<Button>(R.id.button5)
        button5.setOnClickListener {
            append("5")
        }

        val button6 = findViewById<Button>(R.id.button6)
        button6.setOnClickListener {
            append("6")
        }

        val button7 = findViewById<Button>(R.id.button7)
        button7.setOnClickListener {
            append("7")
        }

        val button8 = findViewById<Button>(R.id.button8)
        button8.setOnClickListener {
            append("8")
        }

        val button9 = findViewById<Button>(R.id.button9)
        button9.setOnClickListener {
            append("9")
        }

        val button0 = findViewById<Button>(R.id.button0)
        button0.setOnClickListener {
            append("0")
        }

        val buttonC = findViewById<Button>(R.id.buttonC)
        buttonC.setOnClickListener {
            textView.text = ""
        }

        val llamar = findViewById<Button>(R.id.llamar)
        llamar!!.setOnClickListener {
            showLoading(true)}

        loadingContainer = findViewById(R.id.loadingContainer)
        loadingContainer!!.setOnClickListener {
            showLoading(false) }
        setActionBar(null)

    }

    private fun append(number: String) {
        textView.append(number)

    }

    private fun showLoading(show: Boolean) {
        val visibility = if(show) View.VISIBLE else View.GONE

        if (!show) {
            textView.text = ""
        }
        
        loadingContainer!!.visibility = visibility
    }

}
