package JDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SchoolDao extends GenericDao{

    public SchoolDao(String tableName) {
        super(tableName);
    }

    public boolean createTable() throws SQLException, ClassNotFoundException {
        /**
         create table School (
         id integer,
         name varchar(25),
         primary key (id)
         );
         */
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(connectionUrl);
            boolean tableExists = tableExistsOnConn(conn);
            if (tableExists) return false;

            Statement stmt = conn.createStatement();
            stmt.executeUpdate("CREATE TABLE " + tableName + " (\n" +
                    "   id int NOT NULL AUTO_INCREMENT,\n" +
                    "   name varchar(50) DEFAULT NULL,\n" +
                    "   PRIMARY KEY (id))");
            return true;
        } finally {
            if (conn != null) conn.close();
        }
    }

    public void insertSchools(List<School> schools) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(connectionUrl);

            String query = "insert into " + tableName + " set name = ?";
            PreparedStatement stmt = conn.prepareStatement(query);

            conn.setAutoCommit(false);

            for (School school: schools) {
                stmt.setString(1, school.getName());
                stmt.executeUpdate();
            }

            conn.commit();
            conn.setAutoCommit(true);
        } finally {
            if (conn != null) conn.close();
        }
    }

    public int insertSchool(School school) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(connectionUrl);

            String query = "insert into " + tableName + " set name = '" + school.getName() + "'";
            conn.setAutoCommit(false);

            Statement stmt = conn.createStatement();

            int numRows  = stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);

            int lastInsertedId = 0;
            if (numRows == 1) {
                ResultSet genKeys = stmt.getGeneratedKeys();
                if (genKeys.next()) {
                    lastInsertedId = genKeys.getInt(1);  // ResultSet should have exactly one column, the primary key of INSERT table.
                } else {
                    throw new SQLException("Could not get the schoolId");
                }
            } else {
                throw new SQLException("Could not get the schoolId");
            }

            conn.commit();
            conn.setAutoCommit(true);

            return lastInsertedId;
        } finally {
            if (conn != null) conn.close();
        }
    }

    public void updateSchool(Integer id, String name) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/hb_student_tracker?" +
                    "user=root&password=StrongPassword1$");

            Statement stmt = conn.createStatement();
            stmt.executeUpdate("update " + tableName + " set name = '" + name +
                    "' where id = '" + id + "'");
        } finally {
            if (conn != null) conn.close();
        }
    }

    public void deleteSchool(Integer id) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(connectionUrl);
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("delete from " + tableName + " where id = '" + id + "'");
        } finally {
            if (conn != null) conn.close();
        }
    }

    public List<School> getSchools(String tableName) throws SQLException {
        List<School> schools = null;
        Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(connectionUrl);

            Statement stmt = con.createStatement();
            ResultSet rset = stmt.executeQuery("select id, name from " + tableName + ";");

            while (rset.next()) {
                if (schools == null) schools = new ArrayList<School>();
                Integer id = rset.getInt(1);
                String name = rset.getString(2);
                School school = new School(id, name);
                schools.add(school);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (con != null) con.close();
        }

        return  schools;
    }
}
