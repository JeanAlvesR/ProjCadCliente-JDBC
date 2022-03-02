package model.application;

import model.entities.Cliente;

public class Program {
    public static void main(String[] args) {
        Cliente cliente = new Cliente(1, "Jean");
        System.out.println(cliente);

    }
}
