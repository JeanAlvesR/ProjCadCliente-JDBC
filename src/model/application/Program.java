package model.application;

import model.dao.ClienteDao;
import model.dao.DaoFactory;
import model.entities.Cliente;

public class Program {
    public static void main(String[] args) {

        ClienteDao clienteDao = DaoFactory.createClienteDao();
        Cliente cliente = new Cliente(1, "Jean");
        System.out.println(cliente);

    }
}
