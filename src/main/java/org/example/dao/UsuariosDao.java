package org.example.dao;

import org.example.db.Conexao;
import org.example.model.Livro;
import org.example.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuariosDao {


    public UsuariosDao(Connection conn) {
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




    public void inserir(Usuario usuario) throws SQLException {

        Connection conn = Conexao.conectar();
        String sql = "INSERt INTO usuarios (nome, email) VALUES (?,?)";
        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setString(1, usuario.getNome());
        stmt.setString(2, usuario.getEmail());

        stmt.executeUpdate();

        System.out.println("Usuario inserido com seucesso!");

        stmt.close();
        conn.close();
    }
}
