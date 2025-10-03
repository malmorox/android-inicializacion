package app.calculator

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.primera_app.R

class CalculatorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_calculator)

        var cajaOperacion = findViewById<TextView>(R.id.operacion)
        var cajaResultado = findViewById<TextView>(R.id.resultado)
        cajaResultado.text = "0"
        var numero1: String = ""
        var numero2: String = ""
        var operador: String = ""
        var resultado: String = ""
        var ultimaOperacion: String = ""
        var hayOperador: Boolean = false
        var modoError: Boolean = false

        fun listenerNumeros(num: String) {
            if (modoError) return
            if (!hayOperador) {
                cajaResultado.text = ""
                numero1 += num
                cajaResultado.text = numero1
            } else {
                numero2 += num
                cajaResultado.text = "$numero1 $operador $numero2"
            }
        }

        fun listenerOperadores(op: String) {
            if (modoError) return
            if (!hayOperador) {
                if (numero1.isEmpty()) {
                    numero1 = "0"
                }
                hayOperador = true
                operador = op
                cajaResultado.text = "$numero1 $operador"
            }
        }

        var btnNum1 = findViewById<AppCompatButton>(R.id.boton1)
        var btnNum2 = findViewById<AppCompatButton>(R.id.boton2)
        var btnNum3 = findViewById<AppCompatButton>(R.id.boton3)
        var btnNum4 = findViewById<AppCompatButton>(R.id.boton4)
        var btnNum5 = findViewById<AppCompatButton>(R.id.boton5)
        var btnNum6 = findViewById<AppCompatButton>(R.id.boton6)
        var btnNum7 = findViewById<AppCompatButton>(R.id.boton7)
        var btnNum8 = findViewById<AppCompatButton>(R.id.boton8)
        var btnNum9 = findViewById<AppCompatButton>(R.id.boton9)
        var btnNum0 = findViewById<AppCompatButton>(R.id.boton0)
        var btnSum = findViewById<AppCompatButton>(R.id.botonSuma)
        var btnRes = findViewById<AppCompatButton>(R.id.botonResta)
        var btnMul = findViewById<AppCompatButton>(R.id.botonMultiplicacion)
        var btnDiv = findViewById<AppCompatButton>(R.id.botonDivision)
        var btnPunto = findViewById<AppCompatButton>(R.id.botonPunto)
        var btnBorrar = findViewById<AppCompatButton>(R.id.botonBorrar)
        var btnIgual = findViewById<AppCompatButton>(R.id.botonIgual)

        btnNum0.setOnClickListener { listenerNumeros("0") }
        btnNum1.setOnClickListener { listenerNumeros("1") }
        btnNum2.setOnClickListener { listenerNumeros("2") }
        btnNum3.setOnClickListener { listenerNumeros("3") }
        btnNum4.setOnClickListener { listenerNumeros("4") }
        btnNum5.setOnClickListener { listenerNumeros("5") }
        btnNum6.setOnClickListener { listenerNumeros("6") }
        btnNum7.setOnClickListener { listenerNumeros("7") }
        btnNum8.setOnClickListener { listenerNumeros("8") }
        btnNum9.setOnClickListener { listenerNumeros("9") }
        btnSum.setOnClickListener { listenerOperadores("+") }
        btnRes.setOnClickListener { listenerOperadores("-") }
        btnMul.setOnClickListener { listenerOperadores("×") }
        btnDiv.setOnClickListener { listenerOperadores("÷") }

        btnPunto.setOnClickListener {
            if (modoError) return@setOnClickListener
            if (!hayOperador && !numero1.contains(".")) {
                if (numero1.isEmpty()) {
                    numero1 = "0."
                } else {
                    numero1 += "."
                }
                cajaResultado.text = numero1
            } else if (hayOperador && !numero2.contains(".")) {
                if (numero2.isEmpty()) {
                    numero2 = "0."
                } else {
                    numero2 += "."
                }
                cajaResultado.text = "$numero1 $operador $numero2"
            }
        }

        btnBorrar.setOnClickListener {
            numero1 = ""
            numero2 = ""
            operador = ""
            hayOperador = false
            modoError = false
            cajaOperacion.text = ""
            cajaResultado.text = "0"
            ultimaOperacion = ""
        }

        btnIgual.setOnClickListener {
            if (numero1.isNotEmpty() && numero2.isNotEmpty() && operador.isNotEmpty()) {
                val num1 = numero1.toDouble()
                val num2 = numero2.toDouble()
                val res = when (operador) {
                    "+" -> sumar(num1, num2)
                    "-" -> restar(num1, num2)
                    "×" -> multiplicar(num1, num2)
                    "÷" -> {
                        if (num2 != 0.0) {
                            dividir(num1, num2)
                        } else {
                            modoError = true
                            "Error"
                        }
                    }
                    else -> {
                        modoError = true
                        "Error"
                    }
                }
                resultado = when (res) {
                    is String -> res
                    is Double -> if (res % 1.0 == 0.0) res.toInt().toString() else res.toString()
                    is Float -> if (res % 1f == 0f) res.toInt().toString() else res.toString()
                    is Int -> res.toString()
                    else -> res.toString()
                }
                ultimaOperacion = "$numero1 $operador $numero2"
                cajaOperacion.text = ultimaOperacion
                cajaResultado.text = resultado
                if (resultado != "Error") {
                    numero1 = "0"
                    numero1 = resultado
                    numero2 = ""
                    operador = ""
                    hayOperador = false
                    modoError = false
                    ultimaOperacion = ""
                }
            }
        }
    }

    fun sumar(a: Double, b: Double): Double {
        return a + b
    }

    fun restar(a: Double, b: Double): Double {
        return a - b
    }

    fun multiplicar(a: Double, b: Double): Double {
        return a * b
    }

    fun dividir(a: Double, b: Double): Double {
        return a / b
    }
}