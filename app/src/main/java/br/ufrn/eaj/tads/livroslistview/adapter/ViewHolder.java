package br.ufrn.eaj.tads.livroslistview.adapter;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import br.ufrn.eaj.tads.livroslistview.R;


public class ViewHolder {

    final TextView textViewTitulo;
    final TextView textViewAutor;
    final TextView textViewQuantidade;
    final ImageView img;

    public ViewHolder (View v){
        Log.i("HOLDER", "Fazendo buscas por id...");
        textViewTitulo = v.findViewById(R.id.titulo);
        textViewAutor=  v.findViewById(R.id.autor);
        textViewQuantidade=  v.findViewById(R.id.quantidade);
        img = v.findViewById(R.id.img);
    }
}
