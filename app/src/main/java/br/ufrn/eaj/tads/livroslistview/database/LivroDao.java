package br.ufrn.eaj.tads.livroslistview.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import br.ufrn.eaj.tads.livroslistview.model.Livro;

@Dao
public interface LivroDao {
    @Insert
    long inserir(Livro l);

    @Insert
    long[] inserirAll(Livro... l);

    @Delete
    int deletar(Livro l);

    @Query("DELETE FROM Livro")
    int deleteAll();

    @Update
    int atualizar(Livro l);

    @Query("SELECT * FROM Livro")
    Livro[] listAllinArray();

    @Query("SELECT * FROM Livro")
    List<Livro> listAllInList();;

    @Query("SELECT * FROM Livro WHERE id = :id")
    Livro[] listById(long id);

    @Query("SELECT COUNT(id) FROM livro")
    int getNumberOfRows();
}
