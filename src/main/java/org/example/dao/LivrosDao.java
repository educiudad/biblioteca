package org.example.dao;

import org.example.db.Conexao;
import org.example.model.Livro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LivrosDao {
    public void inserir(Livro livro) throws SQLException {

        Connection conn = Conexao.conectar();

        String sql = "INSERT INTO livros (titulo, autor) VALUES (?, ?)";

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setString(1, livro.getNome());
        stmt.setString(2, livro.getAutor());

        stmt.executeUpdate();

        System.out.println("Livro inserido!");

        sql = "SELECT * FROM livros"; // redefini o valor da variavel sql e mandei selecionar tudo de cursos
        stmt = conn.prepareStatement(sql); // o java pegou o texto da variavel sql e prepara para executar no database
        ResultSet rs = stmt.executeQuery(); // executa no database
    }
}


