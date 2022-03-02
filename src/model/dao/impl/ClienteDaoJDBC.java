package model.dao.impl;

import db.DB;
import db.DbException;
import model.dao.ClienteDao;
import model.entities.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ClienteDaoJDBC implements ClienteDao {

    private Connection conn;

    public ClienteDaoJDBC (Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Cliente cliente) {

    }

    @Override
    public void update(Cliente cliente) {

    }

    @Override
    public void deleteById(Integer id) {

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
        return null;
    }
}
