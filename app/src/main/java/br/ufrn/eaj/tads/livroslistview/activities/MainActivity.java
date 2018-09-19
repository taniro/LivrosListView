package br.ufrn.eaj.tads.livroslistview.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.ufrn.eaj.tads.livroslistview.R;
import br.ufrn.eaj.tads.livroslistview.adapter.LivroAdapter;
import br.ufrn.eaj.tads.livroslistview.database.AppDatabase;
import br.ufrn.eaj.tads.livroslistview.database.LivroDao;
import br.ufrn.eaj.tads.livroslistview.model.Livro;

public class MainActivity extends AppCompatActivity {

    ListView lista;
    List<Livro> listaLivros = new ArrayList<>();

    AppDatabase db;
    LivroDao myLivroDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = findViewById(R.id.minhalista);

        db = AppDatabase.getDatabase(this);
        myLivroDao = db.livroDao();

        listaLivros = myLivroDao.listAllInList();

        final LivroAdapter livroAdapter = new LivroAdapter(this, listaLivros);
        lista.setAdapter(livroAdapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Livro livro = listaLivros.get(i);
                Toast.makeText(MainActivity.this, ""+livro.getTitulo(), Toast.LENGTH_SHORT).show();
                //Toast.makeText(MainActivity.this, ""+view, Toast.LENGTH_SHORT).show();
                listaLivros.get(i).setLido(!listaLivros.get(i).getLido());
                livroAdapter.notifyDataSetChanged();
            }
        });


    }
}
