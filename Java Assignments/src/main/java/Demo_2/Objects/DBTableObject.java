package Demo_2.Objects;

import Demo_2.Daos.StatementFunction;

public interface DBTableObject extends DBViewObject{
    StatementFunction statementFunction();
    String insertQuery();
    String updateQuery();
    String deleteQuery();
    DBTableObject createNew();
    DBTableObject updateThis();
}
