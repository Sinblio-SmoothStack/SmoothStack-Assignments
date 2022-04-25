package Demo_2.Daos;

import Demo_2.Objects.Airport;
import Demo_2.Objects.Flight;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import Demo_2.Objects.DBTableObject;

public class TableDao extends ViewDao{

    public void insert(DBTableObject toInsert) throws ClassNotFoundException, SQLException {
        Connection conn = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            PreparedStatement stmt = conn.prepareStatement(toInsert.insertQuery());

            conn.setAutoCommit(false);

            toInsert.statementFunction().process(stmt);
            stmt.executeUpdate();

            conn.commit();

            conn.setAutoCommit(true);
        } finally {
            if (conn != null) conn.close();
        }
    }

    public void insertAll(List<DBTableObject> toInsertList) throws ClassNotFoundException, SQLException {
        Connection conn = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            PreparedStatement stmt = conn.prepareStatement(toInsertList.get(0).insertQuery());

            conn.setAutoCommit(false);

            for (DBTableObject toInsert : toInsertList) {
                toInsert.statementFunction().process(stmt);
                stmt.executeUpdate();
            }

            conn.commit();

            conn.setAutoCommit(true);
        } finally {
            if (conn != null) conn.close();
        }
    }

    public void update(DBTableObject toUpdate) throws  SQLException, ClassNotFoundException {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            conn.setAutoCommit(false);

            Statement stmt = conn.createStatement();
            stmt.executeUpdate(toUpdate.updateQuery());

            conn.commit();
            conn.setAutoCommit(true);
        } finally {
            if (conn != null) conn.close();
        }
    }

    public void delete(DBTableObject toDelete) throws  SQLException, ClassNotFoundException {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            Statement stmt = conn.createStatement();

            conn.setAutoCommit(false);

            stmt.executeUpdate(toDelete.deleteQuery());

            conn.commit();
            conn.setAutoCommit(true);
        } finally {
            if (conn != null) conn.close();
        }
    }
}
