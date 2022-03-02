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
        Cliente cliente = clienteDao.findById(3);
        System.out.println("Procurando por id");
        System.out.println(cliente);
        //teste find all
        System.out.println();
        System.out.println("LISTANDO TODOS");
        List<Cliente> list = clienteDao.findAll();
        for (Cliente x:
             list) {
            System.out.println(x);
        }


    }
}
