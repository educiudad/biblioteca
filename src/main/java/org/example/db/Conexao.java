package org.example.db;

import java.sql.Connection;


import java.sql.DriverManager;

public class Conexao {

    public static Connection conectar() {

        try {

            String url = "jdbc:mysql://localhost:3306/biblioteca";
            String user = "root";
            String password = "Vanda1107.";

            Connection conn = DriverManager.getConnection(url, user, password);

            System.out.println("Conectado ao banco!");

            return conn;

        } catch (Exception e) {

            e.printStackTrace();
            return null;

        }

    }

}