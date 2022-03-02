package model.dao.impl;

import db.DB;
import db.DbException;
import model.dao.ClienteDao;
import model.entities.Cliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDaoJDBC implements ClienteDao {

    private Connection conn;

    public ClienteDaoJDBC (Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Cliente cliente) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("INSERT INTO clientes (name) VALUES (?)", Statement.RETURN_GENERATED_KEYS);
            st.setString(1, cliente.getName());

            int rowsAffected = st.executeUpdate();

            if(rowsAffected>0){
                ResultSet rs = st.getGeneratedKeys();
                if(rs.next()){
                    int id = rs.getInt(1);
                    cliente.setId(id);
                }
                DB.closeResultSet(rs);
            }
            else {
                throw new DbException("Unexpected error! No rows affected!");
            }

        }
        catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
        }

    }
    @Override
    public void update(Cliente cliente) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("UPDATE clientes SET Name = ? WHERE Id = ?");
            st.setString(1, cliente.getName());
            st.setInt(2, cliente.getId());
            st.executeUpdate();
        }
        catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
        }

    }

    @Override
    public void deleteById(Integer id) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("DELETE FROM clientes WHERE Id = ?");
            st.setInt(1, id);
            int rows = st.executeUpdate();

            if(rows==0){
                throw new DbException("Unexpected error! No rows affected!");
            }

        }
        catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
        }

    }

    @Override
    public Cliente findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            st = conn.prepareStatement("SELECT * from clientes WHERE Id = ?");
            st.setInt(1, id);
            rs = st.executeQuery();
            if(rs.next()){
                String name = rs.getString("Name");
                Cliente cliente = new Cliente();
                cliente.setId(id);
                cliente.setName(name);
                return cliente;
            }
            return null;
        }
        catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
        }
    }

    @Override
    public List<Cliente> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            st = conn.prepareStatement("SELECT * from clientes ORDER by Id");
            rs = st.executeQuery();
            List<Cliente> list = new ArrayList<>();
            while(rs.next()){
                String name = rs.getString("Name");
                int id = rs.getInt("Id");
                Cliente cliente = new Cliente();
                cliente.setId(id);
                cliente.setName(name);
                list.add(cliente);
            }
            return list;
        }
        catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
        }
    }
}
