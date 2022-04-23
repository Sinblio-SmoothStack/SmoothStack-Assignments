package JDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDao extends GenericDao{

    public StudentDao(String tableName) {
        super(tableName);
    }

    public boolean createTable(String schoolTableName) throws SQLException, ClassNotFoundException {
        /**
         create table Student (
         id integer not null auto_increment,
         name varchar (25),
         school_id integer,
         primary key (id),
         foreign key (school_id) references School(id)
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
                    "id int NOT NULL AUTO_INCREMENT,\n" +
                    "name varchar(50) DEFAULT NULL,\n" +
                    "school_id int DEFAULT 0,\n" +
                    "PRIMARY KEY (id)," +
                    "FOREIGN KEY (school_id) REFERENCES " + schoolTableName + "(id))");
            return true;
        } finally {
            if (conn != null) conn.close();
        }
    }

    public int insertStudent(Student student) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(connectionUrl);

            String query = "insert into " + tableName + " set name = ?, school_id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);

            conn.setAutoCommit(false);


            stmt.setString(1, student.getName());
            stmt.setInt(2, student.getSchool_id());

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

    public void insertStudents(List<Student> students) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(connectionUrl);

            String query = "insert into " + tableName + " set name = ?, school_id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);

            conn.setAutoCommit(false);

            for (Student student: students) {
                stmt.setString(1, student.getName());
                stmt.setInt(2, student.getSchool_id());
                stmt.executeUpdate();
            }

            conn.commit();
            conn.setAutoCommit(true);
        } finally {
            if (conn != null) conn.close();
        }
    }

    public void updateStudent(Integer id, String name, Integer school_id) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(connectionUrl);

            Statement stmt = conn.createStatement();
            stmt.executeUpdate("update " + tableName + " set name = '" + name +
                    "', school_id = '" + school_id + "' where id = '" + id + "'");
        } finally {
            if (conn != null) conn.close();
        }
    }

    public void deleteStudent(Integer id) throws SQLException, ClassNotFoundException {
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

    public List<Student> getStudents(String tableName) throws SQLException {
        List<Student> students = null;
        Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(connectionUrl);

            Statement stmt = con.createStatement();
            ResultSet rset = stmt.executeQuery("select id, name, school_id FROM " + tableName + ";");
            while (rset.next()) {
                if (students == null) students = new ArrayList<Student>();
                Integer id = rset.getInt("id");
                String name = rset.getString("name");
                Integer school_id = rset.getInt("school_id");
                Student student = new Student(id, name, school_id);
                students.add(student);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (con != null) con.close();
        }

        return  students;
    }
}
