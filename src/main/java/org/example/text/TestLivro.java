package org.example.text;

import org.example.db.Conexao;
import org.example.model.Livro;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/*
public class TestLivro  {
    public List<Livro> listaTituloLivro() throws SQLException {
        Connection conn = Conexao.conectar();
        String sql = "SELECT * FROM livros";
        PreparedStatement stmt = conn.prepareStatement(sql); // ve se a query ta pronta pra execução
        ResultSet rs = stmt.executeQuery(); //executa
        List<Livro> livros = new ArrayList<>();

        while (rs.next())  {
            // oq esse rs.next faz -- basicamente percorre a lista e fica retornando true ate que acabe as listas
            Livro livro = new Livro();

            livro.setId(rs.getInt("id"));
            livro.setTitulo(rs.getString("titulo"));
            livro.setAutor(rs.getString("autor"));
            livro.setDisponivel(rs.getBoolean("disponivel"));


            livros.add(livro);
        }
        stmt.close();
        conn.close();
        return livros;
    }
}*/

//EXPLICACOES DE CODIGOS

//sql = "SELECT * FROM livros"; // redefini o valor da variavel sql e mandei selecionar tudo de cursos
//stmt = conn.prepareStatement(sql); // o java pegou o texto da variavel sql e prepara para executar no database
// ResultSet rs = stmt.executeQuery(); // executa no database
