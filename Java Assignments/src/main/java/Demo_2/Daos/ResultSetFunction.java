package Demo_2.Daos;

import Demo_2.Objects.DBViewObject;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@FunctionalInterface
public interface ResultSetFunction {
    void process(ResultSet rset, List<DBViewObject> list) throws SQLException;
}
