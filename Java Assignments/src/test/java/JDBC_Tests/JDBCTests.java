package JDBC_Tests;

import JDBC.*;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class JDBCTests {


    @Test
    public void createTables() throws SQLException, ClassNotFoundException {
        String schoolTableName = "schools";
        String studentTableName = "students";

        StudentDao studentDao = new StudentDao(studentTableName);
        SchoolDao schoolDao = new SchoolDao(schoolTableName);

        if (studentDao.tableExists())
            studentDao.dropTable();
        if (schoolDao.tableExists())
            schoolDao.dropTable();

        System.out.println("Creating table: schools");
        assert(schoolDao.createTable());
        System.out.println("Successfully created: schools");

        System.out.println("Creating table: students");
        assert(studentDao.createTable(schoolTableName));
        System.out.println("Successfully created: students");

        studentDao.dropTable();
        schoolDao.dropTable();
    }

    @Test
    public void deleteTables() throws SQLException, ClassNotFoundException {
        String schoolTableName = "schools";
        String studentTableName = "students";

        StudentDao studentDao = new StudentDao(studentTableName);
        SchoolDao schoolDao = new SchoolDao(schoolTableName);

        if (!schoolDao.tableExists())
            schoolDao.createTable();
        if (!studentDao.tableExists())
            studentDao.createTable(schoolTableName);

        System.out.println("Creating deleted: students");
        studentDao.dropTable();
        assert(!studentDao.tableExists());
        System.out.println("Successfully deleted: students");

        System.out.println("Deleting table: schools");
        schoolDao.dropTable();
        assert(!studentDao.tableExists());
        System.out.println("Successfully deleted: schools");
    }

    @Test
    public void testTransaction() throws SQLException, ClassNotFoundException{
        String schoolTableName = "schools";
        String studentTableName = "students";

        SchoolDao schoolDao = new SchoolDao(schoolTableName);
        StudentDao studentDao = new StudentDao(studentTableName);

        if (studentDao.tableExists())
            studentDao.dropTable();

        if (schoolDao.tableExists())
            schoolDao.dropTable();

        schoolDao.createTable();
        studentDao.createTable(schoolTableName);

        List<School> schools = Arrays.asList(
                new School(0, "Green Oaks High School"),
                new School(0, "West High School"),
                new School(0, "Iowa State University")
        );

        int greenOaksId = 0;

        for (School school: schools) {
            school.setId(schoolDao.insertSchool(school));
            if (school.getName().equals("Green Oaks High School"))
                greenOaksId = school.getId();
            System.out.println(school);
        }

        List <Student> students = Arrays.asList(
                new Student(0, "Bob Anderson", greenOaksId),
                new Student(0, "Janet Collins", greenOaksId)
        );

        studentDao.insertStudents(students);

        for (Student student: studentDao.getStudents(studentTableName))
            System.out.println(student);

        studentDao.dropTable();
        schoolDao.dropTable();
    }
}
