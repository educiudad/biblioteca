package org.example.dao;

import org.example.db.Conexao;
import org.example.model.Emprestimos;

import javax.xml.crypto.Data;
import java.sql.*;
import java.util.Collection;

public class EmprestimosDao {
    public EmprestimosDao(Connection conn) {
    }

    public Boolean registrarEmprestimo(Emprestimos emprestimo) throws SQLException {
        Connection conn = Conexao.conectar();
        LivrosDao livrosDao = new LivrosDao(conn);


        if (!livrosDao.estaDisponivel(emprestimo.getLivroId())) {
            System.out.println("Livro indisponível!");
            return false;
        }

        String sql ="INSERT INTO emprestimos (usuario_id, livro_id, data_emprestimo) VALUES (?,?,?)";

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setInt(1, emprestimo.getUsuarioId());
        stmt.setInt(2, emprestimo.getLivroId());
        stmt.setDate(3,emprestimo.getDataEmprestimo());

        stmt.executeUpdate();
        livrosDao.atualizarDisponibilidade(emprestimo.getLivroId(), false);

        return true;
    }

    public void devolverLIvro(int idEmprestimo, Date dataDevolucao) throws SQLException {
        Connection conn = Conexao.conectar();
        String sql = "UPDATE emprestimos SET data_devolucao = ? WHERE id_emprestimo = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setDate(1, dataDevolucao);
        stmt.setInt(2, idEmprestimo);
        stmt.executeUpdate();
    }

    public void ListarEmprestimos(){
        String sql = """
                SELECT usuarios.nome, livros.titulo, emprestimos.data_emprestimo
                FROM emprestimos
                JOIN usuarios ON emprestimos.usuario_id = usuarios.id
                JOIN livros ON emprestimos.livro_id = livros.id
                """;
        try (
                Connection conn = Conexao.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                String usuario = rs.getString("nome");
                // pega o valor da coluna "nome" da linha atual
// esse valor vem da tabela usuarios
                String livro = rs.getString("titulo");
                // pega o valor da coluna "titulo"
// esse valor vem da tabela livros

                Date data = rs.getDate("data_emprestimo");
                // pega o valor da coluna data_emprestimo
// e converte para o tipo Date do Java
                System.out.println(usuario + " pegou " + livro + " em " + data);
            }


        } catch (SQLException e)
        // captura qualquer erro relacionado ao banco de dados
// por exemplo: erro no SQL, conexão falhou, tabela não existe
        {
        e.printStackTrace();
            // mostra o erro detalhado no console para ajudar na depuração
    }
    }
}
