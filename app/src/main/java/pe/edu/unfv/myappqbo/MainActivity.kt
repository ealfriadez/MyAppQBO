package pe.edu.unfv.myappqbo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    var buttonLogin: Button? = null
    var editUsuario: EditText? = null
    var editPasswor: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonLogin = findViewById(R.id.btnLogin)
        buttonLogin?.setOnClickListener {
            var usuario = editUsuario?.text.toString()
            var passwor = editPasswor?.text.toString()

            if (!usuario.isNullOrEmpty()) editUsuario?.error = "Ingrese su usuario"
            if (!passwor.isNullOrEmpty()) editPasswor?.error = "Ingrese su password"

            if (validarUsuario(usuario, passwor)) {
                val intenLogin = Intent(
                    this, RegistroActivity::class.java
                ).apply {
                    putExtra("usuario", usuario)
                    putExtra("password", passwor)
                }
                    startActivity(intenLogin)
            }else{
                Snackbar.make(it, "Usuario o password incorrecto",
                Snackbar.LENGTH_LONG).show()
            }
        }
    }

    fun validarUsuario(usu: String, pwd: String): Boolean{
        var respuesta = false

        if (usu == "lsalvatierra" && pwd == "123456"){
            respuesta = true
        }
        return respuesta
    }
}