package org.example.model;

import org.example.db.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private int id;
    private String nome;
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //explicacao linha de baixo: o metodo vai buscar usuarios no database e devolver uma lista de objetos Usuarios
    public List<Usuario> listaUsuarios() throws SQLException {
    //throws SQLException -- se der merda no database o metodo pode abrir exceção
    Connection conn = Conexao.conectar(); //cria a conexao com o database

    String sql = "SELECT * FROM usuarios";
    PreparedStatement stmt = conn.prepareStatement(sql);
    ResultSet rs = stmt.executeQuery();

    List<Usuario> usuarios = new ArrayList<>();//criei a lista que vai ficar os bagulho dos usuarios
    while (rs.next())  {
        // oq esse rs.next faz -- basicamente percorre a lista e fica retornando true ate que acabe as listas
        Usuario usuario = new Usuario();

        usuario.setId(rs.getInt("id"));
        usuario.setNome(rs.getString("nome"));
        usuario.setEmail(rs.getString("email"));

        usuarios.add(usuario);
    }
    stmt.close();
    conn.close();
    return usuarios;
    }

}
