package com.example.calculadora

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.calculadora.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    private var oper1: Double = Double.NaN
    private var oper2: Double = Double.NaN
    private var Operacion = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.Boton0.setOnClickListener(this)
        binding.Boton1.setOnClickListener(this)
        binding.Boton2.setOnClickListener(this)
        binding.Boton3.setOnClickListener(this)
        binding.Boton4.setOnClickListener(this)
        binding.Boton5.setOnClickListener(this)
        binding.Boton6.setOnClickListener(this)
        binding.Boton7.setOnClickListener(this)
        binding.Boton8.setOnClickListener(this)
        binding.Boton9.setOnClickListener(this)
        binding.Botonsumar.setOnClickListener(this)
        binding.Botonrestar.setOnClickListener(this)
        binding.Botonmultiplicar.setOnClickListener(this)
        binding.Botondividir.setOnClickListener(this)
        binding.igual.setOnClickListener(this)
        binding.Borrar.setOnClickListener(this)

    }
    override fun onClick(vista: View?) {
        when (vista?.id) {
            R.id.Boton0 -> {
                aggregateNumerous("0")
            }
            R.id.Boton1 -> {
                aggregateNumerous("1")
            }
            R.id.Boton2 -> {
                aggregateNumerous("2")
            }
            R.id.Boton3 -> {
                aggregateNumerous("3")
            }
            R.id.Boton4 -> {
                aggregateNumerous("4")
            }
            R.id.Boton5 -> {
                aggregateNumerous("5")
            }
            R.id.Boton6 -> {
                aggregateNumerous("6")
            }
            R.id.Boton7 -> {
                aggregateNumerous("7")
            }
            R.id.Boton8 -> {
                aggregateNumerous("8")
            }
            R.id.Boton9 -> {
                aggregateNumerous("9")
            }
            R.id.Botonsumar -> {
                respectableOperator("+")
            }
            R.id.Botonrestar -> {
                respectableOperator("-")
            }
            R.id.Botonmultiplicar -> {
                respectableOperator("*")
            }
            R.id.Botondividir -> {
                respectableOperator("/")
            }
            R.id.igual -> {
                calculatorResultant()
            }
            R.id.Borrar -> {
                boarNumerous()
            }
        }
    }
    private fun aggregateNumerous(numerous: String) {
        if (binding.Respuesta.text.toString() == "Error") {
            binding.Respuesta.text = ""
        }
        binding.Respuesta.append(numerous)
    }

    private fun respectableOperator(operator: String) {
        if (!binding.Respuesta.text.isNullOrEmpty()) {
            oper1 = binding.Respuesta.text.toString().toDouble()
            binding.Respuesta.text = ""
            Operacion = operator
        }
    }

    private fun boarNumerous() {
        val textoActual = binding.Respuesta.text.toString()
        if (textoActual.isNotEmpty()) {
            // Elimina el último dígito
            binding.Respuesta.text = textoActual.substring(0, textoActual.length - 1)
        }
    }

    private fun calculatorResultant() {
        if (!binding.Respuesta.text.isNullOrEmpty() && !Operacion.isEmpty()) {
            oper2 = binding.Respuesta.text.toString().toDouble()
            var resultado = 0.0
            when (Operacion) {
                "+" -> resultado = oper1 + oper2
                "-" -> resultado = oper1 - oper2
                "*" -> resultado = oper1 * oper2
                "/" -> {
                    if (oper2 != 0.0) {
                        resultado = oper1 / oper2
                    } else {
                        binding.Respuesta.text = "Error"
                        return
                    }
                }
            }
            binding.Respuesta.text = resultado.toString()
        }
    }
}