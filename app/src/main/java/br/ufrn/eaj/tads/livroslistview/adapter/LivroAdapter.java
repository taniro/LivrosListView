package br.ufrn.eaj.tads.livroslistview.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.ufrn.eaj.tads.livroslistview.R;
import br.ufrn.eaj.tads.livroslistview.model.Livro;


public class LivroAdapter extends BaseAdapter{

    Context context;
    List<Livro> listaLivros;

    public LivroAdapter(Context context, List<Livro> listaLivros){
        this.context = context;
        this.listaLivros = listaLivros;
    }
    @Override
    public int getCount() {
        return listaLivros != null ? listaLivros.size(): 0;
    }

    @Override
    public Object getItem(int i) {
        return listaLivros.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    //IMPLEMENTAÇÃO 1


    public View getView(int i, View convertView, ViewGroup viewGroup) {

        Log.i("HOLDER", "GetView invocado...");

        View view = LayoutInflater.from(context).inflate(R.layout.livro_item_inflater, viewGroup, false);

        Log.i("HOLDER", "Fazendo buscas por id...");
        TextView textViewTitulo = view.findViewById(R.id.titulo);
        TextView textViewAutor= view.findViewById(R.id.autor);
        TextView textViewQuantidade= view.findViewById(R.id.quantidade);
        ImageView img = view.findViewById(R.id.img);

        Livro livroescolhido = listaLivros.get(i);
        textViewTitulo.setText(livroescolhido.getTitulo());
        textViewAutor.setText(livroescolhido.getAutor());
        textViewQuantidade.setText(""+livroescolhido.getQuantidade());

        if(livroescolhido.getLido() == true){
            img.setImageResource(R.drawable.open);
        }else{
            img.setImageResource(R.drawable.flat);
        }
        return view;
    }




    //IMPLEMENTAÇÃO FINAL


    /*
    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {

        Log.i("HOLDER", "GetView invocado...");

        View view;
        ViewHolder holder;

        if(convertView == null){
            Log.i("HOLDER", "Convert View é nula...");
            view = LayoutInflater.from(context).inflate(R.layout.livro_item_inflater, viewGroup, false);
            holder = new ViewHolder(view);
            view.setTag(holder);

        }else{
            Log.i("HOLDER", "Convert View utilizada.");
            view = convertView;
            holder = (ViewHolder) convertView.getTag();
        }
        //Preenche os dados do livro
        Livro livroescolhido = listaLivros.get(i);

        holder.textViewTitulo.setText(livroescolhido.getTitulo());
        holder.textViewAutor.setText(livroescolhido.getAutor());
        holder.textViewQuantidade.setText(""+livroescolhido.getQuantidade());

        if(livroescolhido.getLido() == true){
            holder.img.setImageResource(R.drawable.open);
        }else{
            holder.img.setImageResource(R.drawable.flat);
        }

        return view;
    }
    */


}
