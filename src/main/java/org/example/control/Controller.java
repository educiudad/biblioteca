package org.example.control;

import org.example.dao.LivrosDao;
import org.example.db.Conexao;
import org.example.model.Livro;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Controller {
    public void handleRequest(String metodo, String rota) throws SQLException {
        Connection conn = Conexao.conectar();
        LivrosDao livrosDao = new LivrosDao(conn);

        if(metodo.equals("POST") && rota.equals("/livros") ){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Digite o titulo do livro");
            String titulo1 = scanner.nextLine();
            System.out.println("teste");
            Livro livro = new Livro();
            livro.setTitulo(titulo1);
            livrosDao.inserir(livro);



        }


    }

}
