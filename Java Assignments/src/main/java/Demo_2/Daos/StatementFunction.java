package Demo_2.Daos;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

@FunctionalInterface
public interface StatementFunction {
    void process(PreparedStatement s) throws SQLException;
}
