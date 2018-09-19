package br.ufrn.eaj.tads.livroslistview.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import br.ufrn.eaj.tads.livroslistview.model.Livro;


@Database(entities = {Livro.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract LivroDao livroDao();

    private static AppDatabase INSTANCE;

    public static AppDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "livro_database.sqlite")
                            .allowMainThreadQueries()
                            .build();

                }
            }
        }

        //deleta todas
        INSTANCE.livroDao().deleteAll();

        Livro l1 = new Livro("Harry Potter e a pedra filosofal", "J. K. Rowling", 2, true);
        Livro l2 = new Livro("Harry Potter e a Câmara Secreta", "J. K. Rowling", 3, true);
        Livro l3 = new Livro("Harry Potter e o Prisioneiro de Azkaban", "J. K. Rowling", 5, true);
        Livro l4 = new Livro("Harry Potter e o Cálice de Fogo", "J. K. Rowling", 2, true);
        Livro l5 = new Livro("Harry Potter e a Ordem da Fênix", "J. K. Rowling", 1, false);
        Livro l6 = new Livro("Harry Potter e o Enigma do Príncipe", "J. K. Rowling", 3, false);
        Livro l7 = new Livro("Harry Potter e as Relíquias da Morte", "J. K. Rowling", 2, false);
        Livro l8 = new Livro("O pistoleiro", "Stephen King", 1, true);
        Livro l9 = new Livro("A Escolha dos Três ", "Stephen King", 5, true);
        Livro l10 = new Livro("As Terras Devastadas", "Stephen King", 4, true);
        Livro l11 = new Livro("Mago e Vidro", "Stephen King", 3, true);
        Livro l12 = new Livro("Lobos de Calla", "Stephen King", 2, false);
        Livro l13 = new Livro("Canção de Susannah", "Stephen King", 4, false);
        Livro l14 = new Livro("A Torre Negra", "Stephen King", 5, false);
        Livro l15 = new Livro("O Vento Pela Fechadura", "Stephen King", 5, true);
        Livro l16 = new Livro("Viagem ao centro da terra ", "Júlio Verne", 3, false);
        Livro l17 = new Livro("Senhor dos Anéis: a sociedade do anel", "Tolkien", 1, true);
        Livro l18 = new Livro("Senhor dos Anéis: as duas torres", "Tolkien", 1, true);
        Livro l19 = new Livro("Senhor dos Anéis: o retorno do rei", "Tolkien", 1, true);
        Livro l20 = new Livro("Dom Casmurro", "Machado de Assis", 4, false);

        //cadastra novamente
        INSTANCE.livroDao().inserirAll(new Livro[]{l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14, l15, l16, l17, l18, l19, l20});

        return INSTANCE;
    }
}
