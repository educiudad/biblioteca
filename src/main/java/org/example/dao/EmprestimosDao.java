package org.example.dao;

import org.example.db.Conexao;
import org.example.model.Emprestimos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;

public class EmprestimosDao {
    public EmprestimosDao(Connection conn) {
    }

    public void registrarEmprestimo(Emprestimos emprestimo) throws SQLException {
        Connection conn = Conexao.conectar();
        String sql ="INSERT INTO emprestimos (usuario_id, livro_id, data_emprestimo) VALUES (?,?,?)";

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setInt(1, emprestimo.getUsuarioId());
        stmt.setInt(2, emprestimo.getLivroId());
        stmt.setDate(3,emprestimo.getDataEmprestimo());

        stmt.executeUpdate();
    }

    public void devolverLIvro(int idEmprestimo, Date dataDevolucao) throws SQLException {
        Connection conn = Conexao.conectar();
        String sql = "UPDATE emprestimos SET data_devolucao = ? WHERE id_emprestimo = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setDate(1, dataDevolucao);
        stmt.setInt(2, idEmprestimo);
        stmt.executeUpdate();
    }
}
