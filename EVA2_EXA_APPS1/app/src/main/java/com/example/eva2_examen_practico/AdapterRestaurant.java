package com.example.eva2_examen_practico;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterRestaurant extends ArrayAdapter<Restaurant> {
    Context context;
    int resource;
    ArrayList<Restaurant> restaurants;

    public AdapterRestaurant(Context context, int resource, ArrayList<Restaurant> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.restaurants = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imgVw, imgVwEs1, imgVwEs2, imgVwEs3;
        TextView txtVwNom,  txtVwDesc, txtVwDir;

        //ConvertView es el layout que representa una fila en la lista
        if (convertView == null){
            //Crear nuestro Layout
            //Inflater
            LayoutInflater layoutInflater = ((Activity)context).getLayoutInflater();
            convertView = layoutInflater.inflate(resource, parent, false);
        }
        imgVw = convertView.findViewById(R.id.imgVw);
        txtVwNom = convertView.findViewById(R.id.txtVwNom);
        txtVwDesc = convertView.findViewById(R.id.txtVwDesc);
        txtVwDir = convertView.findViewById(R.id.txtVwDir);
        imgVwEs1 = convertView.findViewById(R.id.imgVwEs1);
        imgVwEs2 = convertView.findViewById(R.id.imgVwEs2);
        imgVwEs3 = convertView.findViewById(R.id.imgVwEs3);

        imgVw.setImageResource(restaurants.get(position).getImagen());
        txtVwNom.setText(restaurants.get(position).getNombre());
        txtVwDesc.setText(restaurants.get(position).getDescripcion());
        txtVwDir.setText(restaurants.get(position).getDireccionYTel());
        switch(restaurants.get(position).getEvaluacion()){
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
        return convertView;
    }
}
