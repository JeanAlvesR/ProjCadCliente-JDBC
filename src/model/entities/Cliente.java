package model.entities;

import java.io.Serializable;
import java.util.Objects;

public class Cliente implements Serializable {

    private Integer Id;
    private String name;

    public Cliente(){}


    public Cliente(Integer id, String name) {
        Id = id;
        this.name = name;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //Utilizando para comparar com o nome
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return name.equals(cliente.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                '}';
    }
}
