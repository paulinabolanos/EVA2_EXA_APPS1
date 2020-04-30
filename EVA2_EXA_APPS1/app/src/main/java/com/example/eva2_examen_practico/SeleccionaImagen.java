package com.example.eva2_examen_practico;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SeleccionaImagen extends AppCompatActivity implements ImageView.OnClickListener {



    ImageView imgVwRes1, imgVwRes2, imgVwRes3, imgVwRes4, imgVwRes5, imgVwRes6;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecciona_imagen);
        imgVwRes1 = findViewById(R.id.imgVwRes1);
        imgVwRes2 = findViewById(R.id.imgVwRes2);
        imgVwRes3 = findViewById(R.id.imgVwRes3);
        imgVwRes4 = findViewById(R.id.imgVwRes4);
        imgVwRes5 = findViewById(R.id.imgVwRes5);
        imgVwRes6 = findViewById(R.id.imgVwRes6);
    }


    @Override
    public void onClick(View view) {
        Intent intent = new Intent();

        switch (view.getId()){
            case R.id.imgVwRes1:
                intent.putExtra("imagen",R.drawable.res1);
                break;
            case R.id.imgVwRes2:
                intent.putExtra("imagen", R.drawable.res2);
                break;
            case R.id.imgVwRes3:
                intent.putExtra("imagen", R.drawable.res3);
                break;
            case R.id.imgVwRes4:
                intent.putExtra("imagen", R.drawable.res5);
                break;
            case R.id.imgVwRes5:
                intent.putExtra("imagen", R.drawable.res4);
                break;
            case R.id.imgVwRes6:
                intent.putExtra("imagen", R.drawable.res6);
                break;
            default:
                break;
        }
        setResult(RESULT_OK, intent);

        finish();
    }
}
