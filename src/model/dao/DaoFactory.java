package model.dao;

import db.DB;
import model.dao.impl.ClienteDaoJDBC;

public class DaoFactory {

    public static ClienteDao createClienteDao(){//Dessa forma não expõe a implementação
        return new ClienteDaoJDBC(DB.getConnection());
    }
}
