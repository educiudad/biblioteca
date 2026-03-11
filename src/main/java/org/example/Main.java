package org.example;

import org.example.dao.LivrosDao;
import org.example.db.Conexao;
import org.example.model.Livro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws SQLException {

        Livro livro = new Livro();

        livro.setTitulo("Estruturas de Dados");
        livro.setAutor("Carlos");
        livro.setDisponivel(true);
        LivrosDao dao = new LivrosDao();
        dao.inserir(livro);

    /*
        livro.setId(1);
        livro.setTitulo("Java Avançado");
        livro.setAutor("João");
        livro.setDisponivel(true);

        dao.atualizar(livro);
        */

        List<Livro> livros = dao.listaLivros();

        for (Livro livroFor : livros) {

            System.out.println(
                            livroFor.getId() + " | " +
                            livroFor.getTitulo() + " | " +
                            livroFor.getAutor() + " | " +
                            livroFor.getDisponivel()
            );

        }


    }

}