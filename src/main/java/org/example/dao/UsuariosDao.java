package org.example.dao;

import org.example.db.Conexao;
import org.example.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsuariosDao {
    public void inserir(Usuario usuario) throws SQLException {

        Connection conn = Conexao.conectar();
        String sql = "INSERt INTO usuarios (nome, email) VALUES (?,?)";
        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setString(1, usuario.getNome());
        stmt.setString(2, usuario.getEmail());

        stmt.executeUpdate();

        System.out.println("Usuario inserido!");
    }
}
