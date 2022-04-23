package JDBC;

import java.sql.*;
import java.util.List;

public class GenericDao {
    protected static String connectionUrl = "jdbc:mysql://localhost/smoothstack?user=sstack&password=sstack";
    protected String tableName;

    public GenericDao(String tableName) {
        this.tableName = tableName;
    }

    protected boolean tableExistsOnConn(Connection conn) throws SQLException {
        DatabaseMetaData dbmd = conn.getMetaData();
        ResultSet resultSet = dbmd.getTables(null, null, tableName, new String[] {"TABLE"});
        return resultSet.next();
    }

    public boolean tableExists() throws SQLException, ClassNotFoundException {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(connectionUrl);
            return tableExistsOnConn(conn);
        } finally {
            if (conn != null) conn.close();
        }
    }

    public void dropTable() throws SQLException, ClassNotFoundException {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(connectionUrl);
            boolean tableExists = tableExistsOnConn(conn);
            if (tableExists) {
                Statement stmt = conn.createStatement();
                stmt.executeUpdate("drop table " + tableName);
            }
        } finally {
            if (conn != null) conn.close();
        }
    }

    public void deleteAll() throws SQLException, ClassNotFoundException {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(connectionUrl);
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("delete from " + tableName);
        } finally {
            if (conn != null) conn.close();
        }
    }

    public String getTableName() {
        return tableName;
    }
}
