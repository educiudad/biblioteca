package org.example.dao;

import org.example.db.Conexao;
import org.example.model.Livro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LivrosDao {

    public LivrosDao(Connection conn) {
    }

    public void inserir(Livro livro) throws SQLException {

        Connection conn = Conexao.conectar();

        String sql = "INSERT INTO livros (titulo, autor) VALUES (?, ?)";

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setString(1, livro.getTitulo());
        stmt.setString(2, livro.getAutor());

        stmt.executeUpdate();

        System.out.println("Livro inserido!");


        stmt.close();
        conn.close();
    }


    public void atualizar(Livro livro) throws SQLException { // metodo que atualiza os dados de um livro existente

        Connection conn = Conexao.conectar(); // cria conexão com o banco

        String sql = "UPDATE livros SET titulo = ?, autor = ?, disponivel = ? WHERE id = ?"; // query para atualizar o livro

        PreparedStatement stmt = conn.prepareStatement(sql); // prepara a query para execução

        stmt.setString(1, livro.getTitulo()); // coloca o titulo do objeto livro no primeiro ?
        stmt.setString(2, livro.getAutor()); // coloca o autor no segundo ?
        stmt.setBoolean(3, livro.getDisponivel()); // coloca o valor de disponível no terceiro ?
        stmt.setInt(4, livro.getId()); // coloca o id no quarto ?, usado para saber qual livro atualizar

        stmt.executeUpdate(); // executa o UPDATE no banco

        stmt.close(); // fecha o PreparedStatement
        conn.close(); // fecha a conexão

        System.out.println("Livro atualizado!"); // mensagem para confirmar que funcionou
    }

    public void deletar(int id) throws SQLException {
        Connection conn = Conexao.conectar();
        String sql = "delete from livros where idLivros = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.executeUpdate();

        stmt.close();
        conn.close();

        System.out.println("Livro deletado!");

    }

    public Livro buscarPorId(int id) throws SQLException { // metodo que retorna um objeto Livro procurando pelo id

        Connection conn = Conexao.conectar(); // cria conexão com o banco de dados

        String sql = "SELECT * FROM livros WHERE id = ?"; // query SQL para buscar um livro específico

        PreparedStatement stmt = conn.prepareStatement(sql); // prepara a query para execução no banco

        stmt.setInt(1, id); // substitui o ? pelo valor do id passado nos métodos

        ResultSet rs = stmt.executeQuery(); // executa o SELECT e guarda o resultado em um ResultSet

        Livro livro = null; // cria variável que vai armazenar o livro encontrado

        if (rs.next()) { // verifica se o banco retornou algum resultado

            livro = new Livro(); // cria um objeto Livro para armazenar os dados do banco

            livro.setId(rs.getInt("id")); // pega o valor da coluna id do ResultSet e coloca no objeto livro
            livro.setTitulo(rs.getString("titulo")); // pega o titulo do banco
            livro.setAutor(rs.getString("autor")); // pega o autor do banco
            livro.setDisponivel(rs.getBoolean("disponivel")); // pega se o livro está disponível
        }

        stmt.close(); // fecha o PreparedStatement
        conn.close(); // fecha a conexão com o banco

        return livro; // retorna o objeto livro encontrado (ou null se não existir)
    }

    public List<Livro> listaLivros() throws SQLException {
        Connection conn = Conexao.conectar();
        String sql = "SELECT * FROM livros";
        PreparedStatement stmt = conn.prepareStatement(sql); // ve se a query ta pronta pra execução
        ResultSet rs = stmt.executeQuery(); //executa
        List<Livro> livros = new ArrayList<>();

        while (rs.next()) {
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

    public Boolean estaDisponivel(int id) throws SQLException {
        Connection conn = Conexao.conectar();


        String sql = "SELECT disponivel FROM livros WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        // stmt.setBoolean(1, disponivel);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        // stmt.executeUpdate();
        if (rs.next()) {
            return rs.getBoolean("disponivel");
        }

        return false; // se não encontrou o livro
    }

    public void atualizarDisponibilidade(int livroId, boolean disponivel) throws SQLException {
        Connection conn = Conexao.conectar();
        String sql = "UPDATE livros SET disponivel = ? WHERE id = ?";

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setBoolean(1, disponivel);
        stmt.setInt(2, livroId);

        stmt.executeUpdate();
    }
}






