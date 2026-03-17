package org.example;

import java.util.Scanner;

import org.example.control.Controller;
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



        EmprestimosDao emprestimosDao = new EmprestimosDao(conn);
        UsuariosDao usuarioDao = new UsuariosDao(conn);
        LivrosDao livrosDao = new LivrosDao(conn);


        Scanner scanner = new Scanner(System.in); // permite ler o que o usuário digita
        int opcao = -1; // variável que guarda a opção escolhida

        while (opcao != 0) { // o programa roda até o usuário escolher sair

            System.out.println("\n=== SISTEMA BIBLIOTECA ===");
            System.out.println("1 - Cadastrar usuário");
            System.out.println("2 - Cadastrar livro");
            System.out.println("3 - Registrar empréstimo");
            System.out.println("4 - Listar empréstimos");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt(); // lê o número digitado

            switch (opcao) {

                case 1:
                    scanner.nextLine();

                    System.out.println("Digite o nome do usuario que vai ser cadastrado:");
                    String nome = scanner.nextLine();
                    Usuario usuario = new Usuario();

                    usuario.setNome(nome);
                    usuarioDao.inserir(usuario);
                    break;

                case 2:
                    scanner.nextLine();

                    System.out.println("Digite o nome do livro que vai ser cadastrado:");
                    String titulo = scanner.nextLine();
                    System.out.println("Digite o autor desse livro:");
                    String autor = scanner.nextLine();
                    System.out.println("Esse livro esta disponivel?");
                    Boolean disponivel = Boolean.parseBoolean(scanner.nextLine());

                    Livro livro = new Livro();
                    livro.setTitulo(titulo);
                    livro.setAutor(autor);
                    livro.setDisponivel(disponivel);
                    livrosDao.inserir(livro);
                    break;
                case 3:
                    scanner.nextLine();

                    System.out.println("ID do usuário:");
                    int usuarioId = scanner.nextInt();

                    System.out.println("ID do livro:");
                    int livroId = scanner.nextInt();

                    Emprestimos emprestimo = new Emprestimos();

                    emprestimo.setUsuarioId(usuarioId);
                    emprestimo.setLivroId(livroId);
                    emprestimo.setDataEmprestimo(new Date(System.currentTimeMillis()));

                    emprestimosDao.registrarEmprestimo(emprestimo);
                    Boolean sucesso = emprestimosDao.registrarEmprestimo(emprestimo);

                    if (sucesso) {
                        System.out.println("Empréstimo realizado com sucesso!");
                    } else {
                        System.out.println("Livro indisponível!");
                    }
                    break;

                case 4:
                    System.out.println("Listando empréstimos...");
                    emprestimosDao.ListarEmprestimos();
                    break;

                case 0:
                    System.out.println("Saindo do sistema...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        }






       // Controller controller = new Controller();
        //SIMULANDO O HTTP

       // System.out.println("ANTES DO CONTROLLER");
      //  controller.handleRequest("POST", "/livros");
      //  System.out.println("DEPOIS DO CONTROLLER");
    }


    //usuario.setNome("Eduardo");
    // usuarioDao.inserir(usuario);

    //emprestimo.setUsuarioId(7);
    // emprestimo.setLivroId(16);

    // emprestimo.setDataEmprestimo(Date.valueOf("2026-03-12"));


    // livro.setTitulo("Clean Code");
    // livro.setAutor("Robert Martin");
    //livro.setDisponivel(true);
    //dao.inserir(livro);

    // emprestimosDao.registrarEmprestimo(emprestimo);

    // System.out.println("Empréstimo registrado!");


}

