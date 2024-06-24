package pe.edu.unfv.myappqbo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

class RegistroActivity : AppCompatActivity() {

    lateinit var editNombre: EditText
    //lateinit var editPasswor: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)
    }

    fun validarNombre(): Boolean{
        var respuesta = true
        editNombre = findViewById(R.id.etNombre)

        if (editNombre.text.toString().trim().isEmpty()){
            editNombre.isFocusableInTouchMode = true
            editNombre.requestFocus()
            respuesta = false
        }
    }
}