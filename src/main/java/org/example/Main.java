package org.example;

import org.example.dao.EmprestimosDao;
import org.example.dao.LivrosDao;
import org.example.dao.UsuariosDao;
import org.example.db.Conexao;
import org.example.model.Emprestimos;
import org.example.model.Livro;
import org.example.model.Usuario;

import java.sql.*;
import java.util.List;

public class Main {

    public static void main(String[] args) throws SQLException {
        Connection conn = Conexao.conectar();

        Livro livro = new Livro();
        Usuario usuario = new Usuario();
        Emprestimos emprestimo = new Emprestimos();


        EmprestimosDao emprestimosDao = new EmprestimosDao(conn);
        UsuariosDao usuarioDao = new UsuariosDao(conn);
        LivrosDao dao = new LivrosDao(conn);

        //usuario.setNome("Eduardo");
       // usuarioDao.inserir(usuario);

        emprestimo.setUsuarioId(7);
        emprestimo.setLivroId(16);

        emprestimo.setDataEmprestimo(Date.valueOf("2026-03-12"));




       // livro.setTitulo("Clean Code");
       // livro.setAutor("Robert Martin");
        //livro.setDisponivel(true);
        //dao.inserir(livro);

        emprestimosDao.registrarEmprestimo(emprestimo);

        System.out.println("Empréstimo registrado!");




    }

}