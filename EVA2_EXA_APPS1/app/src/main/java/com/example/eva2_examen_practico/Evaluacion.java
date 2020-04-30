package com.example.eva2_examen_practico;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class Evaluacion extends AppCompatActivity {
    ImageView imgVw, imgVwEs1, imgVwEs2, imgVwEs3;
    TextView txtVwNom, txtVwDesc, txtVwDir;
    SeekBar sbCalificacion;
    Button btnGuardar;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluacion);
        imgVw = findViewById(R.id.imgVw);
        txtVwNom = findViewById(R.id.txtVwNom);
        txtVwDesc = findViewById(R.id.txtVwDesc);
        txtVwDir = findViewById(R.id.txtVwDir);
        imgVwEs1 = findViewById(R.id.imgVwEs1);
        imgVwEs2 = findViewById(R.id.imgVwEs2);
        imgVwEs3 = findViewById(R.id.imgVwEs3);
        sbCalificacion = findViewById(R.id.sbCalificacion);
        btnGuardar = findViewById(R.id.btnGuardar);

        intent = getIntent();
        imgVw.setBackgroundResource(intent.getIntExtra("IMG",R.drawable.estrellan));
        txtVwNom.setText(intent.getStringExtra("NAME"));
        txtVwDesc.setText(intent.getStringExtra("DESC"));
        txtVwDir.setText(intent.getStringExtra("TEL"));
        sbCalificacion.setProgress(intent.getIntExtra("CAL",0));

        switch(intent.getIntExtra("CAL",0)){
            case 1:
                imgVwEs1.setBackgroundResource(R.drawable.estrellaa);
                imgVwEs2.setBackgroundResource(R.drawable.estrellan);
                imgVwEs3.setBackgroundResource(R.drawable.estrellan);
                break;
            case 2:
                imgVwEs1.setBackgroundResource(R.drawable.estrellaa);
                imgVwEs2.setBackgroundResource(R.drawable.estrellaa);
                imgVwEs3.setBackgroundResource(R.drawable.estrellan);
                break;
            case 3:
                imgVwEs1.setBackgroundResource(R.drawable.estrellaa);
                imgVwEs2.setBackgroundResource(R.drawable.estrellaa);
                imgVwEs3.setBackgroundResource(R.drawable.estrellaa);
                break;
            default:
                imgVwEs1.setBackgroundResource(R.drawable.estrellan);
                imgVwEs2.setBackgroundResource(R.drawable.estrellan);
                imgVwEs3.setBackgroundResource(R.drawable.estrellan);
                break;
        }

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent enviar = getIntent();
                enviar.putExtra("NEW",sbCalificacion.getProgress());
                enviar.putExtra("I",intent.getIntExtra("I",1));
                setResult(Activity.RESULT_OK,enviar);
                finish();
            }
        });
    }
}
