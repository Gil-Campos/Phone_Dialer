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
    private var started = false
    private var counter: Int = 0
    private val FIVE_SECONDS = 5000L

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
            showLoading()}

        loadingContainer = findViewById(R.id.loadingContainer)
        loadingContainer!!.setOnClickListener {
            hideLoading() }
        setActionBar(null)

    }

    private fun append(number: String) {
        textView.append(number)

    }

    fun hideLoading() {
        started = false
        loadingContainer!!.visibility = View.GONE
        textView.text = ""
        handler.removeCallbacks(toastRunnable)

    }

    private fun showLoading() {
        loadingContainer!!.visibility = View.VISIBLE
        startRepeating()
    }

    private fun startRepeating() {
        //handler.postDelayed(toastRunnable, 5000);
        started = true
        counter = 0
        toastRunnable.run()
    }

    private fun stopRepeating() {
        if (counter < 2) {
            Toast.makeText(this@MainActivity, "This is a delayed toast $counter", Toast.LENGTH_SHORT).show()
        } else {
            started = false
            Toast.makeText(this@MainActivity, "This is a delayed toast $counter", Toast.LENGTH_SHORT).show()
        }

    }


    private val toastRunnable = object : Runnable {
        override fun run() {
            if (started) {
                counter++
                stopRepeating()
                handler.postDelayed(this, FIVE_SECONDS)
            } else {
                hideLoading()
            }
        }
    }

}
