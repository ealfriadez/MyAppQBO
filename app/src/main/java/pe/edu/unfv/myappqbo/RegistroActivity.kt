package pe.edu.unfv.myappqbo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import com.google.android.material.snackbar.Snackbar

class RegistroActivity : AppCompatActivity() {

    lateinit var edit_Nombre: EditText
    lateinit var rb_Genero: RadioButton
    lateinit var chk_Deporte: CheckBox
    lateinit var chk_Dibujo: CheckBox
    lateinit var chk_Otros: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)
    }

    fun obtenerGeneroSeleccionado(): String{
        var genero = ""
        rb_Genero = findViewById(R.id.rgGenero)

        when(rb_Genero.id)
    }

    fun validarFormulario(vista: View): Boolean{
        var respuesta = false
        if(!validarNombre()){
            enviarMensajeError(vista, "Es obligatorio su nombre")
        }else if (!validarGenero()){
            enviarMensajeError(vista, "Es obligatorio su genero")
        }else if (!validarPreferencias()) {
            enviarMensajeError(vista, "Es obligatorio su genero")
        }else{
            respuesta = true
        }
        return respuesta
    }

    fun enviarMensajeError(vista: View, mensajeError: String){
        Snackbar.make(vista, mensajeError, Snackbar.LENGTH_LONG).show()
    }

    fun validarPreferencias(): Boolean{
        var respuesta = false
        chk_Deporte = findViewById(R.id.chkDeporte)
        chk_Dibujo = findViewById(R.id.chkDibujo)
        chk_Otros = findViewById(R.id.chkOtros)

        if (chk_Deporte.isChecked || chk_Dibujo.isChecked || chk_Otros.isChecked){
            respuesta = true
        }
        return respuesta
    }

    fun validarGenero(): Boolean{
        var respuesta = true
        rb_Genero = findViewById(R.id.rgGenero)

        if (rb_Genero.isChecked){
            respuesta = false
        }
        return respuesta
    }

    fun validarNombre(): Boolean{
        var respuesta = true
        edit_Nombre = findViewById(R.id.etNombre)

        if (edit_Nombre.text.toString().trim().isEmpty()){
            edit_Nombre.isFocusableInTouchMode = true
            edit_Nombre.requestFocus()
            respuesta = false
        }
        return respuesta
    }
}