package br.ufrn.eaj.tads.livroslistview.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Livro {

    @PrimaryKey(autoGenerate = true)
    private long id;
    private String titulo;
    private String autor;
    private int quantidade;
    private Boolean lido;

    public Livro(String titulo, String autor, int quantidade, Boolean lido) {
        this.titulo = titulo;
        this.autor = autor;
        this.quantidade = quantidade;
        this.lido = lido;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setLido(Boolean lido) {
        this.lido = lido;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public Boolean getLido() {
        return lido;
    }
}
