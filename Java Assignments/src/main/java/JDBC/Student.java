package JDBC;

/*
create table Student (
	id integer not null auto_increment,
    name varchar (25),
    school_id integer,
    primary key (id),
    foreign key (school_id) references School(id)
    );
 */

public class Student {

    private Integer id;
    private String name;
    private Integer school_id;

    public Student (Integer id, String name, Integer school_id) {
        this.id = id;
        this.name = name;
        this.school_id = school_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSchool_id() {
        return school_id;
    }

    public void setSchool_id(Integer school_id) {
        this.school_id = school_id;
    }

    @Override
    public String toString() {
        return "Student name: " + this.name + ", Student Id: " + this.id + ", School id: " + this.school_id;
    }
}
