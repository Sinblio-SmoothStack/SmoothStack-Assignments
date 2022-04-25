package Demo_2.Objects;

import Demo_2.Daos.ResultSetFunction;
import Demo_2.Daos.StatementFunction;

public interface DBViewObject {
    ResultSetFunction resultSetFunction();
    String defaultTableName();
}
