package sg.edu.rp.s19024292.mycalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.roundToLong

class MainActivity : AppCompatActivity() {

    var minusNumber = 0.0
    var divideNumber = 0.0
    var timesNumber = 0.0
    var addNumber = 0.0

    var add = false
    var btnMessage = ""
    var minus = false
    var divide = false
    var times = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnMinus.setOnClickListener {
            minusNumber = tvNumber.text.toString().toDouble()
            minus = true
            btnMessage = ""
            tvNumber.text = ""
        }

        btnAddition.setOnClickListener {
            addNumber = tvNumber.text.toString().toDouble()
            add = true
            btnMessage = ""
            tvNumber.text = ""
        }

        btnDivide.setOnClickListener {
            divideNumber = tvNumber.text.toString().toDouble()
            divide = true
            btnMessage = ""
            tvNumber.text = ""
        }

        btnTimes.setOnClickListener {
            timesNumber = tvNumber.text.toString().toDouble()
            times = true
            btnMessage = ""
            tvNumber.text = ""
        }

        btnEqual.setOnClickListener {
            if (minus) {
                var number = tvNumber.text.toString().toDouble()
                var minusFinalResult = minusNumber - number
//                val rounded = String.format("%.3f", minusFinalResult)
                tvNumber.text = minusFinalResult.toString()
                minus = false
            } else if (add) {
                var additionFinalResult = addNumber + tvNumber.text.toString().toDouble()
                val rounded = String.format("%.3f", additionFinalResult)
                tvNumber.text = rounded
                add = false
            } else if (divide) {
                var divideFinalResult = divideNumber / tvNumber.text.toString().toDouble()
                val rounded = String.format("%.3f", divideFinalResult)
                tvNumber.text = rounded
                divide = false
            } else if (times) {
                var timesFinalResult = timesNumber * tvNumber.text.toString().toDouble()
                val rounded = String.format("%.3f", timesFinalResult)
                tvNumber.text = rounded
                times = false
            }
        }
    }

    fun btnAcOnClick(view: View) {
        tvNumber.text = "0"
        btnMessage = ""
    }

    fun btnOnClick(view: View) {

        val btnSelected = view as Button
        when (btnSelected.id) {
            btn0.id -> btnMessage += "0"
            btn1.id -> btnMessage += "1"
            btn2.id -> btnMessage += "2"
            btn3.id -> btnMessage += "3"
            btn4.id -> btnMessage += "4"
            btn5.id -> btnMessage += "5"
            btn6.id -> btnMessage += "6"
            btn7.id -> btnMessage += "7"
            btn8.id -> btnMessage += "8"
            btn9.id -> btnMessage += "9"
            btnDot.id -> btnMessage += "."
        }
        tvNumber.text = btnMessage
    }


}