package com.example.eva2_examen_practico;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class Capturar extends AppCompatActivity implements ImageView.OnClickListener {
    Restaurant restaurante;
    EditText edTxtNom, edTxtDesc, edTxtDir;
    ImageView imgVw;

    int REQUEST_CODE = 10;

    int idRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capturar);
        imgVw = findViewById(R.id.imgVw);
        edTxtNom = findViewById(R.id.edTxtNom);
        edTxtDesc = findViewById(R.id.edTxtDesc);
        edTxtDir = findViewById(R.id.edTxtDir);
    }



    public void onClickGuardar(View v){
        //imagen
        Intent intent = new Intent();
        restaurante = new Restaurant(idRes, edTxtNom.getText().toString(), edTxtDesc.getText().toString(), edTxtDir.getText().toString(), 0);
        Bundle bundle = new Bundle();
        bundle.putSerializable("restaurante",restaurante);
        intent.putExtras(bundle);
        setResult(RESULT_OK,intent);
        finish();
    }


    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, SeleccionaImagen.class);
        startActivityForResult(intent, REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE){
            if (data.hasExtra("imagen")){
                imgVw.setImageResource(data.getExtras().getInt("imagen"));
                idRes = data.getExtras().getInt("imagen");
                data.removeExtra("imagen");
            }
        }
    }
}
