package com.example.activityforresult;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editarProvincia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editarProvincia = (EditText) findViewById(R.id.editProvincia);
    }

    public void abrirActividad(View view){
        Intent abreIntent = new Intent(getApplicationContext(), ActivityForResultActivity.class);
        startActivityForResult(abreIntent, 200);

    }

    /**
     * @description: Método que permite gestionar el retorno de la llamada a la segunda actividad
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK && requestCode == 200){
            editarProvincia.setText(data.getExtras().getString("Resultado"));
        } else {
            Toast.makeText(getApplicationContext(), "El retorno no tiene datos", Toast.LENGTH_LONG).show();
        }
    }
}
