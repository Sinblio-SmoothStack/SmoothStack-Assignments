package Demo_2.Daos;

import Demo_2.Objects.Airport;
import Demo_2.Objects.DBViewObject;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ViewDao<T extends DBViewObject> {
    protected static final String DB_URL = "jdbc:mysql://localhost/utopia";
    protected static final String DB_USER = "sstack";
    protected static final String DB_PASSWORD = "sstack";

    public List<DBViewObject> getAll(DBViewObject dbViewObject) throws ClassNotFoundException, SQLException {
        List<DBViewObject> results = null;
        Connection conn = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            Statement stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery("select * from " + dbViewObject.defaultTableName()+ ";");

            while (rset.next()) {
                if (results == null) results = new ArrayList<>();
                dbViewObject.resultSetFunction().process(rset, results);
            }
        } finally {
            if (conn != null) conn.close();
        }

        return results;
    }

    public List<DBViewObject> getAllFiltered(DBViewObject dbViewObject, String filter) throws ClassNotFoundException, SQLException {
        List<DBViewObject> results = null;
        Connection conn = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            Statement stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery("select * from " + dbViewObject.defaultTableName() + " where " + filter + ";");

            while (rset.next()) {
                if (results == null) results = new ArrayList<>();
                dbViewObject.resultSetFunction().process(rset, results);
            }
        } finally {
            if (conn != null) conn.close();
        }

        return results;
    }
}
