package org.example;

import org.example.db.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Main {

    public static void main(String[] args) {

        try {

            Connection conn = Conexao.conectar();

            String sql = "INSERT INTO livros (titulo, autor) VALUES (?, ?)";

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, "Dom Casmurro");
            stmt.setString(2, "Machado de Assis");

            stmt.executeUpdate();

            System.out.println("Livro inserido!");

            sql = "SELECT * FROM usuarios"; // redefini o valor da variavel sql e mandei selecionar tudo de cursos
            stmt = conn.prepareStatement(sql); // o java pegou o texto da variavel sql e prepara para executar no database
            ResultSet rs = stmt.executeQuery(); // executa no database

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}