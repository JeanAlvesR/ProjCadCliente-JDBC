package model.application;

import db.DB;
import model.dao.ClienteDao;
import model.dao.DaoFactory;
import model.entities.Cliente;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Program {
    public static void main(String[] args) {

        ClienteDao clienteDao = DaoFactory.createClienteDao();
        Cliente cliente = clienteDao.findById(3);/*
        System.out.println("Procurando por id");
        System.out.println(cliente);
        //teste find all
        System.out.println();*/
        System.out.println("LISTANDO TODOS");
        List<Cliente> list = clienteDao.findAll();
        for (Cliente x:
             list) {
            System.out.println(x);
        }

        System.out.println("INSERINDO ");
        cliente = new Cliente(null, "Ronaldo");
        clienteDao.insert(cliente);
        list = clienteDao.findAll();
        for (Cliente x:
                list) {
            System.out.println(x);
        }
        System.out.println("Inserted! New id = "+cliente.getId()); //Isso aqui só dá certo, pois é passagem por referência.

        /*
        System.out.println();
        System.out.println("UPDATE");
        clienteDao.update(new Cliente(1, "Getulio"));
        clienteDao.update(new Cliente(4, "Lebron James"));

        list = clienteDao.findAll();
        for (Cliente x:
                list) {
            System.out.println(x);
        }
*/


    }
}
