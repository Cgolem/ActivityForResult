package com.example.activityforresult;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityForResultActivity extends AppCompatActivity {
    EditText editarRetorno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_for_result);

        editarRetorno = (EditText) findViewById(R.id.editRetorno);
    }

    /**
     * @description: Método encargado de retornar el dato ingresado
     */
    public void onAcepta(View view){

        //Si existe algun dato ingresado, accedemos a este IF
        if( editarRetorno.getText().length() != 0 ){
            Intent retornaDato = getIntent();

            //Retornamos el dato obtenido en el editText
            retornaDato.putExtra("Resultado", editarRetorno.getText().toString());

            //Indicamos que el resultado es correcto y enviamos nuestro intent
            setResult(RESULT_OK, retornaDato);

            //Finalizamos la actividad en la que estamos
            finish();
        } else {
            //Si no existe contenido emitimos un mensaje
            Toast.makeText(getApplicationContext(), "No hay datos ingresados", Toast.LENGTH_LONG).show();
        }
    }

    public void onCancela(View view) {
        //Indicamos que el reultado fue cancelado
        setResult(RESULT_CANCELED);

        //Finalizamos la actividad en la que estamos
        finish();
    }
}
